package com.dhz.forestry_law_kg_backend.Controller;

import com.alibaba.fastjson.JSON;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
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

    @GetMapping("/question")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public Map<Object, Object> question(@RequestParam("question") String question) {
        Map<Object, Object> map = new HashMap<>();
        String question_url = BaseUrl + "/forestry_law_qa/question?question=" + question;
        String results = restTemplate.getForObject(question_url, String.class);
        Map res = (Map)JSON.parse(results);
        map.put("code", 0);
        map.put("message", "success");
        map.put("res", res);
        return map;
    }
}
