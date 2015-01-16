package shapes;
import java.awt.Color;

import gpdraw.DrawingTool;
/**
 * @author Aleksandar Antic
 * @version 9/17/2014
 */
public class Arrow extends Shape {
	
	private double length;
	private boolean direction;
	
	/**
	 * Creates a new Arrow at a coordinate (x,y) and facing left or right.
	 * @param x The X-Coordinate of the tip of the arrow.
	 * @param y The Y-Coordinate of the tip of the arrow.
	 * @param d Determines left or right. false is right, true is left.
	 */
	public Arrow(double x, double y, boolean d, int thickness, Color c, double length) {
		super(x,y,thickness, c);
		direction = d;
		this.length = length;
	}
	
	/**
	 * Draws the Arrow.
	 * @param marker A DrawingTool initialized with a SketchPad object.
	 * @post marker is at getX(),getY() The angle depends on direction, true results in
	 * 210 degrees counter clockwise from the positive X-Axis,
	 * false results in 330 degrees counter clockwise from the positive X-Axis.
	 */
	public void draw(DrawingTool marker) {
		super.draw(marker);
		if(direction) {
			marker.setDirection(150);
			marker.forward(length);
			marker.up();
			marker.move(getX(), getY());
			marker.down();
			marker.setDirection(210);
			marker.forward(length);
		} else {

			marker.setDirection(30);
			marker.forward(length);
			marker.up();
			marker.move(getX(), getY());
			marker.down();
			marker.setDirection(330);
			marker.forward(length);
			
		}
	}
}
