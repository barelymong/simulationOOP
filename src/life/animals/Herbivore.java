package life.animals;

import life.Coordinate;
import life.Entity;
import life.GameMap;
import life.Renderer;
import life.objects.Grass;
import life.objects.Ground;
import traversalMethods.BFS;
import traversalMethods.BFSgrid;

import java.util.HashMap;
import java.util.List;


public class Herbivore extends Creature{
    private String image = "\uD83D\uDC18";

    public Boolean hunger;

    @Override
    public void makeMove(Coordinate nextCoordinate, GameMap gameMap) { // Herbivore может потратить свой ход на движение в сторону травы, либо на её поглощение.

        gameMap.setEntityAt(getCoordinate(), new Ground()); // ТРАВА ПЕРЕМЕЩАЕТСЯ НА МЕСТО ГДЕ БЫЛ СЛОН

        gameMap.setEntityAt(nextCoordinate, this); // ПЕРЕМЕЩЕНИЕ СЛОНА НА ПОЛУЧЕННУЮ КООРДИНАТУ


        if(gameMap.getEntityAt(nextCoordinate) instanceof Grass){

            gameMap.replaceEntityAtCoordinateToGround(nextCoordinate); // замена найденной цели на траву
        }
    }




    @Override
    public String getImage() {
        return image;
    }



}
