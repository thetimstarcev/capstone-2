package com.pluralsight;

public class Drink extends MenuItem {
    private Size size;

    public double getPrice() {
        if (size == Size.SMALL) {
            return 2.0;
        } else if (size == Size.MEDIUM) {
            return 2.5;
        } else return 3.0;
        }
    }

