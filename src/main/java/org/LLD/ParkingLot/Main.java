package org.LLD.ParkingLot;

import org.LLD.ParkingLot.Manager.ParkingLotManager;
import org.LLD.ParkingLot.Models.*;
import org.LLD.ParkingLot.Service.EntranceGate;
import org.LLD.ParkingLot.Service.ExitGate;
import org.LLD.ParkingLot.Strategy.HourlyPricingStrategy;
import org.LLD.ParkingLot.Strategy.NearestSpotStrategy;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String ip = sc.next();

        String[] split = ip.split(",");

       int vehicleCount = split.length;

        // 1. Setup
        ParkingLotManager lot = ParkingLotManager.getInstance();
        ParkingFloor floor1 = new ParkingFloor("Floor 1");
        for (int i = 0; i<vehicleCount; i++) {
            if (split[i].trim().equals("C")) {
                floor1.addSpot(new CarParkingSpot("C" + i));
            } else {
                floor1.addSpot(new BikeParkingSpot("B" + i));
            }
        }
        lot.addFloor(floor1);

        EntranceGate entrance = new EntranceGate(new NearestSpotStrategy());
        ExitGate exit = new ExitGate(new HourlyPricingStrategy());

        // 2. Drive Flow
        ArrayList<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i<vehicleCount; i++) {
            Ticket ticket = null;
            if (split[i].trim().equals("C")) {
                Vehicle myCar = new Car("CAR" + i);
                ticket = entrance.processEntrance(myCar);
                System.out.println("Car Parked. Ticket ID: " + ticket.getTicketId());
            } else {
                Vehicle myBike = new Bike("BIKE" + i);
                ticket = entrance.processEntrance(myBike);
                System.out.println("Bike Parked. Ticket ID: " + ticket.getTicketId());
            }
            tickets.add(ticket);
        }

        Vehicle vehicle = new Car("Wrong Entry");
        try {
            entrance.processEntrance(vehicle);
        } catch (RuntimeException e) {
            System.out.println("No Space for "+vehicle.getVehicleNumber() +" "+vehicle.getVehicleType());
        }

        for (Ticket ticket : tickets) {
            double fee = exit.processExit(ticket);
            System.out.println("Exit processed. Total Fee: " + fee);
        }
    }
}
