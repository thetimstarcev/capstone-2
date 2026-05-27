package com.pluralsight;
import com.pluralsight.enums.Size;

public abstract class Ingredients {
    public abstract String getName();
    public abstract double getPrice (Size size);
}
