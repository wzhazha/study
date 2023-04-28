package org.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping(value = "/canload")
    public Map<String, Object> canLoad() {
        Map<String, Object> res = new HashMap<>();
        res.put("state", "OK");
        res.put("msg", "load success");
        return res;
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "111";
    }


}
