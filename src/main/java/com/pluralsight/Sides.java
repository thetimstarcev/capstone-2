package com.pluralsight;

import com.pluralsight.enums.SidesType;
import com.pluralsight.enums.Size;

public class Sides extends Ingredients{
    private SidesType sideType;

    public Sides(SidesType sideType) {
        this.sideType = sideType;
    }

    @Override
    public String getName() {
        return sideType.toString();
    }

    @Override
    public double getPrice (Size size) {
        return 0; // Regular sides are included at no extra cost
    }
}
