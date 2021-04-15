package com.cloud.web.controller;

import com.cloud.server.apis.TestServicesApis;
import com.cloud.web.model.SmsLog;
import com.cloud.web.model.SmsParallel;
import com.cloud.web.service.SmsLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestWebController {

    @Autowired
    private TestServicesApis testServicesApis;

    @Autowired
    private SmsLogService smsLogService;

    @Value("${aa.bb}")
    String value;

    @RequestMapping("/getTest")
    public String getTest() {
        return testServicesApis.get("通过web调用的");
    }

    @RequestMapping("/hello")
    public String getHello(){
        return "Hello";
    }

    @RequestMapping("/value")
    public String value(){
        return "value:" + value;
    }

    @RequestMapping("/insertSmsLog")
    public String insertSmsLog(){
        SmsLog smsLog = smsLogService.insertSmsLog();
        if (smsLog.getId() != null) {
            smsLogService.updateSmsLog(smsLog.getId());
            return "succcess";
        }
        return "fail";
    }

    @RequestMapping("/query")
    public String query(){
        smsLogService.queryAllSmstype();
        return "success";
    }
}
