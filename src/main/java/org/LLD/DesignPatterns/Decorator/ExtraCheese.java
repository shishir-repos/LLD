package org.LLD.DesignPatterns.Decorator;

// Concrete Decorator 1
public class ExtraCheese extends ToppingDecorator {

    PizzaBase pizzaBase; // Has-a relationship

    ExtraCheese(PizzaBase pizzaBase) {
        this.pizzaBase = pizzaBase;
    }

    @Override
    public int cost() {
        // Base cost + topping cost
        return this.pizzaBase.cost() + 10;
    }
}
