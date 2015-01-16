package illusions;
import java.awt.Color;

import shapes.*;
import gpdraw.*;

public class SlantedLines {

	private Rectangle[][] row;
	
	public SlantedLines() {
		row = new Rectangle[11][9];
		
		for(int i = 0; i < row[0].length; i++) {
			for(int j = 0; i< row[i].length; i++) {
				if(j % 2 == 0){
					if(i % 2 ==0)
						row[j][i] = new Rectangle(-265, 450 - 100 * i, 50, 50, true, 1, new Color(0,0,0));
					else if (i == 1 || i == 5)
						row[j][i] = new Rectangle(-275, 450 - 100 * i, 50, 50, true, 1, new Color(0,0,0));
					else 
						row[j][i] = new Rectangle(-260, 450 - 100 * i, 50, 50, true, 1, new Color(0,0,0));
				} else {
					if(i % 2 ==0)
						row[j][i] = new Rectangle(-265, 450 - 100 * i, 50, 50, false, 1, new Color(0,0,0));
					else if (i == 1 || i == 5)
						row[j][i] = new Rectangle(-275, 450 - 100 * i, 50, 50, false, 1, new Color(0,0,0));
					else 
						row[j][i] = new Rectangle(-260, 450 - 100 * i, 50, 50, false, 1, new Color(0,0,0));
				}
			}
		}
	}
	
	public void draw(DrawingTool marker) {
		for(int i = 0; i < row[0].length; i++) {
			for(int j = 0; j < row[1].length; j++) {
				row[j][i].draw(marker);
			}
		}
	}
}
