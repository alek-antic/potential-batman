import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.util.ArrayList;


public class KingCrab extends CrabCritter {

	/**
	 * Moves other actors to the side or removes them from the grid cuz
	 * nobody gets in teh King's way
	 */
    public void processActors(ArrayList<Actor> actors) {
    	Grid<Actor> gr = getGrid();
    	Location myLoc = getLocation();
        for (Actor a : actors) {
        	Location aLoc = a.getLocation();
            int direction = myLoc.getDirectionToward(aLoc);
            Location nextLoc = aLoc.getAdjacentLocation(direction);
             
            if (gr.isValid(nextLoc)) {
            	Actor n = gr.get(nextLoc);
            	if (!(n instanceof Critter || n instanceof Rock)) {
            		a.moveTo(nextLoc);
            		continue;
            	}
            }
            a.removeSelfFromGrid();
        }
    } 
}
