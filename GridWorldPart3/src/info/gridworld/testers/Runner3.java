package info.gridworld.testers;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Jumper;
import info.gridworld.grid.Location;

public class Runner3 {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		world.add(new Location(0, 5), new Jumper());
		world.show();
	}

}
