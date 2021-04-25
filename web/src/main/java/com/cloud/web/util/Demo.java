package com.cloud.web.util;

import com.cloud.web.model.SmsLog;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class Demo {
    //获取d:/206workspace下的所有的目录以及子目录中以.java结尾的文件的绝对路径
    public static void main(String[] args) {
        /*File file = new File("d:/Myeclipse-2014/project/test01");
        Demo demo = new Demo();
        demo.getPath(file);*/
        //2021-04-21 15:01:40
        Date startTime = strToDateLong("2021-02-01 00:33:44");
        Date endTime = strToDateLong("2021-02-06 10:56:03");
        System.err.println(strToDateLong("2021-04-21 15:01:40"));
        System.err.println(dateToISODate(startTime));

        /*Query query = new Query(Criteria.where("class").is("一年级")
                .andOperator(
                        Criteria.where("startTime").lt(dateToISODate(startTime)),
                        Criteria.where("endTime").gte(dateToISODate(endTime))
                ));
        List<SmsLog> userList = mongoTemplate.find(query,SmsLog.class);*/

        /*String[] strs = "2021-04-21 15:01:40".split(" ");
        System.err.println(strs[0]);
        long timestamp = 1618904714*1000L;
        LocalDate localDate = Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDate();
        LocalDateTime localDateTime = Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        System.err.println(localDateTime);*/
    }

    /**
     * 将date转成ISODate 以便mongo识别
     * @param dateStr
     * @return
     */
    public static Date dateToISODate(Date dateStr) {
        Date parse = null;
        try {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            // 解析字符串时间
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            parse = format.parse(format.format(dateStr));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }


    /**
     * 如果是字符串需要先转成date 再调用 dateToISODate() 方法
     * @param strDate
     * @return
     */
    public static Date strToDateLong(String strDate) {
        Date strtodate = null;
        try {
            strtodate = null;
        /*DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(strDate, df);*/
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            strtodate = formatter.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return strtodate;
    }

    public void test(){
        String dateTimeStr = "2021-04-21 15:01:40";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, df);
        System.out.println(dateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.err.println(dateTime);
    }

    public void  getPath(File file){
        //返回该目录下的子目录以及文件对应的File实例
        File[] files = file.listFiles();
        for(File f:files){
            //判断是否是目录
            if(f.isDirectory()){
                getPath(f);
            }else{
                //判断文件名是否以.java结尾D:/Myeclipse-2014/project
                if(f.getName().endsWith(".java")){
                    //获取文件的绝对路径
                    System.out.println(f.getAbsolutePath());
                }
            }
        }
    }
}
