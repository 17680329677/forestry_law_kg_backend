package com.dhz.forestry_law_kg_backend.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hezhe.du
 * @version 1.0
 * @date 2019/12/2 11:51
 */

@Controller
@RequestMapping("/forestry_law")
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    public Map<Object, Object> test() {
        Map<Object, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("message", "success");
        map.put("test", "forestry law knowledge graph");
        return map;
    }
}
