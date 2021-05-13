package com.cloud.web.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Student {
    //姓名
    private String name;
    //年龄
    private String age;
    //住址
    private String address;
}
