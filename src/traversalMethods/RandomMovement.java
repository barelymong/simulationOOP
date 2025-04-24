package traversalMethods;

import life.entities.animals.Creature;
import life.tools.Coordinate;
import life.tools.GameMap;

import java.util.ArrayList;
import java.util.List;

public class RandomMovement {
    static int[] dr = {-1, +1, 0, 0};
    static int[] dc = {0, 0, +1, -1};

    public static List<Coordinate> createListOfCoordinatesToMove(GameMap gameMap, Creature creature){
        List<Coordinate> possibleCoordinateToMove = new ArrayList<>();

    for(int i = 0; i < 4; i++) {
        int adjX = creature.getCoordinate().getX() +dc[i];
        int adjY = creature.getCoordinate().getY() + dr[i];
        Coordinate adjCoordinate = new Coordinate(adjX, adjY);

        if (adjCoordinate.getX() < 0 || adjCoordinate.getY() < 0) {
            continue;
        }
        if (adjCoordinate.getX() >= gameMap.getGlobalX() || adjCoordinate.getY() >= gameMap.getGlobalY()) {
            continue;
        }

        if (!gameMap.getEntityAt(adjCoordinate).isCrossAbility()) {
            continue;
        }

        possibleCoordinateToMove.add(adjCoordinate);
    }

        return possibleCoordinateToMove;
    }
}
