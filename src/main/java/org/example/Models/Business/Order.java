package org.example.Models.Business;

import org.example.Models.Clothing.Article;
import org.example.Models.Builder.ArticleBuilder;
import org.example.Models.Clothing.ArticleType;
import org.example.Models.Command.AddFeatureCommand;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int orderCounter = 1;
    private int id;
    private String customerName;
    private List<String[]> selectedArticles;
    private List<Article> finalizedArticles;
    private OrderStatus status;
    private PropertyChangeSupport support;

    public Order() {
        this.selectedArticles = new ArrayList<>();
        this.finalizedArticles = new ArrayList<>();
        this.status = OrderStatus.PENDING;
        this.support = new PropertyChangeSupport(this);
    }

    public void initializeOrder(Customer customer) {
        this.id = orderCounter++;
        this.customerName = customer.getName();
    }

    public void addObserver(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void addItem(String type, String size, String material, String color, double price, String featureOne, String featureTwo) {
        selectedArticles.add(new String[]{type, size, material, color, String.valueOf(price), featureOne, featureTwo});
    }

    public void confirmOrder() {
        if (status == OrderStatus.CONFIRMED) {
            throw new IllegalStateException("Order " + id + " är redan bekräftad!");
        }

        for (String[] article : selectedArticles) {
            Article builtArticle = new ArticleBuilder()
                    .setArticleType(ArticleType.valueOf(article[0]))
                    .setSize(article[1])
                    .setMaterial(article[2])
                    .setColor(article[3])
                    .setPrice(Double.parseDouble(article[4]))
                    .build();

            support.firePropertyChange("builderCompleted", null, "Ett nytt plagg har byggts i order " + id);

            AddFeatureCommand addFeature = new AddFeatureCommand(article[5], article[6]);
            addFeature.execute(builtArticle);

            support.firePropertyChange("commandExecuted", null, "Command-mönstret har körts för ett plagg i order " + id);

            finalizedArticles.add(builtArticle);
        }

        this.status = OrderStatus.CONFIRMED;
        support.firePropertyChange("orderConfirmed", null, "Order " + id + " är nu färdig och redo för leverans!");
    }

    public int getId() { return id; }

    public String getCustomerName() { return customerName; }

    public List<Article> getFinalizedArticles() {
        return finalizedArticles;
    }
}
