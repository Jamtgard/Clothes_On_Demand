package org.example.Models.Business;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {

    private static int orderCounter = 1;
    private int id;
    private String customerName;
    private List<OrderItem> orderItems;
    private OrderStatus status;

    public Order() {}
    public Order(Customer customer) {
        this.id = orderCounter++;
        this.customerName = customer.getName();
        this.orderItems = new ArrayList<>();
        this.status = OrderStatus.PENDING;
    }

    public void addItem(String type, String size, String material, String color, String specificOne, String specificTwo) {
        orderItems.add(new OrderItem(type, size, material, color, specificOne, specificTwo));
    }



    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getCustomerName() {return customerName;}
    public void setCustomerName(String customerName) {this.customerName = customerName;}

    public List<OrderItem> getOrderItems() {return orderItems;}
    public void setOrderItems(List<OrderItem> orderItems) {this.orderItems = orderItems;}

    public OrderStatus getStatus() {return status;}
    public void setStatus(OrderStatus status) {this.status = status;}


}
