package drawings;
import java.awt.Color;

import shapes.Rectangle;
import shapes.RegularPolygon;
import gpdraw.*;
public class ObjectBehaviorMain {

	public static void main(String[] args) {
		
		SketchPad pad = new SketchPad(600,600);
		DrawingTool marker = new DrawingTool(pad);
		RegularPolygon r = new RegularPolygon(0,0, 1, Color.BLACK, 5, 150);
		r.draw(marker);
		r.drawBoundingCircles(marker);
	}
}