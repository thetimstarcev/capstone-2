package com.pluralsight;

import com.pluralsight.enums.CheeseType;
import com.pluralsight.enums.Size;

public class Cheese extends Ingredients {
    private CheeseType cheeseType;
    private boolean extraCheese;

    public Cheese(CheeseType cheeseType, boolean extraCheese) {
        this.cheeseType = cheeseType;
        this.extraCheese = extraCheese;
    }

    public CheeseType getCheeseType() {
        return cheeseType;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    @Override
    public double getPrice(Size size) {
        double price;
        switch (size) {
            case SMALL:
                price = 0.75;
                break;
            case MEDIUM:
                price = 1.50;
                break;
            case LARGE:
                price = 2.25;
                break;
            default:
                throw new IllegalArgumentException("Unknown size: " + size);
        }
        if (extraCheese) {
            price *= 1.4;
        } return price;
    }
}
