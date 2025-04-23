package life.actions.turnActions;

import life.tools.Coordinate;
import life.tools.GameMap;
import life.actions.Action;
import life.entities.animals.Creature;
import life.entities.naturalEntities.Grass;
import traversalMethods.BFSgrid;

import java.util.Deque;

public class CallCreaturesToMove implements Action {

    @Override
    public void perform(GameMap gameMap) {
    for(Creature creature : gameMap.creatures) {
        Deque<Coordinate> path = BFSgrid.createPath(gameMap, creature.getCoordinate(), Grass.class);
        creature.makeMove(path.pop(), gameMap);
        System.out.println("Координата слона " + creature.getCoordinate());
        }
    }
}
