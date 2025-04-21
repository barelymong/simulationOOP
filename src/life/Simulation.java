package life;

import life.actions.InitActions;
import life.animals.Creature;
import life.animals.Herbivore;
import life.objects.Grass;
import life.objects.Ground;
import life.objects.Tree;
import traversalMethods.BFS;
import traversalMethods.BFSgrid;

import java.util.*;

public class Simulation {
    static public GameMap gameMap;
    public void nextTurn(){};
    public void startSimulation(){};

    public void pauseSimulation(){};

    public Simulation(Coordinate gameMapSize){
        gameMap = InitActions.createWorld(gameMapSize);
    }






    public static void main(String[] args) {

        Simulation simulation = new Simulation(new Coordinate(150, 17));

        Generator generator = new Generator(gameMap);

        generator.generateCreature();

        while(true) {
            for(Creature creature : gameMap.creatures) {
                Deque<Coordinate> path = BFSgrid.createPath(gameMap, creature.getCoordinate(), Grass.class);
                Renderer.clearScreen();

                creature.makeMove(path.pop(), gameMap);
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
    }




//    List<Coordinate> path = BFSgrid.createPath(gameMap, elephanto1.getCoordinate(), Grass.class);
//            for(int step = 0; step < path.size(); step++) { // проходимся по пути, от начальной координаты к координате цели
//        Renderer.clearScreen(); // очистка экрана
//
//        Coordinate stepCoordinate = new Coordinate(path.get(step)); // получение координат пути
//
//        elephanto1.makeMove(stepCoordinate, gameMap);
//
//        Renderer.renderMap(gameMap);
//
//        try {
//        Thread.sleep(300); // Задержка между кадрами
//        } catch (InterruptedException e) {
//        Thread.currentThread().interrupt();
//        }
//
//        }
//        }