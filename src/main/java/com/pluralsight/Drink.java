package com.pluralsight;

import com.pluralsight.enums.Size;

public class Drink extends MenuItem {
    private Size size;

    public double getPrice() {
        if (size == Size.SMALL) {
            return 2.0;
        } else if (size == Size.MEDIUM) {
            return 2.5;
        } else return 3.0;
        }
    }

