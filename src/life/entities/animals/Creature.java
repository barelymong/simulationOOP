package life.entities.animals;

import life.entities.naturalEntities.Grass;
import life.entities.naturalEntities.Ground;
import life.tools.Coordinate;
import life.entities.Entity;
import life.tools.GameMap;
import traversalMethods.BFSgrid;

import java.util.Deque;

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

    public void makeEat(Coordinate coordinate, GameMap gameMap){

    }
    Coordinate targetCoordinate;
    Deque<Coordinate> currentPath;
    public void buildPath(GameMap gameMap) {
        currentPath = BFSgrid.createPath(gameMap, getCoordinate(), Grass.class);
        this.targetCoordinate = currentPath.peekLast(); // через peekLast возвращаем, но не удаляем последний элемент path, это всегда конечная координата
    }

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



}
