package drawings;
import java.awt.Color;

import shapes.Arrow;
import shapes.Line;
import gpdraw.*;

public class Muller {

	private Arrow a,b,c,d;
	private Line e, f;
	
	public Muller() {
		e = new Line(0, 0, 150, 0.0, 1, new Color(0,0,0));
		f = new Line(0, 150, 150, 150.0, 1, new Color(0,0,0));
		a = new Arrow(0, 0, true, 1, new Color(0,0,0), 50);
		b = new Arrow(150, 0, false, 1, new Color(0,0,0), 50);
		c = new Arrow(0, 150, false, 1, new Color(0,0,0), 50);
		d = new Arrow(150, 150, true, 1, new Color(0,0,0), 50);
	}
	
	public void draw(DrawingTool marker) {
		e.draw(marker);
		f.draw(marker);
		a.draw(marker);
		b.draw(marker);
		c.draw(marker);
		d.draw(marker);
	}
}
