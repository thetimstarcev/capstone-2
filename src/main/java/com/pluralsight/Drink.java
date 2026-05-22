package com.pluralsight;

public class Drink extends MenuItem {
    private DrinkSize size;

    public double getPrice() {
        if (size == DrinkSize.SMALL) {
            return 2.0;
        } else if (size == DrinkSize.MEDIUM) {
            return 2.5;
        } else return 3.0;
        }
    }

