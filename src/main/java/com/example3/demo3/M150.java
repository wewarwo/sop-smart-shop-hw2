package com.example3.demo3;

public class M150 implements DrinkInterface {
    private String name = "M150";
    private int price = 100;
    private String detail = "Thai Energy.";

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
