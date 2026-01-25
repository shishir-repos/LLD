package org.LLD.Elevator;

import org.LLD.Elevator.Enum.Direction;
import org.LLD.Elevator.Service.ElevatorDispatcher;

public class Runner {

    public static void main(String[] args) {
        ElevatorDispatcher dispatcher = ElevatorDispatcher.getInstance();

        // Scenario: Someone on Floor 5 wants to go UP, then someone on Floor 2 wants to go DOWN
        dispatcher.handleExternalRequest(13, Direction.UP);
        dispatcher.handleExternalRequest(11, Direction.UP);
        dispatcher.handleExternalRequest(7, Direction.UP);
        dispatcher.handleExternalRequest(5, Direction.UP);
        dispatcher.handleExternalRequest(3, Direction.DOWN);
        dispatcher.handleExternalRequest(1, Direction.DOWN);

        System.out.println("--- Simulation Starting ---");
        for (int i = 0; i < 15; i++) {
            dispatcher.step();
        }
    }

}
