package life;
import life.animals.Creature;
import life.animals.Herbivore;
import life.objects.*;

import java.util.Random;
public class Generator {
    public GameMap gameMap;

    Generator(GameMap gameMap){
        this.gameMap = gameMap;
    }
    public static NaturalEntity generateWorld(){

        Random randTrue = new Random();
        //double rand = Math.random(7);
        double rand = randTrue.nextDouble();
        if(rand <= 0.03){
            return new Rock();
        }

        else if(rand <= 0.09){
            return new Tree();
        }

        else if(rand <= 0.15){
            return new Grass();
        }
        else{
            return new Ground();
        }
    }
    public Coordinate generateCoordinate(){
        Random random = new Random();
        int maxX = gameMap.getGlobalX();
        int maxY = gameMap.getGlobalY();

        int x = random.nextInt(maxX);
        int y = random.nextInt(maxY);

        return new Coordinate(x, y);
    }

    public void generateCreature(){
        Random random = new Random();
        int herbivoreAmount = random.nextInt(4)+3;

        for(int i = 0; i < herbivoreAmount; i++){
            Coordinate coordinate = generateCoordinate();
            Creature herbivore = new Herbivore();
            gameMap.setEntityAt(coordinate, herbivore);
            gameMap.creatures.add(herbivore);
        }
    }

}
