package illusions;
import java.awt.Color;

import gpdraw.DrawingTool;
import shapes.*;

/**
 * @author Aleksandar Antic
 * @version 9/17/14
 */
public class WheelOfLines {

	private Line[] wheelLines, vertLines;
	
	/**
	 * 
	 * @param amt1 Double the number of lines in the circle of lines
	 * @param amt2 The amount of vertical lines in the illusion.
	 */
	public WheelOfLines() {
		wheelLines = new Line[40];
		vertLines = new Line[6];
		for(int i = 0; i < wheelLines.length; i++) {
			wheelLines[i] = new Line(0,0,9.0*i,250,5, new Color(128,128,128));
		}
		for(int i = 0; i < 80 * vertLines.length; i += 80) {
			vertLines[i/80] = new Line(-200 + i, 225, 270.0, 450, 10, new Color(175,175,175));
		}
	}
	
	
	public void draw(DrawingTool marker) {
		for(int i = 0; i < wheelLines.length; i++) {
			wheelLines[i].draw(marker);
		}
		for(int i = 0; i < vertLines.length; i++) {
			vertLines[i].draw(marker);
		}
	}
}
