package com.cloud.web.service;

import com.cloud.web.model.SmsLog;
import com.cloud.web.model.SmsParallel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SmsLogService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public SmsLog insertSmsLog(){
        SmsLog smsLog = new SmsLog();
        smsLog.setSms("Spring提供了对非关系数据库的集成，Spring的spring-data包提供了对mongoDB和redis集成的工具包");
        smsLog.setType("短信");
        smsLog.setPhone("12345667889");
        smsLog.setTemplateId("短信模板id");
        smsLog.setInsertTime(formatTime());
        return mongoTemplate.save(smsLog);
    }

    public void updateSmsLog(String id){
        Query query=new Query(Criteria.where("id").is(id));
        Update update= new Update().set("result", "success");
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query,update,SmsLog.class);
    }

    public Map<String,String> queryAllSmstype(){
        List<SmsParallel> smsParallels = mongoTemplate.findAll(SmsParallel.class);
        Map<String,String> smsParallelsMap = new HashMap<>();
        smsParallelsMap.put("attendance",smsParallels.get(0).getAttendance());
        smsParallelsMap.put("sms",smsParallels.get(0).getSms());
        smsParallelsMap.put("validation",smsParallels.get(0).getValidation());
        return smsParallelsMap;
    }

    public String formatTime(){
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String str2 = ldt.format(pattern);
        System.out.println(str2);
        return str2;
    }

}
