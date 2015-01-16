package shapes;
import java.awt.Color;
import gpdraw.*;

/**
 * Represents a Circle to be drawn in gpdraw.
 * 
 * @author Aleksandar Antic
 * @version 9/12/14
 *
 */
public class Circle extends Shape{
	
	private double myRadius;
	
	/**
	 * Initializes a Circle with myX, myY, and myRadius equaling 0.
	 */
	public Circle() {
		super(0,0,0,new Color(0,0,0));
	}
	
	/**
	 * Initializes a Circle with user-set values.
	 * @param x X-Coordinate of the center of the Circle.
	 * @param y Y-Coordinate of the center of the Circle.
	 * @param radius Radius of the Circle.
	 */
	public Circle(double x, double y, double radius, int thickness, Color c) {
		super(x,y,thickness,c);
		myRadius = radius;
	}
	
	/**
	 * Gets the area of the Circle.
	 * @return Returns the area of the Circle.
	 */
	public double getArea() {
		return Math.PI * myRadius * myRadius;
	}
	
	/**
	 * Gets the circumference of the Circle.
	 * @return Returns the circumference of the circle.
	 */
	public double getCircumference() {
		return Math.PI * 2 * myRadius;
	}
	
	/**
	 * Draws the Circle.
	 * @param marker A DrawingTool initialized with a SketchPad.
	 * @post The Circle is drawn, marker is at (myX, myY), and down.
	 */
	public void draw(DrawingTool marker) {
		super.draw(marker);
		marker.drawCircle(myRadius);
	}
}
