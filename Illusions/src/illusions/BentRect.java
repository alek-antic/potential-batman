package illusions;
import java.awt.Color;

import gpdraw.*;
import shapes.*;

public class BentRect {

	private Circle[] circles;
	private Rectangle square;
	
	public BentRect() {
		circles = new Circle[16];
		square = new Rectangle(0, 0, 500, 500, false, 5, new Color(0,0,0));
		for(int i = 0; i < circles.length; i ++) {
			circles[i] = new Circle(0,0, 65 + 15 * i, 5, new Color(128,128,128));
		}
	}
	
	public void draw(DrawingTool marker) {
		for(Circle i : circles) {
			i.draw(marker);
		}
		square.draw(marker);
	}
}
