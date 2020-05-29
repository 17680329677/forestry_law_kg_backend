package com.dhz.forestry_law_kg_backend.Controller;


import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hezhe.du
 * @version 1.0
 * @date 2020/05/22 11:51
 */

@Controller
@RequestMapping("/forestry_law")
public class KnowledgeGraphController {

    String BaseUrl = "http://127.0.0.1:5000";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/draw")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public Map<String, Object> search(@RequestParam("entityName")String entityName) {
        Map<String, Object> map = new HashMap<>();
        String getDrawInfoUrl = BaseUrl + "/forestry_law_draw/draw_info?entity=" + entityName;
        String results = restTemplate.getForObject(getDrawInfoUrl, String.class);
        Map res = (Map) JSON.parse(results);
        if (res.containsKey("status") && Integer.parseInt(res.get("status").toString()) == 200) {
            map.put("code", 0);
            map.put("data", res.get("data"));
        } else {
            String message = res.get("message").toString();
            map.put("code", 1001);
            map.put("message", message);
        }
        return map;
    }
}
