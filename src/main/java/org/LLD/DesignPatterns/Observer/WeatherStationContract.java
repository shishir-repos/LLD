package org.LLD.DesignPatterns.Observer;

public interface WeatherStationContract {

    void add(Subscriber subscriber);

    void remove(Subscriber subscriber);

    void notifyAllSubs();
}
