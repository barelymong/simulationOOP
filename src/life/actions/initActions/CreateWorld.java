package life.actions.initActions;

import life.tools.Coordinate;
import life.tools.GameMap;
import life.actions.Action;
import life.entities.naturalEntities.*;

import java.util.Random;

public class CreateWorld implements Action {

    @Override
    public void perform(GameMap gameMap){
        for(int y = 0; y < gameMap.getGlobalY(); y++){
            for(int x = 0; x < gameMap.getGlobalX(); x++){
                NaturalEntity naturalEntity = generateWorld();
                Coordinate globalCoordinate = new Coordinate(x, y);
                //добавление координат
                naturalEntity.setCoordinate(globalCoordinate);
                gameMap.setEntityAt(globalCoordinate, naturalEntity);

            }
        }

    }

    public NaturalEntity generateWorld(){

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

}
