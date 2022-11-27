package com.thoughtworks.furniturerental;

public class Rental {

    private int daysRented;
    private Furniture furniture;

    public Rental(Furniture furniture, int daysRented) {
        this.furniture = furniture;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Furniture getFurniture() {
        return furniture;
    }
}