package org.example.Views;

import org.example.Models.Business.Order;
import org.example.Models.Clothing.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Receipt {

    private final int id;
    private final String customerName;
    private final List<Article> orderedItems;
    private final double totalPrice;

    public Receipt(Order order) {
        this.id = order.getId();
        this.customerName = order.getCustomerName();
        this.orderedItems = order.getFinalizedArticles();
        this.totalPrice = calculateTotalPrice();
    }

    public void printReceipt() {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String formattedDateTime = currentTime.format(formatter);

        double tax = totalPrice * 0.25;
        double priceExclTax = totalPrice - tax;

        System.out.println("\n********** KVITTO **********");
        System.out.println("Datum: " + formattedDateTime);
        System.out.println("Order-ID: " + id);
        System.out.println("Kund: " + customerName);
        System.out.println("----------------------------");
        System.out.println("Varor:");

        for (Article item : orderedItems) {
            System.out.printf(" %s%n", item.getClass().getSimpleName());
            System.out.printf("    ID: %-10d%n", item.getId());
            System.out.printf("    Size: %-10s%n", item.getSize());
            System.out.printf("    Material: %-10s%n", item.getMaterial());
            System.out.printf("    Color: %-10s%n", item.getColor());
            System.out.printf("    Price: %.2f SEK%n", item.getPrice());

            if (item instanceof Pants) {
                System.out.printf("    Fit: %-10s%n", ((Pants) item).getFit());
                System.out.printf("    Length: %-10s%n", ((Pants) item).getLength());
            } else if (item instanceof TShirt) {
                System.out.printf("    Sleeves: %-10s%n", ((TShirt) item).getSleeves());
                System.out.printf("    Neck: %-10s%n", ((TShirt) item).getNeck());
            } else if (item instanceof Skirt) {
                System.out.printf("    Waistline: %-10s%n", ((Skirt) item).getWaistline());
                System.out.printf("    Pattern: %-10s%n", ((Skirt) item).getPattern());
            }
            System.out.println();
        }

        System.out.println("----------------------------");
        System.out.printf("Exkl. moms:   %10.2f SEK%n", priceExclTax);
        System.out.printf("Moms (25%%):   %10.2f SEK%n", tax);
        System.out.println("----------------------------");
        System.out.printf("Totalt:       %10.2f SEK%n", totalPrice);
        System.out.println("Tack för ditt köp!");
        System.out.println("****************************\n");
    }


    private double calculateTotalPrice() {
        double total = 0;
        for (Article item : orderedItems) {
            total += item.getPrice();
        }
        return total;
    }

}
