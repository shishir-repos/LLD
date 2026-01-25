package org.LLD.ParkingLot.Manager;

import org.LLD.ParkingLot.Models.ParkingFloor;
import org.LLD.ParkingLot.Models.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager {

    private static ParkingLotManager instance;
    private List<ParkingFloor> floors;

    private ParkingLotManager() {

    }

    public static synchronized ParkingLotManager getInstance() {
        if (instance == null) {
            instance = new ParkingLotManager();
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor) {
        if (floors == null) {
            floors = new ArrayList<>();
        }
        floors.add(floor);
    }

    public List<ParkingFloor> getFloors() {
        return this.floors;
    }
}
