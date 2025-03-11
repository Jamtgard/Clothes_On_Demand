package org.example.Models.Service;

import org.example.Models.Business.Customer;
import org.example.Models.Business.Order;
import org.example.Models.Observer.CEO;
import org.example.Views.Receipt;

public class OrderService {
    private static OrderService instance;

    private OrderService() {}

    public static OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    public Order createOrder(String customerName, String address, String email) {
        Order order = new Order();
        order.initializeOrder(new Customer(customerName, address, email));

        CEO ceo = new CEO(1, "Wigell");
        order.addObserver(ceo);
        return order;
    }

    public void confirmOrder(Order order) {
        order.confirmOrder();

        Receipt receipt = new Receipt(order);
        receipt.printReceipt();
    }
}
