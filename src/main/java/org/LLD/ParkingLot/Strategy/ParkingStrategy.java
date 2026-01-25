package org.LLD.ParkingLot.Strategy;

import org.LLD.ParkingLot.Models.ParkingFloor;
import org.LLD.ParkingLot.Models.ParkingSpot;
import org.LLD.ParkingLot.Models.VehicleType;

import java.util.List;

public interface ParkingStrategy {
    ParkingSpot findSpot(List<ParkingFloor> floors, VehicleType vehicleType);
}
