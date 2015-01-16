package shapes;
	import java.awt.Color;
	import gpdraw.*;
	
	/**
	 * @author Aleksandar Antic
	 * @version 9/12/14
	 */
public class Sphere extends Shape{
	
	private double z, radius, zoom, mass;
	private static double lightX, lightY, lightZ;
	
	/**
	 * Creates a new instance of a Sphere with all values set to 0.
	 */
	public Sphere() {
		super(0,0,1, new Color(0,0,0));
		z=0;
		radius = 0;
		zoom = 0;
		mass = 0;
		lightX = 0;
		lightY = 0;
		lightZ = 0;
	}
	
	/**
	 * Creates a new instance of a Sphere with the fields initialized to the parameters.
	 * @param xCoord X-Coordinate of the center of the Sphere.
	 * @param yCoord Y-Coordinate of the center of the Sphere.
	 * @param zCoord Y-Coordinate of the center of the Sphere.
	 * @param r Radius of the Sphere.
	 * @param zoom Distance from the origin to the 45 degree mark on the x-axis.
	 * @param m Mass of the Sphere.
	 * @param x2 X-Coordinate of where the light hits the Sphere.
	 * @param y2 Y-Coordinate of where the light hits the Sphere.
	 * @param z2 Z-Coordinate of where the light hits the Sphere.
	 * @pre radius > 0, z != 0, zoom != 0
	 */
	
	public Sphere(double xCoord, double yCoord, double zCoord, double r, double zoom, double m,
			double x2, double y2, double z2, Color c) {
		super(xCoord / zCoord * zoom, yCoord / zCoord * zoom, 1, c);
		z = zCoord;
		radius=r;
		this.zoom = zoom;
		mass = m;
		lightX=x2;
		lightY=y2;
		lightZ=z2;
	}
	
	/**
	 * Gets the surface area of the Sphere.
	 * @return Returns the surface area of the Sphere.
	 */
	public double getSA() {
		return Math.PI * 4 * radius * radius;
	}
	
	/**
	 * Gets the volume of the Sphere.
	 * @return Returns the volume of the Sphere.
	 */
	public double getVolume() {
		return Math.PI * 4 / 3 * Math.pow(radius, 3);
	}
	
	/**
	 * Gets the maximum circumference of the Sphere.
	 * @return Returns the maximum circumference of the Sphere.
	 */
	public double getMaxCircumference() {
		return Math.PI * radius * 2;
	}
	
	/**
	 * Gets the density of the Sphere.
	 * @return Returns the density of the Sphere.
	 */
	public double getDensity() {
		return mass/getVolume();
	}
	
	/**
	 * Gets the weight of the Sphere.
	 * @return Returns the weight of the Sphere.
	 */
	public double getWeight() {
		return mass * 9.81;
	}
	
	/**
	 * Draws the Sphere onto a SketchPad, with a light providing as the optical illusion to
	 * make it appear 3D.
	 * @param marker a DrawingTool initialized with a SketchPad.
	 * @post Draws the Sphere. Moves the marker to the location 
	 * where the center of light is, sets the color to white.
	 */
	public void draw(DrawingTool marker) {
		super.draw(marker);
		double initR = radius / z * zoom;
		double lgtX = lightX / lightZ * zoom;
		double lgtY = lightY / lightZ * zoom;
		double m = (lgtY - getY())/(lgtX-getX());
		int colorInc = (int)(255/radius);
		marker.up();
		marker.move(getX(), getY());
		marker.down();
		for(int i = (int)initR; i >= 0; i--) {
			marker.setColor(new Color(255 - i* colorInc, 255 - i* colorInc, 255 - i* colorInc));
			marker.up();
			marker.move((getX() + initR - i)/lightZ * zoom, (m*(initR-i) + getY())/lightZ * zoom);
			marker.down();
			marker.fillCircle(i);
		}
	}
}
