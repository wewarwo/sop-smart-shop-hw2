package com.example3.demo3;

public class DrinkMenu {
    private String name;
    private String detail;
    private int price;
    private Drink[] drinks;

    public DrinkMenu(String name, String detail, int price, Drink[] drinks) {
        this.name = name;
        this.detail = detail;
        this.price = price;
        this.drinks = drinks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Drink[] getDrinks() {
        return drinks;
    }

    public void setDrinks(Drink[] drinks) {
        this.drinks = drinks;
    }
}
