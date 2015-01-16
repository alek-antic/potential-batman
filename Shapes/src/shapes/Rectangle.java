package shapes;
import gpdraw.*;
import java.awt.Color;
/**
 * Represents a Rectangle, to be drawn in gpdraw.
 * 
 * @author Aleksandar Antic
 * @version 9/18/14
 */
public class Rectangle extends Shape{

	private double myWidth, myHeight;
	private boolean isFilled;
	
	/**
	 * Creates a default instance of a rectangle,
	 * with all values set to 0.
	 */
	public Rectangle() {
		super(0,0,1, new Color(0,0,0));
		myWidth=0;
		myHeight=0;
		isFilled=false;
	}
	
	/**
	 * Creates an instance of a rectangle with the top left
	 * corner being the point (x,y), the bottom right being
	 * (x + width, y + height).
	 * 
	 * @param x The X-Coordinate of the center point of the Rectangle.
	 * @param y The Y-Coordinate of the center point of the Rectangle.
	 * @param width The distance in the x-direction of the Rectangle.
	 * @param height The distance in the y-direction of the Rectangle.
	 * @param isFilled Sets whether the rectangle will fill or not when drawn.
	 */
	public Rectangle(double x, double y, double width, double height, boolean isFilled,
			int thickness, Color c) {
		super(x,y,thickness, c);
		myWidth= width;
		myHeight = height;
		this.isFilled = isFilled;
	}
	
	/**
	 * Gets the perimeter of the Rectangle.
	 * @return Returns the perimeter of the Rectangle.
	 */
	public double getPerimeter() {
		return 2 * Math.abs(myHeight) + 2 * Math.abs(myWidth);
	}
	
	/**
	 * Gets the area of the Rectangle.
	 * @return Returns the area of the Rectangle.
	 */
	public double getArea() {
		return Math.abs(myWidth) * Math.abs(myHeight);
	}
	
	/**
	 * Draws the rectangle.
	 * @param marker A DrawingTool initialized with a SketchPad.
	 * @post Draws the Rectangle. Ends with the marker at the (myX, myY), and down.
	 */
	public void draw(DrawingTool marker) {
		super.draw(marker);
		if(isFilled) {
			marker.fillRect(myWidth, myHeight);
		}
		else {
			marker.drawRect(myWidth, myHeight);
		}
	}
}
