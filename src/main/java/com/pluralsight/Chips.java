package com.pluralsight;

public class Chips extends MenuItem {
    private final String name;

    public Chips(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String getName() {
        return this.name + " Chips";
    }
}
