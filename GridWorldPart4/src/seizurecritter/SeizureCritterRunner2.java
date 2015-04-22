package seizurecritter;
import java.awt.Color;

import info.gridworld.actor.*;
import info.gridworld.grid.Location;


public class SeizureCritterRunner2 {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
        world.add(new Location(5, 4), new Rock());
        world.add(new Location(3, 4), new Rock(Color.GRAY));
        world.add(new Location(3, 5), new Rock(Color.GREEN));
        world.add(new Location(3, 6), new Rock(Color.BLUE));
        world.add(new Location(4, 6), new Rock(Color.CYAN));
        world.add(new Location(5, 6), new Rock(Color.DARK_GRAY));
        world.add(new Location(5, 5), new Rock(Color.MAGENTA));
        world.add(new Location(4, 4), new Rock(Color.YELLOW));
        world.add(new Location(4, 5), new SeizureCritter(3));
        world.show();
	}

}
