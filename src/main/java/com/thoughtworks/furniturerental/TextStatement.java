package com.thoughtworks.furniturerental;

class TextStatement {
    private Rentals rentals;
    private String customerName;

    public TextStatement(Rentals rentals, String customerName) {
        this.rentals = rentals;
        this.customerName = customerName;
    }

    public String generate() {
        String result = "Rental Record for " + customerName + "\n";

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
