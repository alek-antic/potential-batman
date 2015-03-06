package info.gridworld.actor;

import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

public class Jumper extends Actor {

	public Jumper() {
		setColor(Color.RED);
	}
	
	public Jumper(Color jumperColor) {
		setColor(jumperColor);
	}
	
	@Override
	public void act() {
		int action = getActionType();
		
		if(action == -1) {
			removeSelfFromGrid();
		} else if (action == 0) {
			jump();
		} else if (action == 1){
			wallJump();
		} else if (action == 2) {
			
			Actor jumper = getGrid().get((getLocation().getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection())));
			Color d = jumper.getColor();
			Color c = getColor();
			Jumper j = new Jumper(new Color((int)((c.getRed() + d.getRed())/2.0), (int)((c.getGreen() + d.getGreen())/2.0), (int)((c.getBlue() +d. getBlue())/2.0)));
			j.putSelfInGrid(getGrid(), getLocation().getAdjacentLocation(getDirection()));
			turn();
		}
	}
	
	public void turn() {
		setDirection(getDirection() + Location.RIGHT);
	}
	
	public void jump() {
		Grid<Actor> gr = getGrid();
		if(gr == null)
			return;
		Location loc = getLocation();
		
		Location dest = loc.getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection());
		Actor thing = gr.get(dest);
		
		if(thing instanceof Flower || thing instanceof Rock) {
			
			int x = 0;
			int y = 0;
			if(gr instanceof BoundedGrid) {
				y = gr.getNumRows();
				x = gr.getNumCols();
			} else {
				y = 9;
				x = 9;
			}
			Flower[] flowers = new Flower[x+y];
			for(int i = 0; i < flowers.length; i++)
				flowers[i] = new Flower(Color.RED);
			
			for(int i = 0; i < x; i++) {
				if(i == loc.getCol())
					continue;
				flowers[i].putSelfInGrid(gr, new Location(dest.getRow(), i));
			}
			
			for(int i = 0; i < y; i++) {
				if(i==loc.getRow())
					continue;
				flowers[x+i].putSelfInGrid(gr, new Location(i,dest.getCol()));
			}
			moveTo(dest);
			Flower f = new Flower(Color.RED);
			f.putSelfInGrid(gr, loc);
		} else if (thing instanceof Actor) {
			Rock[] rocks = new Rock[8];
			for(int i =0; i <8; i++)
				rocks[i] = new Rock();
			Location[] adjacents = new Location[8];
			for(int i = 0; i< adjacents.length; i++) {
				adjacents[i]= dest.getAdjacentLocation(i * Location.HALF_RIGHT);
			}
			
			for(int i = 0; i < adjacents.length; i++) {
				if(adjacents[i] == null)
					continue;
				rocks[i].putSelfInGrid(gr, adjacents[i]);
			}
			moveTo(dest);
			
		} else {
			moveTo(dest);
		}
		
	}
	
	public void wallJump() {
		Location loc = getLocation();
		Location dest = loc.getAdjacentLocation(getDirection() + Location.HALF_RIGHT);
		turn();
		moveTo(dest);
		
	}
	
	/**
	 * 
	 * @return An integer that specifies what type of jump a Jumper will do. -1 kills the Jumper, 0 is a regular jump, and 1 is a wall jump.
	 */
	public int getActionType() {
		
		Grid<Actor> gr = getGrid();
		if(gr == null)
			return -1;
		
		int dir = getDirection();
		Location current = getLocation();
		Location next = current.getAdjacentLocation(dir);
		Location dest = current.getAdjacentLocation(dir).getAdjacentLocation(dir);
		
		if(!gr.isValid(next)) {
			return -1;
		}
		
		if(!gr.isValid(dest))
			return 1;
		
		Actor jumper = gr.get(dest);
		
		if(jumper instanceof Jumper) {
			return 2;
		}
		
		return 0;
	}
}
