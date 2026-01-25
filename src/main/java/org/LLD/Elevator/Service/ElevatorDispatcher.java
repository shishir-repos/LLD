package org.LLD.Elevator.Service;

import org.LLD.Elevator.Enum.Direction;
import org.LLD.Elevator.Model.ElevatorCar;
import org.LLD.Elevator.Strategy.ElevatorSelectionStrategy;
import org.LLD.Elevator.Strategy.OddEvenSelectionStrategy;

import java.util.ArrayList;
import java.util.List;

public class ElevatorDispatcher {
    private static ElevatorDispatcher instance;
    private final List<ElevatorCar> elevatorCars;
    private final ElevatorSelectionStrategy elevatorSelectionStrategy;

    private ElevatorDispatcher() {
        elevatorCars = new ArrayList<>();
        elevatorCars.add(new ElevatorCar(1));
        elevatorCars.add(new ElevatorCar(2));
        elevatorSelectionStrategy = new OddEvenSelectionStrategy();
    }

    public static synchronized ElevatorDispatcher getInstance() {
        if (instance == null) {
            instance = new ElevatorDispatcher();
        }
        return instance;
    }

    public void handleExternalRequest(int floor, Direction direction) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ElevatorCar elevatorCar = elevatorSelectionStrategy.selectElevator(elevatorCars, floor, direction);
        System.out.println("Dispatcher assigned Elevator " + elevatorCar.getId() + " to floor " + floor);
        elevatorCar.addRequest(floor);
    }

    public void step() {
        // Simulates one "tick" of time
        for (ElevatorCar car : elevatorCars) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (car.getCurrentDirection() != Direction.IDLE) car.move();
        }
    }
}
