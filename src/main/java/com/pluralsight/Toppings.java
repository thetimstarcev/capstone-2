package com.pluralsight;
import com.pluralsight.enums.Size;
import com.pluralsight.enums.ToppingsType;

public class Toppings extends Ingredients {
    private ToppingsType topping;

    public Toppings(ToppingsType topping) {
        this.topping = topping;
    }

    public ToppingsType getTopping() {
        return topping;
    }

    @Override
    public double getPrice(Size size) {
        return 0; // Regular toppings are included at no extra cost
    }
}
