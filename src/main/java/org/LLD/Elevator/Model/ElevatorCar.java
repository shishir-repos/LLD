package org.LLD.Elevator.Model;

import org.LLD.Elevator.Enum.Direction;
import org.LLD.Elevator.Enum.State;

import java.util.Collections;
import java.util.TreeSet;

public class ElevatorCar {
    int id;
    int currentFloor = 5;
    Direction currentDirection = Direction.IDLE;
    State currentState = State.IDLE;

    // LOOK Algorithm: TreeSet ensures we stop at floors in order
    TreeSet<Integer> upRequests = new TreeSet<>();
    TreeSet<Integer> downRequests = new TreeSet<>(Collections.reverseOrder());

    public ElevatorCar(int id) {
        this.id = id;
    }

    public void addRequest(int floor) {
        if (floor > currentFloor) {
            upRequests.add(floor);
        } else if (floor < currentFloor) {
            downRequests.add(floor);
        } else {
            System.out.println("Elevator " + id + "is already at " + currentFloor);
        }
        if (currentDirection == Direction.IDLE) {
            currentDirection = floor > currentFloor ? Direction.UP : Direction.DOWN;
        }
    }

    public void move() {
        if (currentDirection == Direction.UP) {
            if (!upRequests.isEmpty()) {
                currentFloor = upRequests.pollFirst(); // Stop at the nearest up-floor
                System.out.println("Elevator " + id + " reached floor " + currentFloor + " (UP)");
            }
            if (upRequests.isEmpty()) currentDirection = downRequests.isEmpty() ? Direction.IDLE : Direction.DOWN;
        } else if (currentDirection == Direction.DOWN) {
            if (!downRequests.isEmpty()) {
                currentFloor = downRequests.pollFirst(); // Stop at the nearest down-floor
                System.out.println("Elevator " + id + " reached floor " + currentFloor + " (DOWN)");
            }
            if (downRequests.isEmpty()) currentDirection = upRequests.isEmpty() ? Direction.IDLE : Direction.UP;
        }
    }

    public int getId() {
        return id;
    }

    public Direction getCurrentDirection() {
        return this.currentDirection;
    }
}
