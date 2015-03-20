package schoolobjects;

import gpdraw.DrawingTool;

public abstract class LivingThing implements Drawable{

	
	
	
	@Override
	public void draw(DrawingTool marker, int x, int y) {
		marker.up();
		marker.move(x,y);
		marker.down();
	}
}
