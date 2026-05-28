package com.pluralsight;
import java.io.File;

public class App {
    public static void main(String[] args) {
        File receiptsFolder = new File("srs/main/resources/receipts");
        if (!receiptsFolder.exists()) {
            receiptsFolder.mkdirs();
        }

        UserInterface userInterface = new UserInterface();
        userInterface.homeScreen();
    }
}