package com.cloud.web.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * SpringBoot单元测试如何回滚测试数据
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
@Transactional
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testQueryAttendanceSms() throws Exception{
        MvcResult result = mockMvc.perform(get("/attendance/queryAttendanceSms")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON)
                .param("phone","13522332092")
                .param("date","2021-04-23"))
                .andExpect(status().isOk())
                .andReturn();
        //处理返回值中文乱码
        result.getResponse().setCharacterEncoding("UTF-8");
        System.out.println(result.getResponse().getContentAsString());

        /*ResultActions resultActions = this.mockMvc.perform(get("/attendance/queryAttendanceSms")
                .accept(MediaType.APPLICATION_JSON)
                .param("phone","13522332092")
                .param("date","2021-04-23"));
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        System.err.println(resultActions.andReturn().getResponse().getContentAsString());*/
    }
}
