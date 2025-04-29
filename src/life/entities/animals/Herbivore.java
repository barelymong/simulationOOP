package life.entities.animals;

import life.tools.Coordinate;
import life.tools.GameMap;
import life.entities.naturalEntities.Grass;
import life.entities.naturalEntities.Ground;
import traversalMethods.BFSgrid;

import java.util.Deque;
import java.util.Random;


public class Herbivore extends Creature{
    Random random = new Random();


    private String image = "\uD83D\uDC18";

    public Herbivore(){
        int randomValuerOfHunger = random.nextInt(70)+31;
        setHunger(randomValuerOfHunger);
    }



    @Override
    public String getImage() {
        return image;
    }



}
