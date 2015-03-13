package simschool.usables;

import gpdraw.*;

public interface Drawable {

	/**
	 * 
	 * @param marker DrawingTool used to draw things
	 * @param x starting x-position of marker
	 * @param y starting y-position of marker
	 */
	public void draw(DrawingTool marker, int x, int y);
	
	
}