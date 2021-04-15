package com.cloud.web.model;

import lombok.Data;

@Data
public class SmsLog {

    private String id;

    private String sms;

    private String type;

    private String result;

    private String phone;

    private String templateId;

    private String insertTime;

}
