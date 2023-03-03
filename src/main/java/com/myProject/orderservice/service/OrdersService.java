package com.myProject.orderservice.service;


import com.myProject.orderservice.DTO.ProductDefaultDto;
import com.myProject.orderservice.Entity.Orders;
import com.myProject.orderservice.Exceptions.OrderInValidException;

import java.io.IOException;
import java.util.List;

public interface OrdersService {

    public String createOrder(Orders order);

    public List<Orders> getAllOrders();

    public ProductDefaultDto getAllProducts() throws IOException;

    public boolean isValid(Orders order) throws OrderInValidException, IOException, OrderInValidException;

    public Orders getOrdersByOrderId(String orderId);


}
