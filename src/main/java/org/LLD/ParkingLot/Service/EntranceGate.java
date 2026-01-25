package org.LLD.ParkingLot.Service;

import org.LLD.ParkingLot.Manager.ParkingLotManager;
import org.LLD.ParkingLot.Models.ParkingSpot;
import org.LLD.ParkingLot.Models.SpotStatus;
import org.LLD.ParkingLot.Models.Ticket;
import org.LLD.ParkingLot.Models.Vehicle;
import org.LLD.ParkingLot.Strategy.ParkingStrategy;

public class EntranceGate {

    private final ParkingStrategy parkingStrategy;

    public EntranceGate(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    public Ticket processEntrance(Vehicle vehicle) {
        ParkingSpot spot = parkingStrategy.findSpot(ParkingLotManager.getInstance().getFloors(), vehicle.getVehicleType());
        if (spot == null) {
            throw new RuntimeException("No Spots Found");
        }
        spot.setStatus(SpotStatus.OCCUPIED);
        return new Ticket(spot, vehicle);
    }
}
