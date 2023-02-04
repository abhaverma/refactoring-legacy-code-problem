package com.thoughtworks.furniturerental;


import org.junit.jupiter.api.Test;

import static com.thoughtworks.furniturerental.Furniture.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    @Test
    public void test() {

        int expected = 3;

        assertEquals(expected, 1 + 2);
    }

    @Test
    public void statementForRegularNewLaunchChildrenRentalFor4Days() {
        Customer john = new Customer("John");
        Rental regular = new Rental(new Furniture("Sofa", REGULAR), 4);
        Rental newlaunch = new Rental(new Furniture("Bed", NEW_LAUNCH), 4);
        Rental children = new Rental(new Furniture("Cradle", CHILDREN), 4);
        john.addRental(regular);
        john.addRental(newlaunch);
        john.addRental(children);

        String result = john.statement();

        assertEquals("Rental Record for John\n" +
                "\tSofa\t500.0\n" +
                "\tBed\t1200.0\n" +
                "\tCradle\t300.0\n" +
                "Amount owed is 2000.0\n" +
                "You earned 4 frequent renter points", result);
    }


    @Test
    public void htmlStatementForRegularNewLaunchChildrenRentalFor4Days() {
        Customer john = new Customer("John");
        Rental regular = new Rental(new Furniture("Sofa", REGULAR), 4);
        Rental newlaunch = new Rental(new Furniture("Bed", NEW_LAUNCH), 4);
        Rental children = new Rental(new Furniture("Cradle", CHILDREN), 4);
        john.addRental(regular);
        john.addRental(newlaunch);
        john.addRental(children);

        String result = john.htmlStatement();

        assertEquals("<h1>Rental Record for <b>John</b></h1>\n" +
                "\tSofa\t500.0\n" +
                "\tBed\t1200.0\n" +
                "\tCradle\t300.0\n" +
                "Amount owed is <b>2000.0</b>\n" +
                "You earned <b>4 frequent renter points</b>", result);
    }
}