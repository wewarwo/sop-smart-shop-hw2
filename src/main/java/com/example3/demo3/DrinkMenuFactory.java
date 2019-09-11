package com.example3.demo3;

public class DrinkMenuFactory {
    public static final DrinkMenu[] drinkMenus = new DrinkMenu[] {
            new DrinkMenu("SodaLover", "A couple of soda can.", 100, new Drink[]{new Drink(0), new Drink(1)}),
            new DrinkMenu("JuiceSet", "Juice, good for your health.", 100, new Drink[]{new Drink(2), new Drink(3)}),
            new DrinkMenu("EnergyDrink", "Energy for you.", 200, new Drink[]{new Drink(4), new Drink(5)}),
            new DrinkMenu("JustGiveMeAllOfThat", "Get all we got.", 400, new Drink[]{new Drink(0), new Drink(1), new Drink(2), new Drink(3), new Drink(4), new Drink(5)})
    };

    public static DrinkMenu getDrinkMenu(int menu) {
        return drinkMenus[menu];
    }

    public static DrinkMenu[] getDrinkMenuList() {
        return drinkMenus;
    }
}
