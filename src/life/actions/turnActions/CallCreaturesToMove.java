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

        for (Creature creature : gameMap.creatures){
            // позже будет адаптировано под логику каждого класса Creature, пока только для Elephant

            if(creature.isStarving()) { // если creature голодный то создает путь
                creature.buildPath(gameMap);

                Deque<Coordinate> path = creature.getCurrentPath();
                if (path.isEmpty()) { // если травы по близости не, то он не стоит и ищет targetCoordinate
                    Random random = new Random();
                    randomMovement(gameMap, creature); // случайное движение на смежные координаты
                }


                else {

                    creature.makeMove(path.pop(), gameMap); // осмысленное движение по пути
                    // если creature достиг targetCoordinate, то логика насыщения
                    if (creature.getCoordinate().equals(creature.getTargetCoordinate())){
                        creature.setHunger(creature.getHunger()+10);
                    }
                }
            }


            // если не голоден то путь не создает, а просто шляется или стоит
            else {
                Random random = new Random();
                int movementChance = random.nextInt(101); // шанс подвигаться

                if (movementChance < 60) { // шанс что creature подвигается
                    randomMovement(gameMap, creature);

                } else { // в этом случае creature стоит на месте
                    continue;
                }
            }
        }
    }

        void randomMovement(GameMap gameMap, Creature creature){
                Random random = new Random();
                List<Coordinate> adjCoordinates = RandomMovement.createListOfCoordinatesToMove(gameMap, creature);
                int randomPositionOfList = random.nextInt(adjCoordinates.size()); // рандомизация выбора позиции  из массива со координатами

                Coordinate coordinate = adjCoordinates.get(randomPositionOfList);

                creature.makeMove(coordinate, gameMap);

        }
    }
