package com.pluralsight;

import com.pluralsight.enums.MeatType;
import com.pluralsight.enums.Size;

public class Meat extends Ingredients {
    private MeatType meatType;
    private boolean extraMeat;

    public Meat(MeatType meatType, boolean extraMeat) {
        this.meatType = meatType;
        this.extraMeat = extraMeat;
    }

    public MeatType getMeatType() {
        return meatType;
    }

    public boolean isExtraMeat() {
        return extraMeat;
    }

    @Override
    public String getName() {
        return meatType.toString();
    }

    /**
     * Calculates the price of this meat based on sandwich size.
     * If extraMeat is true, an additional charge is added on top of the base price.
     *
     * @param size the size of the sandwich
     * @return the total meat price as a double
     */
    @Override
    public double getPrice(Size size) {
        double price;
        switch (size) {
            case SMALL:
                price = 1.00;
                break;
            case MEDIUM:
                price = 2.00;
                break;
            case LARGE:
                price = 3.00;
                break;
            default:
                throw new IllegalArgumentException("Unknown size: " + size);
        }
        if (extraMeat) {
            price *= 1.5;
        }
        return price;
    }
}
