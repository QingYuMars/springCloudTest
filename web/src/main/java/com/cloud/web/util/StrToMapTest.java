package com.cloud.web.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class StrToMapTest {

    public static void main(String[] args) {
        test01();
        test02();
        test03();
    }

    public static void test01() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "wjw");
        jsonObject.put("age", 22);
        jsonObject.put("sex", "男");
        jsonObject.put("school", "商职");
        String jsonStr = JSONObject.toJSONString(jsonObject);
        System.out.println(jsonStr);
    }

    public static void test02(){
        String jsonStr = "{\"school\":\"商职\",\"sex\":\"男\",\"name\":\"wjw\",\"age\":22}";
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        System.out.println(jsonObject.getString("name"));
        System.out.println(jsonObject.getInteger("age"));
    }

    public static void test03(){
        Map<String,String> map = new HashMap<>();
        map.put("user_id","152546585545");
        map.put("school_id",String.valueOf(152546585545L));
        String jsonStr = JSON.toJSONString(map);
        System.err.println(jsonStr);
        HashMap hashMap = JSON.parseObject(jsonStr, HashMap.class);
        System.err.println(hashMap.get("user_id"));
    }

}
