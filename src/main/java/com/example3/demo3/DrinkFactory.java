package com.example3.demo3;

public class DrinkFactory {
    private static DrinkInterface[] drinks = new DrinkInterface[]{new Cola(), new Sprite(), new OrangeJuice(), new GrapeJuice(), new M150(), new MonsterIII()};
    public static DrinkInterface[] getDrinksMenuList() {
        return drinks;
    }
    public static DrinkInterface getDrinksMenu(int index) {
        return drinks[index];
    }
    public static int getMenuLength() {
        return drinks.length;
    }
}
