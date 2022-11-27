package com.thoughtworks.furniturerental;

public class Furniture {
    public static final int REGULAR = 0;
    public static final int NEW_LAUNCH = 1;
    public static final int CHILDREN = 2;

    private String title;
    private int priceCode;

    public Furniture(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int arg) {
        priceCode = arg;
    }

    public String getTitle() {
        return title;
    }

}