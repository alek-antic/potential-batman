import java.awt.Color;
import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList

import gpdraw.*; // for DrawingTool 

public class IrregularPolygon extends Shape {
	private ArrayList<Point2D.Double> myPolygon;

	// constructors
	public IrregularPolygon() {
		super(0,0,1, new Color(0,0,0));
		myPolygon = new ArrayList<Point2D.Double>();
	}

	// public methods
	public void add(Point2D.Double aPoint) {
		myPolygon.add(aPoint);
	}

	public void draw(DrawingTool marker) {
		if(myPolygon.size() == 0)
			return;
		super.draw(marker);
		double x1 = myPolygon.get(0).getX();
		double y1 = myPolygon.get(0).getY();
		marker.up();
		marker.move(x1,y1);
		marker.down();
		for(int i = 0; i < myPolygon.size(); i++) {
			double x2;
			double y2;
			if(i == myPolygon.size()-1) {  
				x2 = myPolygon.get(0).getX();
				y2 = myPolygon.get(0).getY();
			} else {
				x2 = myPolygon.get(i+1).getX();
				y2 = myPolygon.get(i+1).getY();
			}
			marker.move(x2,y2);
		}
	}

	public double perimeter() {
		if(myPolygon.size() == 0)
			return 0;
		double perim = 0;
		for(int i = 0; i < myPolygon.size(); i++) {
			double x1 = myPolygon.get(i).getX();
			double y1 = myPolygon.get(i).getY();
			double x2;
			double y2;
			if(i == myPolygon.size()-1) {  
				x2 = myPolygon.get(0).getX();
				y2 = myPolygon.get(0).getY();
			} else {
				x2 = myPolygon.get(i+1).getX();
				y2 = myPolygon.get(i+1).getY();
			}
			perim += Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
		}
		return perim;
	}

	public double area() {
		if(myPolygon.size() == 0)
			return 0;
		double area = 0;
		for(int i = 0; i < myPolygon.size(); i++) {
			double x1 = myPolygon.get(i).getX();
			double y2;
			if(i == myPolygon.size()-1) {  
				y2 = myPolygon.get(0).getY();
			} else {
				y2 = myPolygon.get(i+1).getY();
			}
			area += x1*y2;
		}
		
		for(int i = 0; i < myPolygon.size(); i++) {
			double y1 = myPolygon.get(i).getY();
			double x2;
			if(i == myPolygon.size()-1) {  
				x2 = myPolygon.get(0).getX();
			} else {
				x2 = myPolygon.get(i+1).getX();
			}
			area -= x2 * y1;
		}
		return Math.abs(area / 2);
	}
	
	public void translateX(int distance) {
		for(Point2D.Double pt : myPolygon) {
			pt.setLocation(pt.getX() + distance, pt.getY());
		}
	}
	
	public void translateY(int distance) {
		for(Point2D.Double pt : myPolygon) {
			pt.setLocation(pt.getX(), pt.getY() + distance);
		}
	}
	
	public void move(int distX, int distY) {
		for(Point2D.Double pt : myPolygon) {
			pt.setLocation(pt.getX() + distX, pt.getY() + distY);
		}
	}
}
