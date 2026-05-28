package com.pluralsight;

import com.pluralsight.enums.Size;

public class Drink extends MenuItem {
    private Size size;

    public Drink(Size size) {
        this.size = size;
    }

    @Override
    public double getPrice() {
        double price = 0.00;
        switch (this.size) {
            case SMALL -> price = 2.00;
            case MEDIUM -> price = 2.50;
            case LARGE -> price = 3.00;
        }
        return price;
    }

    @Override
    public String getName() {
        return this.size + " Fountain Drink";
    }
}
