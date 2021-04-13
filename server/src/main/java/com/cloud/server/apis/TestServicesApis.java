package com.cloud.server.apis;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(name = "server-service", contextId = "TestServicesApis")
public interface TestServicesApis {

    @RequestMapping("/test/get")
    public String get(@RequestParam("name") String name);
}