package org.LLD.ParkingLot.Models;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    String floorNo;
    List<ParkingSpot> parkingSpots;

    public ParkingFloor(String floorNo) {
        this.floorNo = floorNo;
        parkingSpots = new ArrayList<>();
    }

    public void addSpot(ParkingSpot parkingSpot) {
        this.parkingSpots.add(parkingSpot);
    }

    public List<ParkingSpot> getParkingSpots() {
        return this.parkingSpots;
    }
}
