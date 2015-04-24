package info.girdworld.critters;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.util.ArrayList;



public class KingCrab extends CrabCritter {

	@Override
	public void processActors(ArrayList<Actor> actors) {
		for(Actor a : actors) {
			Location moveTo = a.getLocation().getAdjacentLocation(getDirection());
			if(getGrid().get(moveTo) == null)
				a.moveTo(moveTo);
			else
				a.removeSelfFromGrid();
		}
	}
}
