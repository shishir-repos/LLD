package org.LLD.DesignPatterns.Observer;

public class TVDisplay implements Subscriber {

    @Override
    public void update(float temp) {
        System.out.println("TV Display: " + temp);
    }
}
