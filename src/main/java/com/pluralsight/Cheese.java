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

    @Override
    public String getName() {
        return cheeseType.toString();
    }

    @Override
    public double getPrice(Size size) {
        double price = 0;
        switch (size) {
            case SMALL -> price = 0.75;
            case MEDIUM -> price = 1.50;
            case LARGE -> price = 2.25;
            default -> System.out.println("Unknown size: " + size);
        }
        if (extraCheese) {
            price *= 1.4;
        } return price;
    }
}
