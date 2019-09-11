package com.example3.demo3;

public class OrangeJuice implements DrinkInterface {
    private String name = "Orange juice";
    private int price = 80;
    private String detail = "Orange from our farm.";

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
