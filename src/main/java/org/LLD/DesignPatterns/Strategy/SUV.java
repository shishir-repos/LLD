package org.LLD.DesignPatterns.Strategy;

public class SUV extends Vehicle {

    SUV() {
        super(new SportsDriveStrategy());
    }
}
