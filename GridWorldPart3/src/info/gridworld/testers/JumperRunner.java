package info.gridworld.testers;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Jumper;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class JumperRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Location(5,5), new Jumper());
        world.add(new Location(3,5), new Rock()); 
        world.show();

    }
}
