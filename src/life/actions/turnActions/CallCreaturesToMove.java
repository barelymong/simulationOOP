package life.actions.turnActions;

import life.tools.Coordinate;
import life.tools.GameMap;
import life.actions.Action;
import life.entities.animals.Creature;
import life.entities.naturalEntities.Grass;
import traversalMethods.BFSgrid;
import traversalMethods.RandomMovement;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Random;

public class CallCreaturesToMove implements Action {

    @Override
    public void perform(GameMap gameMap) {
        for (Creature creature : gameMap.creatures) {
            Deque<Coordinate> path = BFSgrid.createPath(gameMap, creature.getCoordinate(), Grass.class);
            if (path.isEmpty()) {
                Random random = new Random();

                int movementChance = random.nextInt(101); // шанс подвигаться

                if (movementChance < 60) {
                    List<Coordinate> randomCoordinates = RandomMovement.createListOfCoordinatesToMove(gameMap, creature);
                    int randomPositionOfList = random.nextInt(randomCoordinates.size()); // рандомизация выбора пути на основе размера массива

                    Coordinate coordinate = randomCoordinates.get(randomPositionOfList);

                    creature.makeMove(coordinate, gameMap);


                }

                else{
                    System.out.println("Слон рандомно не ходит");
                    continue;
                    }
                }


            else {
                creature.makeMove(path.pop(), gameMap);
            }
            }
        }
    }
