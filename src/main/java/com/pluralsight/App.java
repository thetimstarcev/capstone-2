package com.pluralsight;
import java.io.File;

public class App {
    public static void main(String[] args) {
        // Create receipts folder automatically if it doesn't exist
        // This prevents a crash when ReceiptWriter tries to save a file
        File receiptsFolder = new File("src/main/resources/receipts");
        if (!receiptsFolder.exists()) {
            receiptsFolder.mkdirs();
        }

        UserInterface userInterface = new UserInterface();
        userInterface.homeScreen();
    }
}