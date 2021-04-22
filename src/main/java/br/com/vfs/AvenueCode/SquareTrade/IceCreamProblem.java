package br.com.vfs.AvenueCode.SquareTrade;

import java.util.List;

public class IceCreamProblem {

    public static void main(String... args) {
        System.out.println("");
    }
}

// Pricing API
//
// Each IceCreamProduct consists of:
//  1   Container (cup, cone, waffle_cone)
//  0-m Scoops (vanilla, chocolate, etc)
//  0-n Toppings (rainbow sprinkles, chocolate sprinkles, nuts, etc)
//
// Pricing can vary for each specific Container, Scoop, and Topping.
//
// Create an API that given a Product definition, calculates and returns
// the price
//


class Product {

    Integer price;

    Integer getPrice() {
        return price;
    }
}

class Container extends Product {
}

class Scoops extends Product {
}

class Toppings extends Product {
}

class IceCream {
    List<Product> products;
}

class PricingService {
    public Integer calculatePrice(IceCream iceCream) {
        return iceCream.products.stream().map(Product::getPrice).reduce(0, Integer::sum);
    }
}


