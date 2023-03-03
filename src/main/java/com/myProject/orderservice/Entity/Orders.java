package com.myProject.orderservice.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", productId='" + productId + '\'' +
                ", customerId=" + customerId +
                ", orderStatus='" + orderStatus + '\'' +
                ", qty=" + qty +
                ", orderedAmount=" + orderedAmount +
                '}';
    }

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="orderID")
    private String orderId;

    @Column(name="product_id")
    private String productId;

    @Column(name="customer_id")
    private Long customerId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Double getOrderedAmount() {
        return orderedAmount;
    }

    public void setOrderedAmount(Double orderedAmount) {
        this.orderedAmount = orderedAmount;
    }

    @Column(name="order_status")
    private String orderStatus;

    @Column(name="ordered_qty")
    private int qty;

    @Column(name="order_amount")
    private Double orderedAmount;
}
