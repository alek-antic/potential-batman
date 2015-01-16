package illusions;
import java.awt.Color;

import gpdraw.*;
import shapes.*;

public class LongShortLines {

	private Line[] diags, verts;
	
	public LongShortLines() {
		diags = new Line[11];
		verts = new Line[2];
		
		for(int i = 0; i < diags.length; i++) {
			diags[i] = new Line(-500, 60 - 12 * i, 15 - 3.0 * i, 5000, 5, new Color(0,0,0));
		}
		
		for(int i = 0; i < verts.length; i++) {
			verts[i] = new Line(-50 + 100* i, 200, 270.0, 400, 25, new Color(128,128,128));
		}
	}
	
	public void draw(DrawingTool marker) {
		for(Line i : diags) {
			i.draw(marker);
		}
		for(Line i : verts) {
			i.draw(marker);
		}
	}
}
