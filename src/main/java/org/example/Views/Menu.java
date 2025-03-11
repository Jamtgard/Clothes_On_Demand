package org.example.Views;

import org.example.Models.Business.Order;
import org.example.Models.Clothing.ArticleType;
import org.example.Models.Service.OrderService;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final OrderService orderService;
    private Order currentOrder;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.orderService = OrderService.getInstance();
    }

    public void start() {
        selectCustomer();
        processOrder();
    }

    private void selectCustomer() {
        int choice = printMenu("Välj användare", new String[]{
                "Simon",
                "Michael",
                "Louis Vuitton"
        });

        switch (choice) {
            case 1:
                currentOrder = orderService.createOrder("Simon", "Malmö", "simon@email.com");
                break;
            case 2:
                currentOrder = orderService.createOrder("Michael", "Ånge", "michael@email.com");
                break;
            case 3:
                currentOrder = orderService.createOrder("Louis Vuitton", "Paris", "louis@email.com");
                break;
        }
        System.out.println("Inloggad som: " + currentOrder.getCustomerName());
    }

    private void processOrder() {
        boolean running = true;
        while (running) {
            addClothingItem();

            int choice = printMenu("Välj nästa steg", new String[]{
                    "Lägg till ett nytt plagg",
                    "Beställ order",
                    "Avbryt order"
            });

            switch (choice) {
                case 1:
                    break;
                case 2:
                    orderService.confirmOrder(currentOrder);
                    running = false;
                    return;
                case 3:
                    System.out.println("Order avbruten!");
                    running = false;
                    return;
            }
        }
    }

    private void addClothingItem() {
        int typeChoice = printMenu("Välj plagg", new String[]{
                "Byxor (499.99 SEK)",
                "T-shirt (199.99 SEK)",
                "Kjol (299.99 SEK)"
        });

        String type;
        double price;

        switch (typeChoice) {
            case 1:
                type = "PANTS";
                price = 499.99;
                break;
            case 2:
                type = "TSHIRT";
                price = 199.99;
                break;
            case 3:
                type = "SKIRT";
                price = 299.99;
                break;
            default:
                return;
        }

        String size = menuSharedValues("Välj storlek", new String[]{"S", "M", "L"});
        String material = menuSharedValues("Välj material", new String[]{"Bomull", "Polyester", "Silke"});
        String color = menuSharedValues("Välj färg", new String[]{"Röd", "Blå", "Svart"});

        String[] uniqueValues = menuUniqueValues(ArticleType.valueOf(type));
        String specificOne = uniqueValues[0];
        String specificTwo = uniqueValues[1];

        currentOrder.addItem(type, size, material, color, price, specificOne, specificTwo);
        System.out.println("Plagg tillagt i ordern.");
    }

    private String menuSharedValues(String prompt, String[] options) {
        while (true) {
            System.out.println("\n*** " + prompt + " ***");
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
            System.out.print("Välj alternativ: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice >= 1 && choice <= options.length) {
                    return options[choice - 1];
                }
            } else {
                scanner.nextLine();
            }
            System.out.println("Ogiltigt val! Försök igen.");
        }
    }

    private String[] menuUniqueValues(ArticleType type) {
        String specificOne = "";
        String specificTwo = "";

        if (type == ArticleType.PANTS) {
            specificOne = menuSharedValues("Välj passform", new String[]{"Slim", "Regular"});
            specificTwo = menuSharedValues("Välj längd", new String[]{"Lång", "Kort"});
        } else if (type == ArticleType.TSHIRT) {
            specificOne = menuSharedValues("Välj ärmtyp", new String[]{"Kort", "Lång"});
            specificTwo = menuSharedValues("Välj halsringning", new String[]{"Rund", "V-ringad"});
        } else if (type == ArticleType.SKIRT) {
            specificOne = menuSharedValues("Välj midjetyp", new String[]{"Hög", "Låg"});
            specificTwo = menuSharedValues("Välj mönster", new String[]{"Randig", "Blommig"});
        }

        return new String[]{specificOne, specificTwo};
    }

    private int printMenu(String title, String[] options) {
        while (true) {
            System.out.println("\n*** " + title + " ***");
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
            System.out.print("Välj alternativ: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice >= 1 && choice <= options.length) {
                    return choice;
                }
            } else {
                scanner.nextLine();
            }
            System.out.println("Ogiltigt val! Försök igen.");
        }
    }
}
