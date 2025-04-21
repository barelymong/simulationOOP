package life.animals;

import life.Coordinate;
import life.Entity;
import life.GameMap;

import java.util.List;

public abstract class Creature extends Entity {
    private int speed; // сколько клеток проходит за 1 ход
    private int hp;

    private Coordinate coordinate;

    public  void makeMove(Coordinate nextCoordinate, GameMap gameMap){

    };

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

//    @Override
//    public String getImage() {
//        return image;
//    }
}
