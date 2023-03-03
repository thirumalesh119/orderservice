package com.myProject.orderservice.kafka;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
//    public NewTopic topic(){
//        return TopicBuilder.name("orders").build();
//    }
    public NewTopic topic(){
        return TopicBuilder.name("com.faza.example.custom.listener.property").build();
    }


}
