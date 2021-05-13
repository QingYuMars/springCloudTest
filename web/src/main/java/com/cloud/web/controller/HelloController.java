package com.cloud.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * spring mvc获取header
 * 1.在方法参数中加入@RequestHeader
 * 2.在类级别注入HttpServletRequest
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value="/printname/{name}", method= RequestMethod.GET)
    public String printName(@PathVariable String name,
                            @RequestHeader HttpHeaders headers) {
        System.out.println("from request:" + request.getHeader("code"));
        System.out.println("from parameter:" + headers.getFirst("code"));
        return "hello";
    }
}
