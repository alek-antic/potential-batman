import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.util.ArrayList;


public class ChameleonKid extends ChameleonCritter {
    /**
     * Gets the actors for processing. Implemented to return the actors that
     * occupy locations in front of it or behind it. Override this method in subclasses to
     * look elsewhere for actors to process.<br />
     * Postcondition: The state of all actors is unchanged.
     * @return a list of actors that this critter wishes to process.
     */
    public ArrayList<Actor> getActors()
    {
    	int dir = this.getDirection();
    	ArrayList<Actor> ar = new ArrayList<Actor>();
    	Location loc = this.getLocation();
    	Location fwd = loc.getAdjacentLocation(dir);
    	Location back = loc.getAdjacentLocation(dir + Location.HALF_CIRCLE);
    	Grid<Actor> grid = getGrid();
    	
    	if (grid.isValid(fwd) && grid.get(fwd) != null) ar.add(grid.get(fwd));
    	if (grid.isValid(fwd) && grid.get(back) != null) ar.add(grid.get(back));
    	
    	return ar;
    }
}
