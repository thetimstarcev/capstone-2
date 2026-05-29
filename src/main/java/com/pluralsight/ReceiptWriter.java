package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReceiptWriter {
    public String getOrder(Order order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String header = """
                =========================================
                         DELIcious Sandwich Shop
                =========================================
                Order number:""" + " " + order.getOrderNumber() +
                "\nOrder Date: " + order.getOrderTime().format(formatter);

        String body = """
                \n-----------------------------------------
                ITEMS ORDERED:
                -----------------------------------------
                """;

        List<MenuItem> orderedItems = new ArrayList<>(order.getItems());
        Collections.reverse(orderedItems);
        for (MenuItem item : orderedItems) {
            if (item instanceof Sandwich) {
                Sandwich sandwich = (Sandwich) item;
                body += sandwich.getName() + "\n";
                for (Meat meat : sandwich.getMeats()) {
                    body += "-" + meat.getName() + "\n";
                }
                for (Cheese cheese : sandwich.getCheeses()) {
                    body += "-" + cheese.getName() + "\n";
                }
                for (Ingredients ingredients : sandwich.getRegularIngredients()) {
                    body += "-" + ingredients.getName() + "\n";
                }
                body += String.format("Price: $%.2f%n%n", sandwich.getPrice());
            } else if (item instanceof Drink) {
                Drink drink = (Drink) item;
                body += drink.getName() + "\n";
                body += String.format("Price: $%.2f%n%n", drink.getPrice());
            } else if (item instanceof Chips) {
                Chips chips = (Chips) item;
                body += chips.getName() + "\n";
                body += String.format("Price: $%.2f%n%n", chips.getPrice());
            }
        }

        String footer =
                "-----------------------------------------\n" +
                        String.format("TOTAL: $%.2f", order.calculateTotal()) +
                        "\n-----------------------------------------\n" +
                        "   Thank you for choosing DELIcious!\n" +
                        "=========================================";
        return header + body + footer;
    }

    /**
     * Writes the completed order receipt to a .txt file.
     * Uses getOrderPlain() to avoid color codes appearing in the file.
     * Uses try-with-resources to ensure the writer is always closed properly.
     *
     * @param order the completed Order to save
     */
    public void writeReceipt(Order order) {
        LocalDateTime time = order.getOrderTime();
        // HH = 24-hour format to prevent two receipts sharing the same filename
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String fileName = time.format(formatter) + ".txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/receipts/" + fileName));
            String finalReceipt = getOrder(order);
            writer.write(finalReceipt);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error getting your receipt");
            ;
        }
    }
}