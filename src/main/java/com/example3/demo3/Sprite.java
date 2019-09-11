package com.example3.demo3;

public class Sprite implements DrinkInterface {
    private String name = "Sprite";
    private int price = 50;
    private String detail = "Color like normal water but taste sweet.";

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
