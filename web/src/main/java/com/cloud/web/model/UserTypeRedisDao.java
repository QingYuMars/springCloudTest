package com.cloud.web.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class UserTypeRedisDao {

    private String userId;

    private String schoolId;

    private String userType;


}
