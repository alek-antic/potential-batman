package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

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
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class ChallengeBug extends Bug {
	public boolean wantsToMove() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return false;
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		if (!gr.isValid(next))
			return false;
		Actor neighbor = gr.get(next);
		return (neighbor == null);
	}

	public boolean hasToMove() {
		return !wantsToMove() && canMove();
	}
	
	public void tryTurning() {
		int turns = 0;
		while(!wantsToMove() && turns < 8) {
			turn();
			turns++;
		}
	}
	/**
	 * Moves to the next location of the square.
	 */
	public void act() {
		if(!wantsToMove()){
			tryTurning();
		}
		if(canMove() && wantsToMove() || canMove() && hasToMove()){
			move();
		} else {
			turn();
		}
	}
	
}
