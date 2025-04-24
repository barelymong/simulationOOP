package life.actions.turnActions;

import life.actions.Action;
import life.entities.animals.Creature;
import life.tools.GameMap;

public class CreatureToStarve implements Action {

    @Override
    public void perform(GameMap gameMap) {
        for (Creature creature : gameMap.creatures) {
            creature.setHunger(creature.getHunger()-1);
        }
        }
    }

