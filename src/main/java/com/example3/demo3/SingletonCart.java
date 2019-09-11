package com.example3.demo3;


import java.io.*;
import java.util.ArrayList;

public class SingletonCart {
    private static ArrayList<DrinkInterface> DrinkMenus;
    private static ArrayList<String> DrinkMenusIds;
    private static SingletonCart instance;
    private static String line;

    private SingletonCart() {
        DrinkMenusIds = new ArrayList<String>();
        DrinkMenus = new ArrayList<DrinkInterface>();
    }

    public static SingletonCart getInstance() {
        if (instance == null) {
            instance = new SingletonCart();
        }
        try {
            FileReader fileReader = new FileReader("cart.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                if (Integer.parseInt(line) >= 0 && Integer.parseInt(line) < DrinkFactory.getMenuLength()) {
                    DrinkMenus.add(DrinkFactory.getDrinksMenu(Integer.parseInt(line)));
                    DrinkMenusIds.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            try {
                PrintWriter writer = new PrintWriter("cart.txt", "UTF-8");
                writer.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return instance;
    }

    public void clear() {
        DrinkMenus.clear();
        DrinkMenusIds.clear();
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("cart.txt");
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public boolean add(int menuId) {
        if (menuId < 0 || menuId > DrinkFactory.getMenuLength()) {
            return false;
        } else {
            FileWriter writer = null;
            try {
                writer = new FileWriter("cart.txt");
                for(String str: DrinkMenusIds) {
                    writer.write(str + System.lineSeparator());
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            DrinkMenus.add(DrinkFactory.getDrinksMenu(menuId));
            DrinkMenusIds.add(Integer.toString(menuId));
            return true;
        }

    }

    public ArrayList<DrinkInterface> getAll() {
        return DrinkMenus;
    }
}
