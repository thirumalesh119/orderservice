package com.myProject.orderservice.controller;

import com.myProject.orderservice.Entity.Orders;
import com.myProject.orderservice.Exceptions.OrderInValidException;
import com.myProject.orderservice.kafka.Producer;
import com.myProject.orderservice.service.OrdersService;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class OrdersController {


    @Autowired
    private OrdersService ordersService;

    @Autowired
    Producer producer;


    private DefaultHttpClient httpClient = new DefaultHttpClient();


    @PostMapping("/createorders")
    public String createOrder(@RequestBody Orders order) throws OrderInValidException, IOException {
        ordersService.isValid(order);
        String msg= ordersService.createOrder(order);
        producer.sendMessage("Message published");
        return msg;
    }

    @GetMapping("/getOrdersByOrderId/{orderId}")
    public Orders getOrdersById(@PathVariable String orderId){
        return ordersService.getOrdersByOrderId(orderId);
    }
}
