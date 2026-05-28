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
                body += "Price: $" + sandwich.getPrice() + "\n\n";
            } else if (item instanceof Drink) {
                Drink drink = (Drink) item;
                body += drink.getName() + "\n";
                body += "Price: $" + drink.getPrice() + "\n\n";
            } else if (item instanceof Chips) {
                Chips chips = (Chips) item;
                body += chips.getName() + "\n";
                body += "Price: $" + chips.getPrice() + "\n\n";
            }
        }

        String footer = """
                -----------------------------------------
                TOTAL: $""" + order.calculateTotal() +
                "\n-----------------------------------------\n" +
                "   Thank you for choosing DELIcious!\n" +
                "=========================================";
        return header + body + footer;
    }

    public void writeReceipt(Order order) {
        LocalDateTime time = order.getOrderTime();
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