package com.pluralsight;
import com.pluralsight.enums.SaucesType;
import com.pluralsight.enums.Size;

public class Sauces extends Ingredients{
    private SaucesType saucesType;

    public Sauces(SaucesType saucesType) {
        this.saucesType = saucesType;
    }

    public SaucesType getSaucesType() {
        return saucesType;
    }

    @Override
    public String getName() {
        return saucesType.toString();
    }

    @Override
    public double getPrice (Size size) {
        return 0; // Regular sauces are included at no extra cost
    }
}
