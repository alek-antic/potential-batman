package illusions;
import javax.swing.JOptionPane;

import gpdraw.*;
public class Tester {

	
	public static void main(String[] args) {
		String[] options = {
			"Wheel of Lines", "Long & Short Lines", "Bent Rectangle"	
		};
		SketchPad pad = new SketchPad(1000, 1000);
		DrawingTool marker = new DrawingTool(pad);

		int i = JOptionPane.showOptionDialog(pad, "Which illusion would you like to see?", 
				"Illusions", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, options, null);
		
		if(i == 0) {
			WheelOfLines r = new WheelOfLines();
			r.draw(marker);
		} else if(i == 1){
			LongShortLines s = new LongShortLines();
			s.draw(marker);
		} else if(i == 2) {
			BentRect t = new BentRect();
			t.draw(marker);
		} else {
			SlantedLines u = new SlantedLines();
			u.draw(marker);
		}
		
	}
}
