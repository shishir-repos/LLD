package org.LLD.DesignPatterns.Strategy;

public class GT extends Vehicle {

    GT() {
        super(new SportsDriveStrategy());
    }

}
