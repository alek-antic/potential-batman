package info.gridworld.testers;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Jumper;
import info.gridworld.grid.Location;

public class Runner2 {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		world.add(new Location(1, 5), new Jumper());
		world.show();
	}

}
