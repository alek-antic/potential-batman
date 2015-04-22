package seizurecritter;

import info.gridworld.actor.*;
import info.gridworld.grid.Location;

import java.awt.Color;


public class Runner4 {
	public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Location(5, 6), new Rock());
        world.add(new Location(5, 4), new Rock());
        world.add(new Location(4, 4), new Flower(Color.BLUE));
        world.add(new Location(4, 5), new Flower(Color.PINK));
        world.add(new Location(4, 6), new Flower(Color.RED));
        world.add(new Location(6, 4), new Flower(Color.ORANGE));
        world.add(new Location(6, 5), new Flower(Color.YELLOW));
        world.add(new Location(6, 6), new Flower(Color.GREEN));
        world.add(new Location(5, 5), new SeizureCritter(5));
        world.show();
    }
}
