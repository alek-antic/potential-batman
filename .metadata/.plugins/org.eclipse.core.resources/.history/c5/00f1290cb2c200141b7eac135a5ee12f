package info.gridworld.testers;

import info.gridworld.actor.*;
import info.gridworld.grid.*;

public class ATester {

	
	public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        Jumper reproducer = new Jumper();
        Rock rock = new Rock();
        
        reproducer.setDirection(Location.NORTH);
        world.add(new Location(1,5), rock);
        world.add(new Location(3,5), reproducer);
        world.show();
    }
}
