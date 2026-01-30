package org.LLD.HotelBooking.Strategy;

import org.LLD.HotelBooking.Model.Room;

public interface PricingStrategy {

    double calculatePrice(Room room, long nights);
}
