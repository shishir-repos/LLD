package org.LLD.DesignPatterns.Observer;

public class MobileDisplay implements Subscriber {

    @Override
    public void update(float temp) {
        System.out.println("Mobile Display: " + temp);
    }
}
