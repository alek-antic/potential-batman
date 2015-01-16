package drawings;
import java.awt.Color;

import shapes.*;
import gpdraw.*;


public class SphereTester {

	SketchPad paper;
	DrawingTool marker;
	Shape shape;
	
	public SphereTester () {
		paper = new SketchPad(1000,1000);
		marker = new DrawingTool(paper);
		shape = new Sphere(150,150,150,100,50,0,150,150,150,new Color(0,0,0));
		shape.draw(marker);
		// ADD MORE TESTS HERE
	}


	public static void main (String[] args) {

		SphereTester runner = new SphereTester();

	}



}