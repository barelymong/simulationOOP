package life;

import life.tools.Coordinate;

public class SimulationTest {
    public static void main(String[] args) {
        Simulation simulation = new Simulation(new Coordinate(30, 9));
        simulation.startSimulation();
        simulation.nextTurn();
    }
}
