package com.pluralsight;

import com.pluralsight.enums.SidesType;
import com.pluralsight.enums.Size;

public class Sides extends Ingredients{
    private SidesType sideType;

    public Sides(SidesType sideType) {
        this.sideType = sideType;
    }

    public SidesType getSideType() {
        return sideType;
    }

    @Override
    public double getPrice (Size size) {
        return 0; // Regular sides are included at no extra cost
    }
}
