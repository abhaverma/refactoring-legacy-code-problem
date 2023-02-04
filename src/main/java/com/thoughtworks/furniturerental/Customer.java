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
        return new TextStatement(rentals, name).generate();
    }

    public String htmlStatement() {
        return new HtmlStatement(rentals, name).generate();
    }

}
