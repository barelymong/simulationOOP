package life.actions;

import life.Coordinate;
import life.Entity;
import life.GameMap;
import life.Generator;
import life.objects.NaturalEntity;

public class InitActions extends Actions {

    public static GameMap createWorld(Coordinate coordinate){
        GameMap gameMap= new GameMap(coordinate);
        for(int y = 0; y < gameMap.getGlobalY(); y++){
            for(int x = 0; x < gameMap.getGlobalX(); x++){
                NaturalEntity naturalEntity = Generator.generateWorld();
                Coordinate globalCoordinate = new Coordinate(x, y);
                //добавление координат
                naturalEntity.setCoordinate(globalCoordinate);

                gameMap.setEntityAt(globalCoordinate, naturalEntity);
            }
        }

        return gameMap;
    }

}
