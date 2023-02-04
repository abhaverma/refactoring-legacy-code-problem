package com.thoughtworks.furniturerental;

import java.util.ArrayList;
import java.util.List;

import static com.thoughtworks.furniturerental.Furniture.*;

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
        for (Rental rental : rentals) {
            double amount = amountFor(rental);
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two days new launch rental
            if ((rental.getFurniture().getPriceCode() == NEW_LAUNCH)
                    &&
                    rental.getDaysRented() > 1) frequentRenterPoints++;

            //show figures for this rental
            result += "\t" + rental.getFurniture().getTitle() + "\t" +
                    amount + "\n";
            totalAmount += amount;
        }

        //add footer lines result
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints
                + " frequent renter points";
        return result;
    }

    private double amountFor(Rental rental) {
        double amount = 0;
        switch (rental.getFurniture().getPriceCode()) {
            case REGULAR:
                amount += 200;
                if (rental.getDaysRented() > 2)
                    amount += (rental.getDaysRented() - 2) * 150;
                break;
            case NEW_LAUNCH:
                amount += rental.getDaysRented() * 300;
                break;
            case CHILDREN:
                amount += 150;
                if (rental.getDaysRented() > 3)
                    amount += (rental.getDaysRented() - 3) * 150;
                break;
        }
        return amount;
    }
}

