package com.thoughtworks.furniturerental;

public class Customer {
    private String name;
    private Rentals rentals = new Rentals();

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
        String result = "Rental Record for " + getName() + "\n";

        for (Rental rental : rentals) {
            //show figures for this rental
            result += "\t" + rental.getFurniture().getTitle() + "\t" +
                    rental.amount() + "\n";
        }

        //add footer lines result
        result += "Amount owed is " + rentals.totalAmount() + "\n";
        result += "You earned " + rentals.totalFrequentRenterPoints()
                + " frequent renter points";
        return result;
    }

}

