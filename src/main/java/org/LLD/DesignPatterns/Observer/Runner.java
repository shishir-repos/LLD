package org.LLD.DesignPatterns.Observer;

public class Runner {

    public static void main(String[] args) {
        Subscriber subscriber = new MobileDisplay();
        Subscriber subscriber1 = new TVDisplay();

        WeatherStation weatherStation = new WeatherStation();
        weatherStation.add(subscriber);
        weatherStation.add(subscriber1);

        weatherStation.setTemp(32.3f);
        System.out.println();

        weatherStation.setTemp(34.2f);
        System.out.println();

        weatherStation.setTemp(28.0f);
        System.out.println();

        weatherStation.remove(subscriber1);
        weatherStation.setTemp(20.0f);
    }

}
