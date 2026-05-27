package com.pluralsight;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReceiptWriter {
    public void writeReceipt(Order order) {
        LocalDateTime time = order.getOrderTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String fileName = time.format(formatter) + ".txt";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/receipts/" + fileName));
            String header = """
                =========================================
                         DELI-cious Sandwich Shop
                =========================================
                
                Order Date: """ + time;

            String body = """
                -----------------------------------------
                ITEMS ORDERED:
                -----------------------------------------
                """;

            List<MenuItem> orderedItems = order.getItems();
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
                    body += "Price: $" + chips.getPrice() +"\n\n";
                }
            }

            String footer = """
                -----------------------------------------
                TOTAL:          """ + order.calculateTotal() +
                    "\n-----------------------------------------\n" +
                    "   Thank you for choosing DELI-cious!\n" +
                    "=========================================";

            String finalReceipt = header + body + footer;
            writer.write(finalReceipt);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error getting your receipt");;
        }
    }
}

