import java.awt.Color;

import info.gridworld.actor.*;
import info.gridworld.grid.*;

public class FreedomCritterRunner {
	public static void main (String[] args) {
        ActorWorld world = new ActorWorld();
        Critter c = new Critter();
        Critter c2 = new Critter();
        Missile m = new Missile();
        
        c2.setColor(Color.green);
        c.setDirection(Location.NORTHWEST);
        m.setDirection(Location.NORTHWEST);
        
        world.add(new Location(1, 2), m);
        world.add(new Location(0, 1), c2);
        world.add(new Location(2, 3), c);
        world.add(new Location(7, 5), new Rock());
        world.add(new Location(5, 4), new Rock());
        world.add(new Location(5, 7), new Rock());
        world.add(new Location(7, 3), new Rock());
        world.add(new Location(7, 8), new Flower());
        world.add(new Location(2, 2), new Flower());
        world.add(new Location(3, 5), new Flower());
        world.add(new Location(3, 8), new Flower());
        world.add(new Location(6, 5), new Bug());
        world.add(new Location(5, 3), new Bug());
        world.add(new Location(4, 5), new QuickCrab());
        world.add(new Location(4, 5), new QuickCrab());
        world.add(new Location(6, 1), new QuickCrab());
        world.add(new Location(7, 4), new QuickCrab());
        world.show();
	}
}
