package info.girdworld.critters;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class ChameleonKid extends ChameleonCritter {

	
	@Override
	public ArrayList<Actor> getActors(){
		ArrayList<Actor> frontback = new ArrayList<Actor>();
		if(getLocation().getAdjacentLocation(Location.AHEAD) != null)
			frontback.add(getGrid().get(getLocation().getAdjacentLocation(Location.AHEAD)));
		if(getLocation().getAdjacentLocation(Location.HALF_CIRCLE) != null)
			frontback.add(getGrid().get(getLocation().getAdjacentLocation(Location.HALF_CIRCLE)));
		return frontback;
	}
	
	
}