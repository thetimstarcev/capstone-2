package com.pluralsight;

import com.pluralsight.enums.Size;

public class Chips extends MenuItem {
    private String name;

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String getName() {
        return "";
    }
}
