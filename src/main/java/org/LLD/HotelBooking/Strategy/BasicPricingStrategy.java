package org.LLD.HotelBooking.Strategy;

import org.LLD.HotelBooking.Model.Room;

public class BasicPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(Room room, long nights) {
        double baseMultiplier = 1.5;
        return room.getBasePrice() * baseMultiplier * nights;
    }
}
