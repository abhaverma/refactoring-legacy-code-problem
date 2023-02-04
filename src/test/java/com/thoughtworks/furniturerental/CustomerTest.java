package com.thoughtworks.furniturerental;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    @Test
    public void customerNameTest() {
        Customer customer = new Customer("Mari");

        assertEquals("Mari", customer.getName());
    }

    @Test
    public void customerStatementTestForNewLaunch() {
        Furniture furniture = new Furniture("Chair", Furniture.NEW_LAUNCH);
        Rental rental = new Rental(furniture, 10);
        Customer customer = new Customer("Mari");
        customer.addRental(rental);

        String statement = customer.statement();

        assertEquals("Rental Record for Mari\n" +
                "\tChair\t3000.0\n" +
                "Amount owed is 3000.0\n" +
                "You earned 2 frequent renter points", statement);
    }

    @Test
    public void customerStatementTestForRegular() {
        Furniture furniture = new Furniture("Chair", Furniture.REGULAR);
        Rental rental = new Rental(furniture, 10);
        Customer customer = new Customer("Mari");
        customer.addRental(rental);

        String statement = customer.statement();

        assertEquals("Rental Record for Mari\n" +
                "\tChair\t1400.0\n" +
                "Amount owed is 1400.0\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void customerStatementTestForChildren() {
        Furniture furniture = new Furniture("Chair", Furniture.CHILDREN);
        Rental rental = new Rental(furniture, 10);
        Customer customer = new Customer("Mari");
        customer.addRental(rental);

        String statement = customer.statement();

        assertEquals("Rental Record for Mari\n" +
                "\tChair\t1200.0\n" +
                "Amount owed is 1200.0\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void customerHTMLStatementTestForNewLaunch() {
        Furniture furniture = new Furniture("Chair", Furniture.NEW_LAUNCH);
        Rental rental = new Rental(furniture, 10);
        Customer customer = new Customer("Mari");
        customer.addRental(rental);

        String statement = customer.htmlStatement();

        assertEquals("<h1>Rental Record for Mari</h1><div>Chair	3000.0</div><div><b>Amount owed is 3000.0</b></div><div><b>You earned 2 frequent renter points</b></div>", statement);
    }
}