package com.pluralsight;

import com.pluralsight.enums.*;

import java.time.LocalDateTime;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);
    private Order order;
    private final ReceiptWriter writer = new ReceiptWriter();
    private int orderCounter = 1;

    /**
     * Displays the home screen and keeps the app running
     * until the user chooses to exit.
     */
    public void homeScreen() {
        String prompt = """
                
                =========================================
                   Welcome to DELIcious Sandwich Shop!
                =========================================
                📃 New Order                          (1)
                ❌ Exit                               (0)
                -----------------------------------------
                Please choose an option:""";

        boolean running = true;
        do {
            System.out.println(prompt);
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1" -> showOrderScreen();
                case "0" -> {
                    running = false;
                    System.out.println("Have a great day and see you soon!");
                }
                default -> System.out.println(Colors.RED + "Invalid input. Please try again." + Colors.RESET);
            }
        } while (running);
    }

    /**
     * Displays the order screen where customers add items.
     * Creates a new Order with a unique number and current timestamp.
     */
    private void showOrderScreen() {
        LocalDateTime orderTime = LocalDateTime.now();
        String orderNumber = "A" + orderCounter;
        orderCounter++;
        order = new Order(orderNumber, orderTime);
        String prompt = """
                
                =========================================
                          Welcome to DELIcious!
                =========================================
                🥪 Add Sandwich                       (1)
                🥤 Add Drink                          (2)
                🍟 Add Chips                          (3)
                🧾 Checkout                           (4)
                ❌ Cancel Order                       (0)
                =========================================
                Please choose an option:""";

        boolean running = true;
        do {
            System.out.println(prompt);
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1" -> addSandwich();
                case "2" -> addDrink();
                case "3" -> addChips();
                case "4" -> {
                    checkout();
                    running = false;
                }
                case "0" -> {
                    cancelOrder();
                    running = false;
                }
                default -> System.out.println(Colors.RED + "Invalid input. Please try again." + Colors.RESET);
            }
        } while (running);
    }

    // Displays sandwich type selection — custom or signature
    private void addSandwich() {
        System.out.println("""
                  What type of sandwich would you like?
                =========================================
                ①  Custom Sandwich                   (1)
                ②  Philly Cheese Steak               (2)
                ③  BLT Sandwich                      (3)
                ⓪  Back to Main Menu                 (0)
                =========================================
                Please choose an option:""");

        boolean running = true;
        do {
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1" -> {
                    buildCustomSandwich();
                    running = false;
                }
                case "2" -> {
                    addPhillyCheeseSteak();
                    System.out.println(Colors.GREEN + "Philly Cheese Steak added to your order!" + Colors.RESET);
                    running = false;
                }
                case "3" -> {
                    addBLT();
                    System.out.println(Colors.GREEN + "BLT Sandwich added to your order!" + Colors.RESET);
                    running = false;
                }

                case "0" -> running = false;
                default -> System.out.println(Colors.RED + "Invalid input. Please try again." + Colors.RESET);
            }
        } while (running);
    }

    private void addPhillyCheeseSteak() {
        order.addItem(new PhillyCheeseSteak());
    }

    private void addBLT() {
        order.addItem(new BLT());
    }

    private void buildCustomSandwich() {
        // Loop until valid size selection
        Size size = null;
        while (size == null) {
            System.out.println("""
                     What size would you like your sandwich?
                    =========================================
                    ($5.50)   4"  - Small                 (1)
                    ($7.00)   8"  - Medium                (2)
                    ($8.50)   12" - Large                 (3)
                    =========================================
                    Please choose an option:""");
            String userInputSize = scanner.nextLine();
            switch (userInputSize) {
                case "1" -> size = Size.SMALL;
                case "2" -> size = Size.MEDIUM;
                case "3" -> size = Size.LARGE;
                default -> System.out.println(Colors.RED + "Invalid input. Please try again." + Colors.RESET);
            }
        }

        // Loop until valid bread selection
        BreadType bread = null;
        while (bread == null) {
            System.out.println("""
                        What type of bread you would like?
                    =========================================
                    🍞 White                              (1)
                    🌾 Wheat                              (2)
                    🫓 Rye                                (3)
                    🌯 Wrap                               (4)
                    =========================================
                    Please choose an option:""");

            String userInputBread = scanner.nextLine();
            switch (userInputBread) {
                case "1" -> bread = BreadType.WHITE;
                case "2" -> bread = BreadType.WHEAT;
                case "3" -> bread = BreadType.RYE;
                case "4" -> bread = BreadType.WRAP;
                default -> System.out.println(Colors.RED + "Invalid input. Please try again." + Colors.RESET);
            }
        }
        // Toasted preference
        String prompt = "Would you like your sandwich toasted? (yes/no)\n";
        boolean toasted = getYesNoInput(prompt);
        Sandwich sandwich = new Sandwich(size, bread, toasted);

        // Meat preference
        prompt = "Would you like to add meat to your sandwich? (yes/no)\n";
        if (getYesNoInput(prompt)) {
            MeatType meat = null;
            while (meat == null) {
                System.out.println("""
                        -----------------------------------------
                                    Select your meat:
                        -----------------------------------------
                        Steak                                 (1)
                        Ham                                   (2)
                        Salami                                (3)
                        Roast Beef                            (4)
                        Chicken                               (5)
                        Bacon                                 (6)
                        -----------------------------------------
                        Please choose an option:""");
                String userSelection = scanner.nextLine();
                switch (userSelection) {
                    case "1" -> meat = MeatType.STEAK;
                    case "2" -> meat = MeatType.HAM;
                    case "3" -> meat = MeatType.SALAMI;
                    case "4" -> meat = MeatType.ROAST_BEEF;
                    case "5" -> meat = MeatType.CHICKEN;
                    case "6" -> meat = MeatType.BACON;
                    default -> System.out.println(Colors.RED + "Invalid input. Please try again." + Colors.RESET);
                }
                if (meat != null) {
                    prompt = "Would you like to add extra meat to your sandwich? (yes/no)\n";
                    boolean extra = getYesNoInput(prompt);
                    sandwich.addMeat(new Meat(meat, extra));
                }
            }
        }

        // Cheese preference
        prompt = "Would you like to add cheese to your sandwich? (yes/no)\n";
        if (getYesNoInput(prompt)) {
            CheeseType cheese = null;
            while (cheese == null) {
                System.out.println("""
                        -----------------------------------------
                                   Select your cheese:
                        -----------------------------------------
                        American                              (1)
                        Provolone                             (2)
                        Cheddar                               (3)
                        Swiss                                 (4)
                        -----------------------------------------
                        Please choose an option:""");
                String userSelection = scanner.nextLine();
                switch (userSelection) {
                    case "1" -> cheese = CheeseType.AMERICAN;
                    case "2" -> cheese = CheeseType.PROVOLONE;
                    case "3" -> cheese = CheeseType.CHEDDAR;
                    case "4" -> cheese = CheeseType.SWISS;
                    default -> System.out.println(Colors.RED + "Invalid input. Please try again." + Colors.RESET);
                }
                if (cheese != null) {
                    prompt = "Would you like to add extra cheese to your sandwich? (yes/no)\n";
                    boolean extra = getYesNoInput(prompt);
                    sandwich.addCheese(new Cheese(cheese, extra));
                }
            }
        }

        // Optional ingredients (multiple allowed, no duplicates)
        prompt = "Would you like to add any other ingredients to your sandwich? (yes/no)\n";
        if (getYesNoInput(prompt)) {
            boolean running = true;
            do {
                System.out.println("""
                        -----------------------------------------
                                Please select your toppings:
                        -----------------------------------------
                        Lettuce                               (1)
                        Peppers                               (2)
                        Onions                                (3)
                        Tomatoes                              (4)
                        Jalapeños                             (5)
                        Cucumbers                             (6)
                        Pickles                               (7)
                        Guacamole                             (8)
                        Mushrooms                             (9)
                        Done adding ingredients               (0)
                        -----------------------------------------
                        Please choose an option:""");
                String userSelection = scanner.nextLine();
                ToppingsType topping = null;
                switch (userSelection) {
                    case "1" -> topping = ToppingsType.LETTUCE;
                    case "2" -> topping = ToppingsType.PEPPERS;
                    case "3" -> topping = ToppingsType.ONIONS;
                    case "4" -> topping = ToppingsType.TOMATOES;
                    case "5" -> topping = ToppingsType.JALAPEÑOS;
                    case "6" -> topping = ToppingsType.CUCUMBERS;
                    case "7" -> topping = ToppingsType.PICKLES;
                    case "8" -> topping = ToppingsType.GUACAMOLE;
                    case "9" -> topping = ToppingsType.MUSHROOMS;
                    case "0" -> running = false;
                    default -> System.out.println(Colors.RED + "Invalid input. Please try again." + Colors.RESET);
                }
                if (topping != null) {
                    sandwich.addIngredients(new Toppings(topping));
                }
            } while (running);
        }

        // Optional sauces (multiple allowed, no duplicates)
        prompt = "Would you like to add some sauce? (yes/no)\n";
        if (getYesNoInput(prompt)) {
            boolean running = true;
            do {
                System.out.println("""
                        -----------------------------------------
                                   Select your sauce:
                        -----------------------------------------
                        Mayo                                  (1)
                        Mustard                               (2)
                        Ketchup                               (3)
                        Ranch                                 (4)
                        Thousand Islands                      (5)
                        Vinaigrette                           (6)
                        Done adding sauces                    (0)
                        -----------------------------------------
                        Please choose an option:""");
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
                    default -> System.out.println(Colors.RED + "Invalid input. Please try again." + Colors.RESET);
                }
                if (sauce != null) {
                    sandwich.addIngredients(new Sauces(sauce));
                }
            } while (running);
        }

        // Optional sides (multiple allowed, no duplicates)
        prompt = "Would you like to add sides to your order? (yes/no)\n";
        if (getYesNoInput(prompt)) {
            boolean running = true;
            do {
                System.out.println("""
                        -----------------------------------------
                                 Please select your side:
                        -----------------------------------------
                        Au jus                                (1)
                        Sauce                                 (2)
                        Done adding sides                     (0)
                        -----------------------------------------
                        Please choose an option:""");
                String userSelection = scanner.nextLine();
                SidesType side = null;
                switch (userSelection) {
                    case "1" -> side = SidesType.AU_JUS;
                    case "2" -> side = SidesType.SAUCE;
                    case "0" -> running = false;
                    default -> System.out.println(Colors.RED + "Invalid input. Please try again." + Colors.RESET);
                }
                if (side != null) {
                    sandwich.addIngredients(new Sides(side));
                }
            } while (running);
        }
        order.addItem(sandwich);
        System.out.println(Colors.GREEN + "Sandwich has been added to your order!" + Colors.RESET);
    }

    // Prompts customer to select a drink size, loops to allow multiple drinks
    private void addDrink() {
        boolean running = true;
        do {
            System.out.println("""
                    -----------------------------------------
                          Please select your drink size:
                    -----------------------------------------
                    Small                                 (1)
                    Medium                                (2)
                    Large                                 (3)
                    -----------------------------------------
                    Please choose an option:""");
            String userSelection = scanner.nextLine();
            Size size = null;
            switch (userSelection) {
                case "1" -> size = Size.SMALL;
                case "2" -> size = Size.MEDIUM;
                case "3" -> size = Size.LARGE;
                default -> System.out.println(Colors.RED + "Invalid input. Please try again." + Colors.RESET);
            }
            if (size != null) {
                Drink drink = new Drink(size);
                order.addItem(drink);
                System.out.println(Colors.GREEN + "Drink added!" + Colors.RESET);
                String prompt = "Would you like to add another drink? (yes/no)\n";
                if (!getYesNoInput(prompt)) {
                    running = false;
                }
            }
        } while (running);
    }

    // Prompts customer to select a chip type, loops to allow multiple bags
    private void addChips() {
        boolean running = true;
        do {
            System.out.println("""
                    -----------------------------------------
                            Please select your chips:
                    -----------------------------------------
                    Doritos                               (1)
                    Lays                                  (2)
                    Cheetos                               (3)
                    Pringles                              (4)
                    -----------------------------------------
                    Please choose an option:""");
            String userSelection = scanner.nextLine();
            String chipsSelection = null;
            switch (userSelection) {
                case "1" -> chipsSelection = "Doritos";
                case "2" -> chipsSelection = "Lays";
                case "3" -> chipsSelection = "Cheetos";
                case "4" -> chipsSelection = "Pringles";
                default -> System.out.println(Colors.RED + "Invalid input. Please try again." + Colors.RESET);
            }
            if (chipsSelection != null) {
                Chips chips = new Chips(chipsSelection);
                order.addItem(chips);
                System.out.println(Colors.GREEN + "Chips added!" + Colors.RESET);
                String prompt = "Would you like to add another bag of chips? (yes/no)\n";
                if (!getYesNoInput(prompt)) {
                    running = false;
                }
            }
        } while (running);
    }

    private void cancelOrder() {
        order = null;
        orderCounter--;
    }

    /**
     * Displays the full order summary and prompts customer to confirm or cancel.
     * If order is empty, cancels and returns to home screen.
     */
    private void checkout() {
        if (order.calculateTotal() == 0.00) {
            System.out.println(Colors.RED + "Oops! Your order is empty. Returning to home screen..." + Colors.RESET);
            cancelOrder();
        } else {
            System.out.println(writer.getOrder(order));
            System.out.println("""              
                    -----------------------------------------
                              Is your order correct?
                    -----------------------------------------
                    ✅ Confirm                            (1)
                    ❌ Cancel                             (2)
                    -----------------------------------------
                    Please choose an option:""");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("1")) {
                System.out.println(Colors.GREEN + "Your order has been confirmed! Thank you for choosing DELIcious!" + Colors.RESET);
                writer.writeReceipt(order);
            } else cancelOrder();
        }
    }

    /**
     * Reusable helper method for yes/no questions throughout the app.
     * Loops until the user enters a valid "yes" or "no" response.
     *
     * @param prompt the question to display to the user
     * @return true if user enters "yes", false if user enters "no"
     */
    private boolean getYesNoInput(String prompt) {
        do {
            System.out.println(prompt);
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("yes")) {
                return true;
            } else if (userInput.equalsIgnoreCase("no")) {
                return false;
            } else System.out.println(Colors.RED + "Invalid input. Please try again!\n" + Colors.RESET);
        } while (true);
    }
}