import javax.swing.JOptionPane;

import gpdraw.*;


public class MainDraw {

	
	
	
	public static void main(String[] args)
	{
		SketchPad pad = new SketchPad(600,600);
		String[] options = {"House", "Benzene"};
		
		int i = JOptionPane.showOptionDialog(null, "What drawing would you like to see?", "Drawings",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if(i == 0) {
			House house = new House(pad);
			house.draw();
		} else {
			Benzene benzene = new Benzene(pad);
			benzene.draw();
		}

	}
	
}
