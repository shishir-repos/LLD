package org.LLD.DesignPatterns.Strategy;

public class Hatchback extends Vehicle {

    Hatchback() {
        super(new NormalDriveStrategy());
    }

}
