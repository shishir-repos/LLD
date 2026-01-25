package org.LLD.Elevator.Strategy;

import org.LLD.Elevator.Enum.Direction;
import org.LLD.Elevator.Model.ElevatorCar;

import java.util.List;

public class OddEvenSelectionStrategy implements ElevatorSelectionStrategy {
    @Override
    public ElevatorCar selectElevator(List<ElevatorCar> elevators, int floor, Direction direction) {
        if (floor % 2 == 0) {
            return elevators.get(1);
        } else {
            return elevators.get(0);
        }
    }
}
