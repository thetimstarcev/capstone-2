package com.pluralsight;
import com.pluralsight.enums.*;

public class BLT extends Sandwich {
    public BLT() {
        super(Size.MEDIUM, BreadType.WHITE, true);
        addMeat(new Meat(MeatType.BACON, false));
        addCheese(new Cheese(CheeseType.CHEDDAR,false));
        addIngredients(new Toppings(ToppingsType.LETTUCE));
        addIngredients(new Toppings(ToppingsType.TOMATOES));
        addIngredients(new Sauces(SaucesType.RANCH));
    }
}
