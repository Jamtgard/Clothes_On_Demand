package org.example.Models.Service;

import org.example.Models.Business.Customer;
import org.example.Models.Business.Order;
import org.example.Models.Clothing.ArticleType;
import org.example.Models.Command.*;
import org.example.Models.Observer.CEO;
import org.example.Views.Receipt;

import java.util.HashMap;
import java.util.Map;

public class OrderService {
    private static OrderService instance;

    private final AddFeaturePipeline pantsPipeline;
    private final AddFeaturePipeline tshirtPipeline;
    private final AddFeaturePipeline skirtPipeline;

    private final Map<ArticleType, AddFeaturePipeline> pipelines = new HashMap<>();


    private OrderService() {

        pantsPipeline = new AddFeaturePipeline();
        pantsPipeline.addCommand(new FitCommand());
        pantsPipeline.addCommand(new LengthCommand());

        tshirtPipeline = new AddFeaturePipeline();
        tshirtPipeline.addCommand(new SleevesCommand());
        tshirtPipeline.addCommand(new NeckCommand());

        skirtPipeline = new AddFeaturePipeline();
        skirtPipeline.addCommand(new WaistlineCommand());
        skirtPipeline.addCommand(new PatternCommand());

        pipelines.put(ArticleType.PANTS, pantsPipeline);
        pipelines.put(ArticleType.TSHIRT, tshirtPipeline);
        pipelines.put(ArticleType.SKIRT, skirtPipeline);

    }

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
        order.setPipelines(pipelines);
        order.confirmOrder();

        new Receipt(order).printReceipt();
    }
}
