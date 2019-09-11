package com.example3.demo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@SpringBootApplication
public class Demo3Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo3Application.class, args);
    }
    public SingletonCart cart = SingletonCart.getInstance();
    public int cost = 0;

    @RequestMapping("/")
    String home(){
        return "Drinks Shop<br>/menu to browse menu.<br>/menu/{id} to view menu.<br>/menu/{id}/add to add menu to cart.<br>/checkout to checkout.<br>/clear to clear cart.";
    }

    @RequestMapping("/menu")
    DrinkMenu[] viewMenuList(){
        return DrinkMenuFactory.getDrinkMenuList();
    }

    @RequestMapping("/menu/{id}")
    DrinkMenu viewMenu(@PathVariable int id){
        return DrinkMenuFactory.getDrinkMenu(id);
    }

    @RequestMapping({"/menu/{id}/add"})
    String addToCart(@PathVariable int id) {
        if (cart.add(id)) {
            return DrinkMenuFactory.getDrinkMenu(id).getName() + " is added successfully.";
        } else {
            return "menu is unavailable";
        }
    }

    @RequestMapping({"/clear"})
    String clear() {
        cart.clear();
        return "Cart is cleared";
    }

    @RequestMapping({"/checkout"})
    String checkout() {
        int total = 0;
        for (DrinkMenu c:
                cart.getAll()) {
            total += c.getPrice();
        }
        cart.clear();
        return "Total: " + total + " baht\nThank you...";
    }

}