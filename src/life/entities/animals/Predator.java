package life.entities.animals;

import life.tools.GameMap;

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

    @Override
    public Boolean isStarving() {
        return super.isStarving();
    }

    @Override
    public void behave(GameMap gameMap) {

    }


    @Override
    public void buildPath(GameMap gameMap) {
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String getImage() {
        return null;
    }
}
