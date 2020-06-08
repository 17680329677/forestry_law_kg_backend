package com.dhz.forestry_law_kg_backend.Controller;

import com.alibaba.fastjson.JSON;
import com.dhz.forestry_law_kg_backend.DAO.Law;
import com.dhz.forestry_law_kg_backend.DAO.MongoDao;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.validation.constraints.Null;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hezhe.du
 * @version 1.0
 * @date 2019/12/2 11:51
 */

@Controller
@RequestMapping("/forestry_law")
public class QuestionAnswerController {

    String BaseUrl = "http://127.0.0.1:5000";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private MongoDao mongoDao;

    @GetMapping("/question")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public Map<Object, Object> question(@RequestParam("question") String question) {
        Map<Object, Object> map = new HashMap<>();
        String question_url = BaseUrl + "/forestry_law_qa/question?question=" + question;
        String results = restTemplate.getForObject(question_url, String.class);
        Map res = (Map)JSON.parse(results);
        if (res.containsKey("status") && Integer.parseInt(res.get("status").toString()) == 200) {
            map.put("code", 0);
            map.put("message", "success");
            map.put("data", res.get("data"));
        } else if (res.containsKey("status") && Integer.parseInt(res.get("status").toString()) == 101) {
            map.put("code", 1002);
            map.put("message", res.get("message").toString());
            map.put("data", res.get("data"));
        }else {
            String message = res.get("message").toString();
            map.put("code", 1001);
            map.put("message", message);
        }
        return map;
    }

    @GetMapping("/law_info")
    @ResponseBody
    public Map<Object, Object> count(@RequestParam("law_name")String law_name) {
        List<Law> list = mongoDao.findByName(law_name);
        Map<Object, Object> map = new HashMap<>();
        if (list != null && list.size() > 0) {
            Law law_info = list.get(0);
            map.put("code", 0);
            map.put("law_info", law_info);
        } else {
            map.put("code", 1001);
            map.put("message", "法律全文缺失！");
        }
        return map;
    }
}
