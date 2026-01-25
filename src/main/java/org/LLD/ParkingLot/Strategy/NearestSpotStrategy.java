package org.LLD.ParkingLot.Strategy;

import org.LLD.ParkingLot.Models.ParkingFloor;
import org.LLD.ParkingLot.Models.ParkingSpot;
import org.LLD.ParkingLot.Models.VehicleType;

import java.util.List;

public class NearestSpotStrategy implements ParkingStrategy {

    @Override
    public ParkingSpot findSpot(List<ParkingFloor> floors, VehicleType vehicleType) {
        for (ParkingFloor floor : floors) {
            for (ParkingSpot spot: floor.getParkingSpots()) {
                if (spot.isAvailable() && spot.getVehicleType() == vehicleType ) {
                    return spot;
                }
            }
        }

        return null;
    }
}
