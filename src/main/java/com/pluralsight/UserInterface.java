package com.pluralsight;

import com.pluralsight.enums.*;

import java.util.Scanner;

public class UserInterface {
    static Scanner scanner = new Scanner(System.in);

    public void homeScreen() {
        String prompt = """
                Welcome to DELI-cious!
                1) New Order
                0) Exit
                
                """;


        boolean running = true;
        do {
            System.out.println(prompt);
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    showOrderScreen ();
                case "0":
                    running = false;
                    System.out.println("Have a great day and see you soon!");
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        } while (running);
    }

    private void showOrderScreen() {
        String prompt = """
                
                =========================================
                         Welcome to DELI-cious!
                =========================================
                Your order is empty. Let's build it!
                
                1) Add Sandwich
                2) Add Drink
                3) Add Chips
                4) Checkout
                0) Cancel Order
                =========================================
                """;

        boolean running = true;
        do {
            System.out.println(prompt);
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1" -> addSandwich();
                case "2" -> addDrink();
                case "3" -> addChips();
                case "4" -> checkout();
                case "0" -> running = false;
                default -> System.out.println("Invalid input. Please try again.");
            }
        } while (running);
    }

    private void addSandwich() {
        System.out.println("What sandwich size would you like to have?\n");
        String userInputSize = scanner.nextLine();
        Size size = null;
        switch (userInputSize) {
            case "4\" inch" -> size = Size.SMALL;
            case "8\" inch" -> size = Size.MEDIUM;
            case "12\" inch" -> size = Size.LARGE;
            default -> System.out.println("Invalid input. Please try again.");

        }

        System.out.println("What type of bread you would like to have?\n");
        String userInputBread = scanner.nextLine();
        BreadType bread = null;
        switch (userInputBread) {
            case "White", "white", "WHITE" -> bread = BreadType.WHITE;
            case "Wheat", "wheat", "WHEAT" -> bread = BreadType.WHEAT;
            case "Rye", "rye", "RYE" -> bread = BreadType.RYE;
            case "Wrap", "wrap", "WRAP" -> bread = BreadType.WRAP;
            default -> System.out.println("Invalid input. Please try again.");

        }

        System.out.println("Would you like your sandwich toasted? (yes/no)\n");
        String userInputToasted = scanner.nextLine();
        boolean toasted = userInputToasted.equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        boolean running = true;
        do {
            System.out.println("Would you like to add meat to your sandwich? (yes/no)\n");
            String userInputMeat = scanner.nextLine();
            if (userInputMeat.equalsIgnoreCase("yes")) {

                System.out.println("""
                        Select your meat:
                        1) Steak
                        2) Ham
                        3) Salami
                        4) Roast Beef
                        5) Chicken
                        6) Bacon
                        0) Done adding meat
                        """);
                String userSelection = scanner.nextLine();
                MeatType meat = null;
                switch (userSelection) {
                    case "1" -> meat = MeatType.STEAK;
                    case "2" -> meat = MeatType.HAM;
                    case "3" -> meat = MeatType.SALAMI;
                    case "4" -> meat = MeatType.ROAST_BEEF;
                    case "5" -> meat = MeatType.CHICKEN;
                    case "6" -> meat = MeatType.BACON;
                    case "0" -> running = false;
                    default -> System.out.println("Invalid input. Please try again.");
                }

                System.out.println("Would you like to add extra meat to your sandwich? (yes/no)\n");
                String userAnswer = scanner.nextLine();
                boolean extra = userAnswer.equalsIgnoreCase("yes");
                if (meat != null) {
                    sandwich.addMeat(new Meat(meat, extra));
                }
            } else running = false;
        } while (running);

        running = true;
        do {
            System.out.println("Would you like to add cheese to your sandwich? (yes/no)\n");
            String userInputCheese = scanner.nextLine();
            if (userInputCheese.equalsIgnoreCase("yes")) {
                System.out.println("""
                        Select your cheese:
                        1) American
                        2) Provolone
                        3) Cheddar
                        4) Swiss
                        0) Done adding cheese
                        """);
                String userSelection = scanner.nextLine();
                CheeseType cheese = null;
                switch (userSelection) {
                    case "1" -> cheese = CheeseType.AMERICAN;
                    case "2" -> cheese = CheeseType.PROVOLONE;
                    case "3" -> cheese = CheeseType.CHEDDAR;
                    case "4" -> cheese = CheeseType.SWISS;
                    case "0" -> running = false;
                    default -> System.out.println("Invalid input. Please try again.");
                }
                System.out.println("Would you like to add extra cheese to your sandwich? (yes/no)\n");
                String userAnswer = scanner.nextLine();
                boolean extra = userAnswer.equalsIgnoreCase("yes");
                if (cheese != null) {
                    sandwich.addCheese(new Cheese(cheese, extra));
                } else running = false;
            }
        } while (running);


        running = true;
        System.out.println("Would you like to add any other ingredients to your sandwich? (yes/no)\n");
        String userInputIngredients = scanner.nextLine();
        if (userInputIngredients.equalsIgnoreCase("yes")) {
            do {
                System.out.println("""
                    Please select your toppings:
                    1) Lettuce
                    2) Peppers
                    3) Onions
                    4) Tomatoes
                    5) Jalapeños
                    6) Cucumbers
                    7) Pickles
                    8) Guacamole
                    9) Mushrooms
                    0) Done adding ingredients
                    """);
                String userSelection = scanner.nextLine();
                ToppingsType topping = null;
                switch (userSelection) {
                    case "1" -> topping = ToppingsType.PEPPERS;
                    case "2" -> topping = ToppingsType.ONIONS;
                    case "3" -> topping = ToppingsType.TOMATOES;
                    case "4" -> topping = ToppingsType.JALAPEÑOS;
                    case "5" -> topping = ToppingsType.CUCUMBERS;
                    case "6" -> topping = ToppingsType.PICKLES;
                    case "7" -> topping = ToppingsType.GUACAMOLE;
                    case "8" -> topping = ToppingsType.MUSHROOMS;
                    case "0" -> running = false;
                    default -> System.out.println("Invalid input. Please try again.");
                }
                sandwich.addIngredients(new Toppings(topping));
            } while (running);
        }

        running = true;
        System.out.println("Would you like to add some sauce? (yes/no)\n");
        String userInputSauce = scanner.nextLine();
        if (userInputSauce.equalsIgnoreCase("yes")) {
            do {
                System.out.println("""   
                        Select your sauce:
                        1) Mayo
                        2) Mustard
                        3) Ketchup
                        4) Ranch
                        5) Thousand Islands
                        6) Vinaigrette
                        0) Done adding sauces
                        """);
                String userSelection = scanner.nextLine();
                SaucesType sauce = null;
                switch (userSelection) {
                    case "1" -> sauce = SaucesType.MAYO;
                    case "2" -> sauce = SaucesType.MUSTARD;
                    case "3" -> sauce = SaucesType.KETCHUP;
                    case "4" -> sauce = SaucesType.RANCH;
                    case "5" -> sauce = SaucesType.THOUSAND_ISLANDS;
                    case "6" -> sauce = SaucesType.VINAIGRETTE;
                    case "0" -> running = false;
                    default -> System.out.println("Invalid input. Please try again.");
                }
                sandwich.addIngredients(new Sauces(sauce));
            } while (running);
        }
    }

    private void addDrink() {
    }

    private void addChips() {
    }

    private void checkout() {
    }


}
