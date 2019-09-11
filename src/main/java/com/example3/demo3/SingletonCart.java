package com.example3.demo3;


import java.util.ArrayList;

public class SingletonCart {
    private ArrayList<DrinkMenu> DrinkMenus;
    private static SingletonCart instance;

    private SingletonCart() {
        DrinkMenus = new ArrayList<DrinkMenu>();
    }

    public static SingletonCart getInstance() {
        if (instance == null) {
            instance = new SingletonCart();
        }
        return instance;
    }

    public void clear() {
        DrinkMenus.clear();
    }

    public boolean add(int menuId) {
        if (menuId < 0 || menuId > DrinkMenuFactory.getDrinkMenuList().length) {
            return false;
        } else {
            DrinkMenus.add(DrinkMenuFactory.getDrinkMenu(menuId));
            return true;
        }

    }

    public boolean remove(int menuId) {
        if (menuId < 0 || menuId > DrinkMenus.size()) {
            return false;
        } else {
            DrinkMenus.remove(menuId);
            return true;
        }
    }

    public ArrayList<DrinkMenu> getAll() {
        return DrinkMenus;
    }
}
