package com.cloud.web.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cloud.web.model.UserTypeRedisDao;

import java.util.ArrayList;
import java.util.List;

public class ObjToJsonTest {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        List<UserTypeRedisDao> userTypeRedisDaoList = new ArrayList<>();
        UserTypeRedisDao userTypeRedisDao = new UserTypeRedisDao();
        userTypeRedisDao.setUserId("55555555");
        userTypeRedisDao.setSchoolId("1");
        userTypeRedisDao.setUserType("Teacher");
        userTypeRedisDaoList.add(userTypeRedisDao);
        System.err.println(JSON.toJSONString(userTypeRedisDao));
        String str = JSON.toJSONString(userTypeRedisDaoList);
        System.err.println(str);
    }
}
