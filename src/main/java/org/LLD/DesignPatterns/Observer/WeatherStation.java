package org.LLD.DesignPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements WeatherStationContract {

    List<Subscriber> subscribers = new ArrayList<>();
    float temp;

    @Override
    public void add(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void remove(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifyAllSubs() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(temp);
        }
    }

    public void setTemp(float temp) {
        this.temp = temp;
        notifyAllSubs();
    }
}
