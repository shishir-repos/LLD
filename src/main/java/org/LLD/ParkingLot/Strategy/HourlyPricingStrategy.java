package org.LLD.ParkingLot.Strategy;

import org.LLD.ParkingLot.Models.VehicleType;

public class HourlyPricingStrategy implements PricingStrategy {

    @Override
    public double calculate(VehicleType vehicleType, long hours) {
        double basePrice = 0.0;
        if (VehicleType.CAR.equals(vehicleType)) {
            basePrice = 2.0;
        } else if (VehicleType.BIKE.equals(vehicleType)) {
            basePrice = 1.5;
        }

        return basePrice * hours;
    }
}
