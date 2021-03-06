package schoolobjects;

import java.awt.Color;
import java.awt.geom.Point2D;

import gpdraw.DrawingTool;

public abstract class LivingThing implements Drawable{

	private boolean selected;
	private Point2D.Double location;

	public LivingThing() {
		selected = false;
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
	
	public void setSelected(boolean sel) {
		selected = sel;
	}
	
	public boolean getSelected() {
		return selected;
	}
	
	@Override
	public void draw(DrawingTool marker) {
		marker.up();
		marker.move(getX(), getY());
		marker.down();
		marker.setColor(Color.BLACK);
		marker.setDirection(0);
		
	}
}
