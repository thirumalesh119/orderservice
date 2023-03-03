package com.myProject.orderservice.kafka;


import com.myProject.orderservice.Entity.Orders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {


    private static final
    Logger logger = LoggerFactory.getLogger(Producer.class);
    //private static final String TOPIC = "orders";
    private static final String TOPIC = "my-topic";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String message) {
        logger.info(String.format("#### -> Producing message -> %s", message));
        this.kafkaTemplate.send(TOPIC, message);
    }
    public void sendMessage(Orders order){
        this.kafkaTemplate.send("orders",order);

    }
}