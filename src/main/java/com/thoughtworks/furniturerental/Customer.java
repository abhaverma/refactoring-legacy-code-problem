package com.thoughtworks.furniturerental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";
        for (Rental each : rentals) {
            double thisAmount = 0;
            //determine amounts for each line
            switch (each.getFurniture().getPriceCode()) {
                case Furniture.REGULAR:
                    thisAmount += 200;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 150;
                    break;
                case Furniture.NEW_LAUNCH:
                    thisAmount += each.getDaysRented() * 300;
                    break;
                case Furniture.CHILDREN:
                    thisAmount += 150;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 150;
                    break;
            }
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two days new launch rental
            if ((each.getFurniture().getPriceCode() == Furniture.NEW_LAUNCH)
                    &&
                    each.getDaysRented() > 1) frequentRenterPoints++;

            //show figures for this rental
            result += "\t" + each.getFurniture().getTitle() + "\t" +
                    thisAmount + "\n";
            totalAmount += thisAmount;
        }

        //add footer lines result
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints
                + " frequent renter points";
        return result;
    }
}

