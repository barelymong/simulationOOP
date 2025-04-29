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

    private int hunger;
    private String image = "\uD83D\uDC18";

    public Herbivore(){
        int randomValuerOfHunger = random.nextInt(70)+31;
        setHunger(randomValuerOfHunger);
    }

    Coordinate targetCoordinate;
    Deque<Coordinate> currentPath;

    public void behave(GameMap gameMap)
    {
        System.out.println("Координата Creature: " + getCoordinate());
        // ЛОГИКА ПРИ ГОЛОДЕ
        if (isStarving()) {

            buildPath(gameMap);
            if (currentPath.isEmpty()) {
                randomMovement(gameMap); // случайное движение на смежные координаты
            }

            else {

                makeMove(currentPath.pop(), gameMap);
                if (getCoordinate().equals(targetCoordinate)) {
                    makeEat();
                }
            }
        }

        // ЛОГИКА КОГДА ГОЛОДА НЕТ
        else {
            Random random = new Random();
            int movementChance = random.nextInt(101); // шанс подвигаться

            if (movementChance < 60) { // шанс что creature подвигается
                randomMovement(gameMap);

            } else { // в этом случае creature стоит на месте
                gameMap.setEntityAt(getCoordinate(), this); // лень фиксить. последствие того что вытащил из под цикла и впихнул в функцию. потом пофикшу
            }
        }

    }

    public void makeEat(){
        setHunger(getHunger()+15);
    }


    public void buildPath(GameMap gameMap) {
        currentPath = BFSgrid.createPath(gameMap, getCoordinate(), Grass.class);
        this.targetCoordinate = currentPath.peekLast(); // через peekLast возвращаем, но не удаляем последний элемент path, это всегда конечная координата
    }

    public Boolean isStarving(){
        if(hunger < 55){
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

    @Override
    public String getImage() {
        return image;
    }



}
