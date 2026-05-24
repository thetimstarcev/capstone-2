package com.pluralsight;
import com.pluralsight.enums.Size;
import com.pluralsight.enums.ToppingsType;

public class Toppings extends Ingredients {
    private ToppingsType toppingType;

    public Toppings(ToppingsType topping) {
        this.toppingType = topping;
    }

    public ToppingsType getTopping() {
        return toppingType;
    }

    @Override
    public double getPrice(Size size) {
        return 0; // Regular toppings are included at no extra cost
    }
}
