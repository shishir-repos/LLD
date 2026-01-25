package org.LLD.ParkingLot.Models;

public abstract class ParkingSpot {

    private String id;
    private SpotStatus status = SpotStatus.AVAILABLE;
    private VehicleType vehicleType;

    public ParkingSpot(String id, VehicleType vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
    }

    public boolean isAvailable() {
        return this.status == SpotStatus.AVAILABLE;
    }

    public void setStatus(SpotStatus status) {
        this.status = status;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }
}
