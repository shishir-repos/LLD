package org.LLD.Elevator.Strategy;

import org.LLD.Elevator.Enum.Direction;
import org.LLD.Elevator.Model.ElevatorCar;

import java.util.List;

public interface ElevatorSelectionStrategy {
    ElevatorCar selectElevator(List<ElevatorCar> elevators, int floor, Direction direction);
}
