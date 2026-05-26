package com.pluralsight;

import com.pluralsight.enums.BreadType;
import com.pluralsight.enums.MeatType;
import com.pluralsight.enums.Size;

import java.io.BufferedReader;
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
                case "1" -> showOrderScreen ();
                case "0" -> running = false;
                default -> System.out.println("Invalid input. Please try again.");
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
        }

        System.out.println("What type of bread you would like to have?\n");
        String userInputBread = scanner.nextLine();
        BreadType bread = null;
        switch (userInputBread) {
            case "White", "white", "WHITE" -> bread = BreadType.WHITE;
            case "Wheat", "wheat", "WHEAT" -> bread = BreadType.WHEAT;
            case "Rye", "rye", "RYE" -> bread = BreadType.RYE;
            case "Wrap", "wrap", "WRAP" -> bread = BreadType.WRAP;
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
                }

                System.out.println("Would you like to add extra meat to your sandwich? (yes/no)\n");
                String userAnswer = scanner.nextLine();
                boolean extra = userAnswer.equalsIgnoreCase("yes");
                if (meat != null) {
                    sandwich.addMeat(new Meat(meat, extra));
                }
            } else running = false;
        } while (running) ;




    }

    private void addDrink() {
    }

    private void addChips() {
    }

    private void checkout() {
    }


}
