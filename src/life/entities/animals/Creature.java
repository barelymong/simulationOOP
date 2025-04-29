package life.entities.animals;

import life.entities.naturalEntities.Grass;
import life.entities.naturalEntities.Ground;
import life.tools.Coordinate;
import life.entities.Entity;
import life.tools.GameMap;
import traversalMethods.BFSgrid;
import traversalMethods.RandomMovement;

import java.util.Deque;
import java.util.List;
import java.util.Random;

public abstract class Creature extends Entity {
    private int speed; // сколько клеток проходит за 1 ход
    private int hp;
    private int hunger;



    private Coordinate coordinate;

    public void makeMove(Coordinate nextCoordinate, GameMap gameMap) {

        gameMap.setEntityAt(getCoordinate(), new Ground());
        gameMap.setEntityAt(nextCoordinate, this);


    }
    public Boolean isStarving(){
        if(hunger < 55){
            return true;
        }

        return false;
    }

    public abstract void behave(GameMap gameMap);


    Coordinate targetCoordinate;
    Deque<Coordinate> currentPath;
    public abstract void buildPath(GameMap gameMap);

    public Coordinate getTargetCoordinate() {
        return targetCoordinate;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public Deque<Coordinate> getCurrentPath() {
        return currentPath;
    }

    void randomMovement(GameMap gameMap){
        Random random = new Random();
        List<Coordinate> adjCoordinates = RandomMovement.createListOfCoordinatesToMove(gameMap, this);
        int randomPositionOfList = random.nextInt(adjCoordinates.size()); // рандомизация выбора позиции  из массива со координатами

        Coordinate coordinate = adjCoordinates.get(randomPositionOfList);

        makeMove(coordinate, gameMap);

    }


}
