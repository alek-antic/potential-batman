/*
  @(#)KochCurve.java


  @author
  @version
*/

import gpdraw.*;

public class KochCurve {

	private int level, length;

    public KochCurve(int level, int length) {
        this.level = level;
        this.length = length;
    }

    public void draw(DrawingTool marker) {
    	drawKochCurve(level, length, marker);
    }

    private void drawKochCurve(int level, int length, DrawingTool marker) {
		if(level < 1) {
			marker.forward(length);
		} else {
			drawKochCurve(level-1, length/3, marker);
			marker.turnLeft(60);
			drawKochCurve(level-1, length/3, marker);
			marker.turnRight(120);
			drawKochCurve(level-1, length/3, marker);
			marker.turnLeft(60);
			drawKochCurve(level-1, length/3, marker);
		}
    }
    
    public int getLength() {
    	return length;
    }

}
