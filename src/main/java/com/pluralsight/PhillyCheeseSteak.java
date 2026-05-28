package com.pluralsight;
import com.pluralsight.enums.*;

public class PhillyCheeseSteak extends Sandwich {

    public PhillyCheeseSteak() {
        super(Size.MEDIUM, BreadType.WHITE,true);
        addMeat(new Meat(MeatType.STEAK, false));
        addCheese(new Cheese(CheeseType.AMERICAN,false));
        addIngredients(new Toppings(ToppingsType.PEPPERS));
        addIngredients(new Sauces(SaucesType.MAYO));
    }
    public String getName () {
        return "Philly Cheese Steak Signature Sandwich \n" + this.getSize() + " " + this.getType() + " Toasted";
    }
}