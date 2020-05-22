package com.dhz.forestry_law_kg_backend.Controller;

import com.alibaba.fastjson.JSON;
import com.dhz.forestry_law_kg_backend.DAO.Law;
import com.dhz.forestry_law_kg_backend.DAO.MongoDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hezhe.du
 * @version 1.0
 * @date 2020/05/22 11:51
 */

@Controller
@RequestMapping("/forestry_law")
public class SearchLawController {

    String BaseUrl = "http://127.0.0.1:5000";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private MongoDao mongoDao;

    @GetMapping("/search")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public Map<String, Object> search(@RequestParam("searchContent")String searchContent) {
        Map<String, Object> map = new HashMap<>();
        String question_url = BaseUrl + "/forestry_law_search/search?content=" + searchContent;
        String results = restTemplate.getForObject(question_url, String.class);
        Map res = (Map) JSON.parse(results);
        if (res.containsKey("status") && Integer.parseInt(res.get("status").toString()) == 200) {
            List<List> law_list = (List<List>)res.get("data");
            map.put("code", 0);
            List<Law> lawList = new ArrayList<Law>();
            int match_count = 0;
            for (int i = 0; i < law_list.size(); i++) {
                String law_name = law_list.get(i).get(0).toString();
                List<Law> list = mongoDao.findByName(law_name);
                if (list != null && list.size() > 0) {
                    Law law_info = list.get(0);
                    match_count++;
                    if (match_count <= 10) {
                        lawList.add(law_info);
                    } else {
                        break;
                    }
                }
            }
            map.put("data", lawList);
        } else {
            String message = res.get("message").toString();
            map.put("code", 1001);
            map.put("message", message);
        }
        return map;
    }

}
