package com.myProject.orderservice.repository;

import com.myProject.orderservice.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long> {

Orders findOrdersByOrderId(String orderId);

}
