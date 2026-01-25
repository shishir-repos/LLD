package org.LLD.DesignPatterns.Decorator;

public class Runner {
    public static void main(String[] args) {
        PizzaBase pizza = new Jalapeno(new ExtraCheese(new Margherita()));
        System.out.println("This pizza will cost you: "+pizza.cost());

        pizza = new Jalapeno(new Margherita());
        System.out.println("This pizza will cost you: "+pizza.cost());
    }
}
