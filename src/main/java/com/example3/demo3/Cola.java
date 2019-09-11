package com.example3.demo3;

public class Cola implements DrinkInterface {
    private String name = "Cola";
    private int price = 50;
    private String detail = "Classic soda drink";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrcie() {
        return price;
    }

    @Override
    public String getDetail() {
        return detail;
    }
}
