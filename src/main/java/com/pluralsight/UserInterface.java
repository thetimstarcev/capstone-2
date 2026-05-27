package com.pluralsight;
import com.pluralsight.enums.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Order order;
    private int orderCounter = 1;

    public void homeScreen() {
        String prompt = """
                Welcome to DELIcious!
                1) New Order
                0) Exit
                """;


        boolean running = true;
        do {
            System.out.println(prompt);
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1" -> showOrderScreen ();
                case "0" -> {running = false; System.out.println("Have a great day and see you soon!");}
                default -> System.out.println("Invalid input. Please try again.");
            }
        } while (running);
    }

    private void showOrderScreen() {
        LocalDateTime orderTime = LocalDateTime.now();
        String orderNumber = "A" + orderCounter;
        orderCounter ++;
        order = new Order(orderNumber,orderTime);
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
                case "0" -> cancelOrder();
                default -> System.out.println("Invalid input. Please try again.");
            }
        } while (running);
    }

    private void addSandwich() {
        System.out.println("""
                         What size would you like your sandwich?
                        =========================================
                        ($5.50)   4"  - Small                 (1)
                        ($7.00)   8"  - Medium                (2)
                        ($8.50)   12" - Large                 (3)
                        =========================================
                        \n""");

        String userInputSize = scanner.nextLine();
        Size size = null;
        switch (userInputSize) {
            case "1" -> size = Size.SMALL;
            case "2" -> size = Size.MEDIUM;
            case "3" -> size = Size.LARGE;
            default -> System.out.println("Invalid input. Please try again.");

        }

        System.out.println("""
                            What type of bread you would like?
                        =========================================
                        🍞 White                              (1)
                        🌾 Wheat                              (2)
                        🫓 Rye                                (3)
                        🌯 Wrap                               (4)
                        =========================================
                        """);

        String userInputBread = scanner.nextLine();
        BreadType bread = null;
        switch (userInputBread) {
            case "1" -> bread = BreadType.WHITE;
            case "2" -> bread = BreadType.WHEAT;
            case "3" -> bread = BreadType.RYE;
            case "4" -> bread = BreadType.WRAP;
            default -> System.out.println("Invalid input. Please try again.");

        }

        System.out.println("Would you like your sandwich toasted? (yes/no)\n");
        String userInputToasted = scanner.nextLine();
        boolean toasted = userInputToasted.equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        boolean running;
        System.out.println("Would you like to add meat to your sandwich? (yes/no)\n");
        String userInputMeat = scanner.nextLine();
        if (userInputMeat.equalsIgnoreCase("yes")) {
            running = true;
            do {
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
                if (meat != null) {
                    System.out.println("Would you like to add extra meat to your sandwich? (yes/no)\n");
                    String userAnswer = scanner.nextLine();
                    boolean extra = userAnswer.equalsIgnoreCase("yes");
                    sandwich.addMeat(new Meat(meat, extra));
                } else running = false;
            } while (running);
        }


            System.out.println("Would you like to add cheese to your sandwich? (yes/no)\n");
            String userInputCheese = scanner.nextLine();
            if (userInputCheese.equalsIgnoreCase("yes")) {
                running = true;
                do {
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
                } while (running);
            }



        System.out.println("Would you like to add any other ingredients to your sandwich? (yes/no)\n");
        String userInputIngredients = scanner.nextLine();
        if (userInputIngredients.equalsIgnoreCase("yes")) {
            running = true;
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
                    default -> System.out.println("Invalid input. Please try again.");
                }
                if (topping != null) {
                    sandwich.addIngredients(new Toppings(topping));
                }
            } while (running);
        }

        System.out.println("Would you like to add some sauce? (yes/no)\n");
        String userInputSauce = scanner.nextLine();
        if (userInputSauce.equalsIgnoreCase("yes")) {
            running = true;
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
                if (sauce != null) {
                    sandwich.addIngredients(new Sauces(sauce));
                }
            } while (running);
        }

        System.out.println("Would you like to add sides to your order? (yes/no)\n");
        String userInput = scanner.nextLine();
        if (userInput.equalsIgnoreCase("yes")) {
            running = true;
            do {
                System.out.println("""
                        Please select your side:
                        1) Au jus
                        2) Sauce
                        0) Done adding sides
                        """);
                String userSelection = scanner.nextLine();
                SidesType side = null;
                switch (userSelection) {
                    case "1" -> side = SidesType.AU_JUS;
                    case "2" -> side = SidesType.SAUCE;
                    case "0" -> running = false;
                    default -> System.out.println("Invalid input. Please try again.");
                }
                if (side != null) {
                    sandwich.addIngredients(new Sides(side));
                }
            } while (running);
        } order.addItem(sandwich);
    }

    private void addDrink() {
        boolean running = true;
        do {
            System.out.println("""
                    Please select your drink size:
                    1) Small
                    2) Medium
                    3) Large
                    """);
            String userSelection = scanner.nextLine();
            Size size = null;
            switch (userSelection) {
                case "1" -> size = Size.SMALL;
                case "2" -> size = Size.MEDIUM;
                case "3" -> size = Size.LARGE;
                default -> System.out.println("Invalid input. Please try again.");
            }
            if (size != null) {
                Drink drink = new Drink(size);
                order.addItem(drink);
            }
            System.out.println("Would you like to add another drink? (yes/no)\n");
            String userAnswer = scanner.nextLine();
            if (userAnswer.equalsIgnoreCase("no")) {
                running = false;
            }
        } while (running);
    }

    private void addChips() {
        boolean running = true;
        do {
            System.out.println("""
                    Please select your chips:
                    1) Doritos
                    2) Lays
                    3) Cheetos
                    4) Pringles
                    """);
            String userSelection = scanner.nextLine();
            String chipsSelection = null;
            switch (userSelection) {
                case "1" -> chipsSelection = "Doritos";
                case "2" -> chipsSelection = "Lays";
                case "3" -> chipsSelection = "Cheetos";
                case "4" -> chipsSelection = "Pringles";
                default -> System.out.println("Invalid input. Please try again.");
            }
            if (chipsSelection != null) {
                Chips chips = new Chips(chipsSelection);
                order.addItem(chips);
            }
            System.out.println("Would you like to add another bag of chips? (yes/no)\n");
            String userAnswer = scanner.nextLine();
            if (userAnswer.equalsIgnoreCase("no")) {
                running = false;
            }
        } while (running);
    }

    private void cancelOrder() {
        order = null;
        orderCounter --;
        homeScreen();
    }

    private void checkout() {
        if (order.calculateTotal() == 0.00) {
            System.out.println("Oops! Your order is empty. Returning to home screen...");
            cancelOrder();
        } //TODO else

    }


}
