package shapes;
import java.awt.Color;

import gpdraw.DrawingTool;

/**
 * @author Aleksandar Antic
 * @version 9/18/2014
 */
public class Line extends Shape {
	
	private double x2, y2;
	
	/**
	 * Creates a new Line with beginning coordinate at (x,y) and end coordinate at (x2,y2).
	 * @param x The X-coordinate of the start point of the Line.
	 * @param y The Y-coordinate of the start point of the Line.
	 * @param x2 The X-coordinate of the end point of the Line.
	 * @param y2 The Y-coordinate of the end point of the Line.
	 * @param thickness The thickness of the Line, in pixels.
	 * @param c The Color of the Line.
	 */
	public Line(double x, double y, double x2, double y2, int thickness, Color c) {
		super(x,y,thickness,c);
		this.x2=x2;
		this.y2=y2;
	}
	
	/**
	 * 
	 * @param x The X-Coordinate of the origin of the Line.
	 * @param y The Y-Coordinate of the origin of the Line.
	 * @param angle The angle of the Line, counterclockwise from the positive x-axis.
	 * @param length The length of the Line, in pixels.
	 * @param thickness The thickness of the Line, in pixels.
	 */
	public Line(double x, double y, int angle, double length, int thickness, Color c) {
		this(x, y, (x + length*Math.cos(Math.toRadians(angle))),
				(y+length*Math.sin(Math.toRadians(angle))), thickness, c);
	}
	
	/**
	 * Gets the ending x-coordinate.
	 * @return The x-coordinate.
	 */
	public double getX2() {
		return x2;
	}
	
	/**
	 * Gets the ending y-coordinate.
	 * @return The y-coordinate.
	 */
	public double getY2() {
		return y2;
	}
	/**
	 * Draws the Line.
	 * @param marker A DrawingTool initialized with a SketchPad object.
	 * @post marker ends at (x2, y2), with the width of the the marker set to thickness.
	 */
	public void draw(DrawingTool marker) {
		super.draw(marker);
		marker.move(x2,y2);
	}
}
