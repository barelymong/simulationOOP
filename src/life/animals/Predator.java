package life.animals;

import life.Coordinate;

import java.util.List;

public class Predator extends Creature{
    private int strength;
//    @Override
//    public void makeMove(List<Coordinate> path) {
//
//    }
    public void makeAttack(){

    }

    public int getStrength() {
        return strength;
    }



    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String getImage() {
        return null;
    }
}
