package life;

import life.actions.Action;
import life.actions.initActions.GenerateCreatures;
import life.actions.turnActions.CallCreaturesToMove;
import life.actions.initActions.CreateWorld;
import life.tools.Coordinate;
import life.tools.GameMap;
import life.tools.Renderer;

import java.util.*;

public class Simulation {
    List<Action> initActions = new ArrayList<>();
    List<Action> turnActions = new ArrayList<>();
    public GameMap gameMap;

    Simulation(Coordinate gameMapSize) {
        this.gameMap = new GameMap(gameMapSize);
    }

    public void startSimulation() {
        initActions.add(new CreateWorld());
        initActions.add(new GenerateCreatures());
        for (Action action : initActions) {
            action.perform(gameMap);
        }
    }

    public void nextTurn() {
        turnActions.add(new CallCreaturesToMove());


        while (true) {
            for (Action action : turnActions) {
                action.perform(gameMap);
            }
            Renderer.renderMap(gameMap);
            System.out.println(" ||| Количество слонов: " + gameMap.creatures.size());
            try {
                Thread.sleep(1000); // Задержка между кадрами
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }


        }
    }
    public void pauseSimulation() {
    }

    public static void main(String[] args) {

        Simulation simulation = new Simulation(new Coordinate(30, 6));
        simulation.startSimulation();
        simulation.nextTurn();
        }
    }

