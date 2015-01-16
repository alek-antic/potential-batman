package shapes;
import gpdraw.*;
import java.awt.Color;

/**
 * 
 * @author Aleksandar Antic
 * @version 9/20/14
 *
 */
public abstract class Shape {
	
	private double x, y;
	private int thickness;
	private Color c;
	
	/**
	 * Creates a new Shape with basic properties.
	 * @param myX The X Coordinate of the Shape.
	 * @param myY The Y Coordinate of the Shape.
	 * @param myThickness The thickness of the border of the Shape. 
	 * @param myColor The color of the Shape.
	 */
	public Shape(double myX, double myY, int myThickness, Color myColor) {
		x = myX;
		y = myY;
		thickness = myThickness;
		c= myColor;
	}
	
	/**
	 * 
	 * @param marker A DrawingTool initialized with a SketchPad.
	 * @post marker is at (x,y), with a width of thickness, and a color of c.
	 */
	public void draw(DrawingTool marker) {
		marker.up();
		marker.move(x,y);
		marker.setWidth(thickness);
		marker.setColor(c);
		marker.down();
	}
	
	/**
	 * Gets the X Coordinate.
	 * @return Returns the X Coordinate of the Shape.
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Gets the Y Coordinate.
	 * @return Returns the Y Coordinate of the Shape.
	 */	
	public double getY() {
		return y;
	}
	
	/**
	 * Gets the Color.
	 * @return Returns the Color of the Shape.
	 */
	public Color getColor() {
		return c;
	}
	
}
