package seizurecritter;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.Color;


public class SeizureRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Location(0, 0), new Rock(Color.BLUE));
        world.add(new Location(1, 0), new Rock(Color.GREEN));
        world.add(new Location(2, 0), new Rock(Color.CYAN));
        world.add(new Location(0, 1), new Rock(Color.MAGENTA));
        world.add(new Location(2, 1), new Rock(Color.ORANGE));
        world.add(new Location(0, 2), new Rock(Color.RED));
        world.add(new Location(1, 2), new Rock(Color.GRAY));
        world.add(new Location(2, 2), new Rock(Color.BLACK));
        world.add(new Location(1, 1), new SeizureCritter(0));
        world.show();
    }
}