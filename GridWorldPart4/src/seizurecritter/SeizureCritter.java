package seizurecritter;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.*;
import info.gridworld.grid.*;

public class SeizureCritter extends Critter {
	private int stability;
	private int seizureCount;
	
	public SeizureCritter (int c) {
		stability = c;
		seizureCount = 0;
	}
	
    public void processActors(ArrayList<Actor> actors) {
		Grid<Actor> gr = getGrid();
		Location myLoc = getLocation();
		ArrayList<Color> colors = new ArrayList<Color>();
		
		for (Actor a : actors) {
			Color c = a.getColor();
			if (!colors.contains(c)) {
				System.out.println("here");
				colors.add(c);
			}
		}

    	if (colors.size() >= stability) {
    		setDirection(45 * (int)(Math.random() * 8));
    		setColor(new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256)));
    		
    		Location secondLoc = myLoc.getAdjacentLocation(Location.AHEAD);
    		Location thirdLoc = secondLoc.getAdjacentLocation(Location.AHEAD);
    		Actor a = gr.get(myLoc.getAdjacentLocation(Location.AHEAD));
    		
    		if (gr.isValid(thirdLoc) && gr.get(secondLoc) == null) a.moveTo(thirdLoc);
    		else if (gr.isValid(thirdLoc) && gr.get(thirdLoc) == null) a.moveTo(secondLoc);
    		
    		seizureCount++;
    		
    		if (seizureCount == 10) {
    			removeSelfFromGrid();
    		}
    	} else {    		
            ArrayList<Location> moveLocs = getMoveLocations();
            Location loc = selectMoveLocation(moveLocs);
            makeMove(loc);
            
            Flower f = new Flower();
            f.setColor(new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256)));
            
            
            if (!myLoc.equals(getLocation()))
            	gr.put(myLoc, f);
            
            seizureCount  = 0;
            
    	}
		
	}
    
    public void act() {
        if (getGrid() == null)
            return;
        ArrayList<Actor> actors = getActors();
        processActors(actors);
    }
	
	
}
