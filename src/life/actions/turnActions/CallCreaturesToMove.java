package life.actions.turnActions;

import life.tools.Coordinate;
import life.tools.GameMap;
import life.actions.Action;
import life.entities.animals.Creature;
import life.entities.naturalEntities.Grass;
import traversalMethods.BFSgrid;
import traversalMethods.RandomMovement;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Random;

public class CallCreaturesToMove implements Action {

    @Override
    public void perform(GameMap gameMap) {
        for (Creature creature : gameMap.creatures){
            creature.behave(gameMap);
        }
    }
}


