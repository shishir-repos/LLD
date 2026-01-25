package org.LLD.ParkingLot.Models;

public class Ticket {
    private String ticketId;
    private long startTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;

    public Ticket(ParkingSpot parkingSpot, Vehicle vehicle) {
        long time = System.currentTimeMillis();
        ticketId = "TKN-" + time;
        startTime = time;
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
}
