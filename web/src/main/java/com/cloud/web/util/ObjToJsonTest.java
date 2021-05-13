package com.cloud.web.util;

import com.alibaba.fastjson.JSON;
import com.cloud.web.model.Student;
import com.cloud.web.model.UserTypeRedisDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ObjToJsonTest {
    public static void main(String[] args) {
        test();
    }

    /**
     * fastjson漏洞较多，不安全，不推荐使用
     */
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

    /**
     *  net.sf.json.JSONArray
     */
    /*public static void convertObject(){
        UserTypeRedisDao userTypeRedisDao = new UserTypeRedisDao();
        userTypeRedisDao.setUserId("55555555");
        userTypeRedisDao.setSchoolId("1");
        userTypeRedisDao.setUserType("Teacher");
        //1、使用JSONObject
        JSONObject json = JSONObject.fromObject(stu);
        //2、使用JSONArray
        JSONArray array=JSONArray.fromObject(stu);
        String strJson=json.toString();
        String strArray=array.toString();
        System.out.println("strJson:"+strJson);
        System.out.println("strArray:"+strArray);
    }*/

    /*public static void jsonStrToJava(){
        //定义两种不同格式的字符串
        String objectStr="{\"name\":\"JSON\",\"age\":\"24\",\"address\":\"北京市西城区\"}";
        String arrayStr="[{\"name\":\"JSON\",\"age\":\"24\",\"address\":\"北京市西城区\"}]";
        //1、使用JSONObject
        JSONObject jsonObject=JSONObject.fromObject(objectStr);
        Student stu=(Student)JSONObject.toBean(jsonObject, Student.class);
        //2、使用JSONArray
        JSONArray jsonArray=JSONArray.fromObject(arrayStr);
        //获得jsonArray的第一个元素
        Object o=jsonArray.get(0);
        JSONObject jsonObject2=JSONObject.fromObject(o);
        Student stu2=(Student)JSONObject.toBean(jsonObject2, Student.class);
        System.out.println("stu:"+stu);
        System.out.println("stu2:"+stu2);
    }*/

    /*public static void listToJSON(){
        Student stu=new Student();
        stu.setName("JSON");
        stu.setAge("23");
        stu.setAddress("北京市海淀区");
        List<Student> lists=new ArrayList<Student>();
        lists.add(stu);
        //1、使用JSONObject
        //JSONObject listObject=JSONObject.fromObject(lists);
        //2、使用JSONArray
        JSONArray listArray=JSONArray.fromObject(lists);
        System.out.println("listArray:"+listArray.toString());
    }*/

    /*public static void jsonToList(){
        String arrayStr="[{\"name\":\"JSON\",\"age\":\"24\",\"address\":\"北京市西城区\"}]";
        //转化为list
        List<Student> list2=(List<Student>)JSONArray.toList(JSONArray.fromObject(arrayStr), Student.class);
        for (Student stu : list2) {
            System.out.println(stu);
        }
        //转化为数组
        Student[] ss =(Student[])JSONArray.toArray(JSONArray.fromObject(arrayStr),Student.class);
        for (Student student : ss) {
            System.out.println(student);
        }
    }*/

}
