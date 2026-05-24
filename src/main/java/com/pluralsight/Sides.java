package com.pluralsight;

import com.pluralsight.enums.Size;

public class Sides extends Ingredients{
    private String sideType;

    public Sides(String sideType) {
        this.sideType = sideType;
    }

    public String getSideType() {
        return sideType;
    }

    @Override
    public double getPrice (Size size) {
        return 0; // Regular sides are included at no extra cost
    }
}
