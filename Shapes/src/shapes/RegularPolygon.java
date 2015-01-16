package shapes;

import gpdraw.*;
import java.awt.Color;

/**
 * 
 * @author Aleksandar Antic
 * @version 9/24/14
 *
 */
public class RegularPolygon extends Shape {

	private int numSides;
	private double sideLength;
	private Circle r, R;
	private Line[] lines;

	/**
	 * Sets all fields to default values.
	 */
	public RegularPolygon() {
		super(0, 0, 1, new Color(0,0,0));
		numSides = 3;
		sideLength = 100;
		calcr();
		calcR();
		lines = new Line[3];
		lines[0] = new Line(getR(), 0, 150, sideLength, 1, new Color(0,0,0));
		lines[1] = new Line(lines[0].getX2(), lines[0].getY2(), 270, sideLength, 1, new Color(0,0,0));
		lines[2] = new Line(lines[1].getX2(), lines[1].getY2(), 30, sideLength, 1, new Color(0,0,0));
	}

	/**
	 * Creates a new RegularPolygon.
	 * 
	 * @param myX X-Coordinate of the center of the polygon.
	 * @param myY Y-Coordinate of the center of the polygon.
	 * @param myThickness The thickness of the lines used to draw the polygon.
	 * @param myColor The color of the polygon.
	 * @param s The number of sides in the polygon.
	 * @param sL The length of each side.
	 */
	public RegularPolygon(double myX, double myY, int myThickness,
			Color myColor, int s, double sL) {
		super(myX, myY, myThickness, myColor);
		if(s <= 2){
			throw new IllegalArgumentException("Invalid number of sides");
		} else {
			numSides = s;
			sideLength = sL;
			calcr();
			calcR();
			lines = new Line[numSides];
			for(int i = 0; i < lines.length; i++) {
				if(i != 0) {
					lines[i] = new Line(lines[i-1].getX2(),lines[i-1].getY2(),
							(int)(180-(calcVertexAngle()/2) + i*360.0/s), sL, myThickness, myColor);
				} else {
					lines[0] = new Line(myX + getR(), myY, 180 - (int)(calcVertexAngle()/2),
							sL, myThickness, myColor);
				}
			}
		}
	}

	private void calcr() {
		r = new Circle(getX(), getY(), getr(), 1, getColor());
	}

	private void calcR() {
		R = new Circle(getX(), getY(), getR(), 1, getColor());
	}

	/**
	 * Calculates the vertex angle.
	 * @return The vertex angle, in degrees.
	 */
	public double calcVertexAngle() {
		return ((double)numSides - 2) / (double) numSides * 180.0;
	}

	/**
	 * Calculates the perimeter.
	 * @return The perimeter of the polygon.
	 */
	public double calcPerimeter() {
		return numSides * sideLength;
	}

	/**
	 * Calculates the area.
	 * @return The area of the polygon.
	 */
	public double calcArea() {
		return 0.5 * numSides * getR() * getR()
				* Math.sin(2 * Math.PI / numSides);
	}

	/**
	 * Gets the number of sides.
	 * @return The number of sides.
	 */
	public int getNumSides() {
		return numSides;
	}

	/**
	 * Gets the length of each side.
	 * @return The length of a side.
	 */
	public double getSideLength() {
		return sideLength;
	}

	/**
	 * Gets the radius of the circumscribed circle.
	 * @return The radius of the circumscribed circle.
	 */
	public double getR() {
		return 0.5 * sideLength / Math.sin(Math.PI / numSides);
	}

	/**
	 * Gets the radius of the inscribed circle.
	 * @return The radius of the inscribed circle.
	 */
	public double getr() {
		return 0.5 * sideLength / Math.tan(Math.PI / numSides);
	}

	/**
	 * Draws the RegularPolygon.
	 * @param marker A DrawingTool initialized with a SketchPad.
	 * @pre marker will have whatever settings it had before the call.
	 * @post marker will end at (getX() + getR(), getY()), and in drawing mode.
	 */
	public void draw(DrawingTool marker) {
		super.draw(marker);
		for(int i=0; i < lines.length; i++) {
			lines[i].draw(marker);
		}
	}

	/**
	 * Draws the circumscribed circle and inscribed circle.
	 * @param marker A DrawingTool initialized with a SketchPad.
	 * @pre marker will have whatever settings it had before the call.
	 * @post marker will end at (getX(), getY()), and in drawing mode. 
	 */
	public void drawBoundingCircles(DrawingTool marker) {
		r.draw(marker);
		R.draw(marker);
	}

}
