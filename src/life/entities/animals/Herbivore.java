package life.entities.animals;

import life.tools.Coordinate;
import life.tools.GameMap;
import life.entities.naturalEntities.Grass;
import life.entities.naturalEntities.Ground;

import java.util.Random;


public class Herbivore extends Creature{
    Random random = new Random();

    private String image = "\uD83D\uDC18";

    public Herbivore(){
        int randomValuerOfHunger = random.nextInt(50)+51;
        setHunger(randomValuerOfHunger);
    }

    @Override
    public void makeMove(Coordinate nextCoordinate, GameMap gameMap) { // Herbivore может потратить свой ход на движение в сторону травы, либо на её поглощение.

        gameMap.setEntityAt(getCoordinate(), new Ground()); // ТРАВА ПЕРЕМЕЩАЕТСЯ НА МЕСТО ГДЕ БЫЛ СЛОН

        gameMap.setEntityAt(nextCoordinate, this); // ПЕРЕМЕЩЕНИЕ СЛОНА НА ПОЛУЧЕННУЮ КООРДИНАТУ


    }




    @Override
    public String getImage() {
        return image;
    }



}
