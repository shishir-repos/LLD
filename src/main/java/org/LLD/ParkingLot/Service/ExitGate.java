package org.LLD.ParkingLot.Service;

import org.LLD.ParkingLot.Models.SpotStatus;
import org.LLD.ParkingLot.Models.Ticket;
import org.LLD.ParkingLot.Strategy.ParkingStrategy;
import org.LLD.ParkingLot.Strategy.PricingStrategy;

public class ExitGate {
    private PricingStrategy pricingStrategy;

    public ExitGate(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double processExit(Ticket ticket) {
        double price = pricingStrategy.calculate(ticket.getVehicle().getVehicleType(), 2);
        ticket.getParkingSpot().setStatus(SpotStatus.AVAILABLE);
        return price;
    }
}
