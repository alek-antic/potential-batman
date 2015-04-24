package info.girdworld.critters;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class BlusterCritter extends Critter {

	private int courage;
	
	public BlusterCritter(int c) {
		courage = c;
	}
	
	
	@Override
	public ArrayList<Actor> getActors() {
		ArrayList<Actor> actors = getGrid().getNeighbors(getLocation());
		Location loc1 = getLocation().getAdjacentLocation(Location.NORTHEAST);
		Location loc2 = getLocation().getAdjacentLocation(Location.NORTHWEST);
		Location loc3 = getLocation().getAdjacentLocation(Location.SOUTHEAST);
		Location loc4 = getLocation().getAdjacentLocation(Location.SOUTHWEST);
		
		actors.addAll(getGrid().getNeighbors(loc1));
		actors.addAll(getGrid().getNeighbors(loc2));
		actors.addAll(getGrid().getNeighbors(loc3));
		actors.addAll(getGrid().getNeighbors(loc4));
		
		for(int j = 0; j < actors.size(); j++) {
			for(int i = 0; i < actors.size(); i++){
				if(actors.get(j).equals(actors.get(i)))
					actors.remove(actors.get(i));
			}
			if(actors.get(j).equals(this))
				actors.remove(j);
		}
		
		return actors;
		
	}
	
	
	@Override
	public void processActors(ArrayList<Actor> actors) {
		int c = 0;
		for(Actor a : actors) {
			if(a instanceof Critter)
				c++;
		}
		
		if(c >= courage)
			setColor(getColor().darker());
		else
			setColor(getColor().brighter());
	}
	
}
