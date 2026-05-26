package com.pluralsight;

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
    }


}
