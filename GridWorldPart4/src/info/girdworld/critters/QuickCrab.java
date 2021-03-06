package info.girdworld.critters;

import java.util.ArrayList;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class QuickCrab extends CrabCritter {

	@Override
	public ArrayList<Location> getLocationsInDirections(int[] directions) {
		
		 ArrayList<Location> locs = new ArrayList<Location>();
	        Grid gr = getGrid();
	        Location loc = getLocation();
	    
	        for(int d : directions)
	        	System.out.println(d);
	        
	        for (int d : directions)
	        {
	            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
	           // System.out.println(d);
	            Location farNeighborLoc = neighborLoc.getAdjacentLocation(getDirection() + d);
	            if (gr.isValid(neighborLoc) && gr.get(neighborLoc) == null)
	                locs.add(neighborLoc);
	            else 
	            	continue;
	            
	            if(gr.isValid(farNeighborLoc) && gr.get(farNeighborLoc) == null)
	            	locs.add(farNeighborLoc);
	        }
	        for(Location l: locs)
	        {
	        	//System.out.println(l);
	        }
	        return locs;
	}
	
	
	@Override
	public ArrayList<Location> getMoveLocations() {
		ArrayList<Location> locs = new ArrayList<Location>();
        int[] dirs =
            { Location.LEFT, Location.RIGHT };
        locs = getLocationsInDirections(dirs);
        
        return locs;
	}
	
	@Override
	public Location selectMoveLocation(ArrayList<Location> locations) {
		ArrayList<Location> adjLocs = super.getMoveLocations();
	
		for(int i = 0; i < locations.size(); i++){
			for(int j = 0; j < adjLocs.size(); j++) {
				if(locations.get(i).equals(adjLocs.get(j)))
					locations.remove(i);
			}
		}
		ArrayList<Location> farLocs = locations;
		
		int farSize = farLocs.size();
		if(farSize != 0) {
			int rand = (int) (Math.random() * farSize);
			return farLocs.get(rand);
		} else {
			if(adjLocs.size() == 0)
				return getLocation();
			int rand = (int) (Math.random() * adjLocs.size());
			return adjLocs.get(rand);
		}
	}
}
