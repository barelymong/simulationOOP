package life.entities.animals;

import life.tools.Coordinate;
import life.entities.Entity;
import life.tools.GameMap;

public abstract class Creature extends Entity {
    private int speed; // сколько клеток проходит за 1 ход
    private int hp;
    private int hunger;



    private Coordinate coordinate;

    public  void makeMove(Coordinate nextCoordinate, GameMap gameMap){

    };

    public Boolean isStarving(){
        if(hunger < 70){
            return true;
        }

        return false;
    }
    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

}
