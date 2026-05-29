package com.pluralsight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderNumber;
    private LocalDateTime orderTime;
    private List<MenuItem> items;

    public Order(String orderNumber, LocalDateTime orderTime) {
        this.orderNumber = orderNumber;
        this.orderTime = orderTime;
        this.items = new ArrayList<>();
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void addItem(MenuItem menuItem) {
        items.add(menuItem);
    }

    /**
     * Calculates the total cost of all items in this order.
     *
     * @return the total order price as a double
     */
    public double calculateTotal() {
        double total = 0.00;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
}
