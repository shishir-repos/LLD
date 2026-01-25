package org.LLD.DesignPatterns.Decorator;

// Concrete Decorator 2
public class Jalapeno extends ToppingDecorator {
    PizzaBase pizzaBase;

    public Jalapeno(PizzaBase pizza) {
        this.pizzaBase = pizza;
    }

    @Override
    public int cost() {
        return this.pizzaBase.cost() + 15;
    }
}
