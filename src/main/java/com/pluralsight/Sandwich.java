package com.pluralsight;

import com.pluralsight.enums.BreadType;
import com.pluralsight.enums.Size;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends MenuItem {
    private Size size;
    private BreadType type;
    private List<Meat> meats;
    private List<Cheese> cheeses;
    private List<Ingredients> regularIngredients;
    private boolean toasted;

    public Sandwich(Size size, BreadType type, boolean toasted) {
        this.size = size;
        this.type = type;
        this.toasted = toasted;
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.regularIngredients = new ArrayList<>();
    }

    // region getters
    public Size getSize() {
        return size;
    }

    public BreadType getType() {
        return type;
    }

    public List<Meat> getMeats() {
        return meats;
    }

    public List<Cheese> getCheeses() {
        return cheeses;
    }

    public List<Ingredients> getRegularIngredients() {
        return regularIngredients;
    }

    public boolean isToasted() {
        return toasted;
    }

    // endregions

    public void addMeat(Meat meat) {
        meats.add(meat);
    }

    public void addCheese(Cheese cheese) {
        cheeses.add(cheese);
    }

    public void addIngredients(Ingredients ingredient) {
        boolean alreadyAdded = regularIngredients.stream().anyMatch(i -> i.getName().equalsIgnoreCase(ingredient.getName()));
        if (alreadyAdded) {
            System.out.println("Yo, what's up with the " + ingredient.getName() + "? Lettuce escort you out of our sandwich shop.");
        } else regularIngredients.add(ingredient);
    }

    @Override
    public String getName() {
        String name = this.size + " " + this.type + " Sandwich";
        if (this.toasted) {
            name += " Toasted";
        }
        return name;
    }

    @Override
    public double getPrice() {
        double totalPrice = 0.00;
        switch (this.size) {
            case SMALL -> totalPrice = 5.50;
            case MEDIUM -> totalPrice = 7.00;
            case LARGE -> totalPrice = 8.50;
        }
        for (Meat meat : meats) {
            totalPrice += meat.getPrice(this.size);
        }
        for (Cheese cheese : cheeses) {
            totalPrice += cheese.getPrice(this.size);
        }
        for (Ingredients ingredients : regularIngredients) {
            totalPrice += ingredients.getPrice(this.size);
        }
        return totalPrice;
    }
}