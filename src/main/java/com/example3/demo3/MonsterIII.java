package com.example3.demo3;

public class MonsterIII implements DrinkInterface {
    private String name = "MonsterIII";
    private int price = 100;
    private String detail = "Monster enerygy for you.";

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
