package life.tools;

import life.entities.Entity;
import life.entities.animals.Creature;
import life.entities.naturalEntities.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameMap {


    private int globalX;
    private int globalY;


    public GameMap(Coordinate coordinate) // конструктор для размера карты
    {
        this.globalX = coordinate.getX();
        this.globalY = coordinate.getY();

    };

    private Map<Coordinate, Entity> map = new HashMap<>(); // сама карта - ее содержание в виде хэш таблицы


    public HashMap<Class<?>, Integer> amountOfEntities;
    public List<Creature> creatures = new ArrayList<>();

    public void setEntityAt(Coordinate coordinate, Entity entity){
        entity.setCoordinate(coordinate);
        map.put(coordinate, entity);

    }

    public Entity getEntityAt(Coordinate coordinate){
        return map.get(coordinate); // get = получение значения по ключу
    }

    public Boolean isPositionValid(Coordinate coordinate){
        return map.containsKey(coordinate);
    }

    public void replaceEntityAtCoordinateToGround(Coordinate coordinate) {
        map.put(coordinate, new Ground());
    }


    public int getGlobalX() {
        return globalX;
    }

    public void setGlobalX(int globalX) {
        this.globalX = globalX;
    }

    public int getGlobalY() {
        return globalY;
    }

    public void setGlobalY(int globalY) {
        this.globalY = globalY;
    }





}
