/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

/**
 * This class runs a world that contains crab critters. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class MissileRunner1
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
//		Bug b = new Bug();
//		b.setDirection(180);
		Critter c = new Critter();
		
		world.add(c);
		c.moveTo(new Location(0, 4));
		
		for(int i = 0; i < 10; i++)
		{
			Location loc = new Location(i, 3);
			Location loc1 = new Location(i, 5);
			if(world.getGrid().isValid(loc))
				world.add(loc, new Rock());
			if(world.getGrid().isValid(loc1))
				world.add(loc1, new Rock());
			
		}
		//world.add(new Location(0, 4), b);

		world.add(new Location(2, 4), new Missile());
		world.show();
	}
}