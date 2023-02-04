package com.thoughtworks.furniturerental;

import static com.thoughtworks.furniturerental.Furniture.*;

public class Rental {

    private final int daysRented;
    private final Furniture furniture;

    public Rental(Furniture furniture, int daysRented) {
        this.furniture = furniture;
        this.daysRented = daysRented;
    }

    public Furniture getFurniture() {
        return furniture;
    }

    double amount() {
        double amount = 0;
        switch (furniture.getPriceCode()) {
            case REGULAR:
                amount += 200;
                if (daysRented > 2)
                    amount += (daysRented - 2) * 150;
                break;
            case NEW_LAUNCH:
                amount += daysRented * 300;
                break;
            case CHILDREN:
                amount += 150;
                if (daysRented > 3)
                    amount += (daysRented - 3) * 150;
                break;
        }
        return amount;
    }

    int frequentRenterPoints() {
        int frequentRenterPoints = 1;
        if ((furniture.getPriceCode() == NEW_LAUNCH)
                &&
                daysRented > 1) frequentRenterPoints++;
        return frequentRenterPoints;
    }

    String title() {
        return getFurniture().getTitle();
    }
}