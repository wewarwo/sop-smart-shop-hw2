package com.example3.demo3;

public class GrapeJuice implements DrinkInterface {
    private String name = "Grape juice";
    private int price = 80;
    private String detail = "Grape taste.";

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
