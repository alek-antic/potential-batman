import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.util.*;


public class QuickCrab extends CrabCritter {

    /**
     * Return Move Location
     * Returns a location two spaces to the left or right if
     * that space and the space in between it and the quickcrab are
     * empty. Otherwise uses CrabCritter's move method
     */
    public Location selectMoveLocation(ArrayList<Location> moveLocs) {
    	Grid<Actor> gr = getGrid();
        int direction =  Math.random() < 0.5 ? Location.LEFT : Location.RIGHT;
        Location myLoc = getLocation();
        Location firstLoc = myLoc.getAdjacentLocation(direction);
        Location secondLoc = firstLoc.getAdjacentLocation(direction);
        
    	if (gr.get(firstLoc) == null && gr.get(secondLoc) == null) {
    		return secondLoc;
    	} else {
    		return super.selectMoveLocation(moveLocs);
    	}
    }
}
