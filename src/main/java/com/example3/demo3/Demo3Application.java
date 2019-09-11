package com.example3.demo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import static com.example3.demo3.DrinkFactory.*;

@RestController
@SpringBootApplication
public class Demo3Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo3Application.class, args);
    }
    public SingletonCart cart = SingletonCart.getInstance();

    @RequestMapping("/")
    String home(){
        return "Drinks Shop<br>/menu to browse menu.<br>/menu/{id} to view menu(0-5).<br>/menu/{id}/add to add menu to cart(0-5).<br>/checkout to checkout.<br>/clear to clear cart.<br>/cart to view cart.";
    }

    @RequestMapping("/menu")
    DrinkInterface[] viewMenuList(){
        return DrinkFactory.getDrinksMenuList();
    }

    @RequestMapping("/cart")
    ArrayList<DrinkInterface> viewcart(){
        return cart.getAll();
    }

    @RequestMapping("/menu/{id}")
    DrinkInterface viewMenu(@PathVariable int id){
        return DrinkFactory.getDrinksMenu(id);
    }

    @RequestMapping({"/menu/{id}/add"})
    String addToCart(@PathVariable int id) {
        if (cart.add(id)) {
            return DrinkFactory.getDrinksMenu(id).getName() + " is added successfully.";
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
        for (DrinkInterface c:
                cart.getAll()) {
            total += c.getPrcie();
        }
        cart.clear();
        return "Total: " + total + " baht\nThank you...";
    }

}