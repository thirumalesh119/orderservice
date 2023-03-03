package com.myProject.orderservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myProject.orderservice.DTO.ProductDefaultDto;
import com.myProject.orderservice.DTO.ProductDto;
import com.myProject.orderservice.Entity.Orders;
import com.myProject.orderservice.Exceptions.OrderInValidException;
import com.myProject.orderservice.repository.OrdersRepository;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService{

    @Autowired
    private OrdersRepository ordersRepository;
    DefaultHttpClient httpClient = new DefaultHttpClient();

    public OrdersServiceImpl() throws IOException {
    }

    @Override
    public String createOrder(Orders order) {
        ordersRepository.save(order);
        return "Order has been created successfully";
    }

    @Override
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
   public ProductDefaultDto getAllProducts() throws IOException {
       HttpGet httpGet = new HttpGet("http://localhost:8085/api/getAllProducts");
       HttpResponse response = httpClient.execute(httpGet);
       HttpEntity entity = response.getEntity();
       String resp = EntityUtils.toString(entity);
       ObjectMapper objectMapper = new ObjectMapper();
       ProductDto[] productDtoList = objectMapper.readValue(resp, ProductDto[].class);
       List<ProductDto> productDtos = Arrays.asList(productDtoList);
       ProductDefaultDto productDefaultDto = new ProductDefaultDto(productDtos);
       return productDefaultDto;
   }
    public boolean isValid(Orders order) throws OrderInValidException, IOException {
        ProductDefaultDto productDefaultDto = getAllProducts();
        if(order.getProductId()==null||order.getOrderId()==null||order.getOrderedAmount()==0) {
            throw new OrderInValidException("Product Id can not be null, please provide valid productId");
        }
        else if(productDefaultDto.getProductDtoMap().get(order.getProductId())==null){
            throw new OrderInValidException("Product is not matched with our records");
        }
        else
            return true;
    }

    @Override
    public Orders getOrdersByOrderId(String orderId) {
        return ordersRepository.findOrdersByOrderId(orderId);
    }


}
