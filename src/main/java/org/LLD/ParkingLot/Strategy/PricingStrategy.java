package org.LLD.ParkingLot.Strategy;

import org.LLD.ParkingLot.Models.VehicleType;

public interface PricingStrategy {
    double calculate(VehicleType vehicleType, long hours);
}
