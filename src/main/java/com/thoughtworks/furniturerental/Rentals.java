package com.thoughtworks.furniturerental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {
    double totalAmount() {
        return stream().mapToDouble(Rental::amount).sum();
    }

    int totalFrequentRenterPoints() {
        return stream().mapToInt(Rental::frequentRenterPoints).sum();
    }
}
