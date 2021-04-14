package com.cloud.server.controller;

import com.cloud.server.service.TestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestServices testServices;

    @Value("${aa.bb}")
    String value;

    @RequestMapping("/get")
    public String get(@RequestParam("name") String name) {
        return testServices.get(name);
    }

    @RequestMapping("/values")
    public String value(){
        return "value:" + value;
    }
}