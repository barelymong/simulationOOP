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

            // ЕСЛИ ГОЛОДЕН ТО СОЗДАЕТ ПУТЬ
            if(creature.isStarving()) {
                System.out.println("СЛОН ГОЛОДЕН");
                Deque<Coordinate> path = BFSgrid.createPath(gameMap, creature.getCoordinate(), Grass.class);

                if (path.isEmpty()) {
                    Random random = new Random();

                    int movementChance = random.nextInt(101); // шанс подвигаться

                    if (movementChance < 60) { // шанс что creature подвигается
                        List<Coordinate> adjCoordinates = RandomMovement.createListOfCoordinatesToMove(gameMap, creature);
                        int randomPositionOfList = random.nextInt(adjCoordinates.size()); // рандомизация выбора позиции  из массива со координатами

                        Coordinate coordinate = adjCoordinates.get(randomPositionOfList);

                        creature.makeMove(coordinate, gameMap);


                    } else { // в этом случае creature стоит на месте
                        continue;
                    }
                }

                else {
                    creature.makeMove(path.pop(), gameMap);
                }

            }


            // ЕСЛИ НЕ ГОЛОДЕН ТО НЕ СОЗДАЕТ ПУТЬ. СХОЖАЯ ЛОГИКА ПЕРЕДВИЖЕНИЯ КОГДА ТРАВЫ ВООБЩЕ НЕТ
            else {


                Random random = new Random();

                int movementChance = random.nextInt(101); // шанс подвигаться

                if (movementChance < 60) { // шанс что creature подвигается
                    List<Coordinate> adjCoordinates = RandomMovement.createListOfCoordinatesToMove(gameMap, creature);
                    int randomPositionOfList = random.nextInt(adjCoordinates.size()); // рандомизация выбора позиции  из массива со координатами

                    Coordinate coordinate = adjCoordinates.get(randomPositionOfList);

                    creature.makeMove(coordinate, gameMap);


                } else { // в этом случае creature стоит на месте
                    continue;
                }
            }
        }





        }
    }
