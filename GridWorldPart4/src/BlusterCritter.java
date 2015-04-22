import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.awt.Color;
import java.util.*;


public class BlusterCritter extends Critter {
    private static final double FACTOR = 0.95;
	private int courage;
	private double[] lowRatio, highRatio, actualColor;
	
	public BlusterCritter(int c) {
		super();
		Color oC = getColor();
		courage = c;
		
		actualColor = new double[]{oC.getRed(), oC.getGreen(), oC.getBlue()};
    	int[] arr = {oC.getRed(), oC.getGreen(), oC.getBlue()};
    	Arrays.sort(arr);
    	if (arr[2] != 0) {
	    	lowRatio = new double[]{(double)arr[0]/arr[2], (double)arr[1]/arr[2], 1};
	    	highRatio = new double[]{254 + lowRatio[0], 254 + lowRatio[1], 255};
    	} else {
    		lowRatio = highRatio = new double[]{-1};
    	}
	}
	
    /**
     * Gets the actors for processing. Implemented to return the actors that
     * occupy neighbors within two steps of its location. Override this method in subclasses to
     * look elsewhere for actors to process.<br />
     * Postcondition: The state of all actors is unchanged.
     * @return a list of actors that this critter wishes to process.
     */
    public ArrayList<Actor> getActors()
    {
    	Location loc = this.getLocation();
    	int col = loc.getCol();
    	int row = loc.getRow();
    	Grid<Actor> gr = getGrid();
        ArrayList<Actor> ar = new ArrayList<Actor>();
        
        for (int x = col - 2; x <= col + 2; x++) {
        	for (int y = row - 2; y <= row + 2; y++) {
        		if (x == col && y == row) {
        			continue;
        		}
        	
        		Location current = new Location(y, x);
        	
        		if (gr.isValid(current) && gr.get(current) != null)
        			ar.add(gr.get(current));
        	}
        }
                                
        return ar;
    }
    
    /**
     * Processes the elements of <code>actors</code>. New actors may be added
     * to empty locations. Implemented to darken based on surrounding actors. Override this method in subclasses to
     * process actors in a different way. <br />
     * Postcondition: (1) The state of all actors in the grid other than this
     * critter and the elements of <code>actors</code> is unchanged. (2) The
     * location of this critter is unchanged.
     * @param actors the actors to be processed
     */
    public void processActors(ArrayList<Actor> actors)
    {	
    	if ((actors.size() - 1) >= courage) {
    		//darken
    		setColor(darken());
    	} else {
    		//lighten
    		setColor(brighten());
    	}
    }
    
    //ACTUAL GOOD DOESNT MESS UP ON BLACKS/WHITES BRIGHTENING
    private Color brighten () {
    	double r = actualColor[0] < lowRatio[0] ? lowRatio[0] : actualColor[0];
    	double g = actualColor[1] < lowRatio[1] ? lowRatio[1] : actualColor[1];
    	double b = actualColor[2] < lowRatio[2] ? lowRatio[2] : actualColor[2];
    	
    	actualColor = new double[]{
    			Math.min(r/FACTOR, 255),
    			Math.min(g/FACTOR, 255),
    			Math.min(b/FACTOR, 255)
    	};
        return new Color(Math.min((int)(r/FACTOR), 255),
                         Math.min((int)(g/FACTOR), 255),
                         Math.min((int)(b/FACTOR), 255));
    }
    
    private Color darken () {
    	double r = actualColor[0] > highRatio[0] ? highRatio[0] : actualColor[0];
    	double g = actualColor[1] > highRatio[1] ? highRatio[1] : actualColor[1];
    	double b = actualColor[2] > highRatio[2] ? highRatio[2] : actualColor[2];

    	actualColor = new double[]{r*FACTOR, g*FACTOR, b*FACTOR};
    	return new Color(Math.max((int)(r*FACTOR), 0),
                 Math.max((int)(g*FACTOR), 0),
                 Math.max((int)(b*FACTOR), 0));
    }    
}
