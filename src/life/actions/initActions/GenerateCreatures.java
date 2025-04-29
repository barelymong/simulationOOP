package life.actions.initActions;

import life.tools.Coordinate;
import life.tools.GameMap;
import life.actions.Action;
import life.entities.animals.Creature;
import life.entities.animals.Herbivore;

import java.util.Random;

public class GenerateCreatures implements Action {
    public void perform(GameMap gameMap){
        Random random = new Random();
        //
        //int herbivoreAmount = random.nextInt(4)+3;
        int herbivoreAmount = 6;

        for(int i = 0; i < herbivoreAmount; i++){
            Coordinate coordinate = generateCoordinate(gameMap);
            Creature herbivore = new Herbivore();
            gameMap.setEntityAt(coordinate, herbivore);
            gameMap.creatures.add(herbivore);
        }
    }
    public Coordinate generateCoordinate(GameMap gameMap){
        Random random = new Random();
        int maxX = gameMap.getGlobalX();
        int maxY = gameMap.getGlobalY();

        int x = random.nextInt(maxX);
        int y = random.nextInt(maxY);

        return new Coordinate(x, y);
    }

}
