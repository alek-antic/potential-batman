package info.girdworld.critters;

import info.gridworld.grid.Location;

import java.util.ArrayList;

public class ChameleonKid extends ChameleonCritter {

	
	@Override
	public ArrayList<Location> getActors(){
		return getGrid().get(getLocation().getDirectionToward(Location.AHEAD));
	}
}
