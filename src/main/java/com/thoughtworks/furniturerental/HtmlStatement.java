package com.thoughtworks.furniturerental;

class HtmlStatement {
    private Rentals rentals;
    private String customerName;

    public HtmlStatement(Rentals rentals, String customerName) {

        this.rentals = rentals;
        this.customerName = customerName;
    }

    public String generate() {
        String result = "<h1>Rental Record for <b>" + customerName + "</b></h1>\n";

        for (Rental rental : rentals) {
            //show figures for this rental
            result += "\t" + rental.getFurniture().getTitle() + "\t" +
                    rental.amount() + "\n";
        }

        //add footer lines result
        result += "Amount owed is <b>" + rentals.totalAmount() + "</b>\n";
        result += "You earned <b>" + rentals.totalFrequentRenterPoints()
                + " frequent renter points</b>";
        return result;
    }
}
