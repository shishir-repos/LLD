package org.LLD.DesignPatterns.Strategy;

public class Runner {

    /**
     * When to Use:
     * When multiple subclasses have the same behavior that is different from the base class implementation.
     *
     * When you want to avoid code duplication across sibling classes.
     *
     * When you have many related classes that differ only in their behavior.
     *
     * When you need to change the algorithm/behavior at runtime (by swapping the strategy object).
     */

    public static void main(String[] args) {
        // Using 1st capability
        Vehicle vehicle = new Hatchback();
        vehicle.drive();

        // Using 2nd Capability
        vehicle = new SUV();
        vehicle.drive();

        // Reusing 2nd Capability
        vehicle = new GT();
        vehicle.drive();
    }
}
