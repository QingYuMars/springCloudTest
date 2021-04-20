package com.cloud.web.util;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfig {

    @Bean
    public Queue directQueue(){
        //队列名字，是否持久化
        return new Queue("direct",false);
    }

    @Bean
    public DirectExchange directExchange(){
        //交换器名称、是否持久化、是否自动删除
        return new DirectExchange("direct",false,false);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("direct");
    }
}
