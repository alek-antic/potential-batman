package schoolobjects;

import java.awt.geom.Point2D;

import gpdraw.DrawingTool;

public abstract class LivingThing implements Drawable{

	
	private Point2D.Double location;

	public LivingThing() {
		location = new Point2D.Double();
	}
	
	
	public void setX(double x) {
		location.setLocation(x, getY());
	}
	
	public void setY(double y) {
		location.setLocation(getX(), y);
	}
	
	public double getX() {
		return location.getX();
	}
	
	public double getY() {
		return location.getY();
	}
	
	@Override
	public void draw(DrawingTool marker) {
		marker.up();
		marker.move(location.getX(), location.getY());
		marker.down();
	}
}