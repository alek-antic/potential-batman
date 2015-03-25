import java.awt.*;

import javax.swing.*;


public class BottomPanel extends JPanel {

	private JRadioButton circle, square, triangle;
	private JSlider slider;
	private JCheckBox bold, italic, underline;
	
	public BottomPanel () {
		setLayout(new BorderLayout(50,0));
		
		circle = new JRadioButton("Circle", true);
		square = new JRadioButton("Square");
		triangle = new JRadioButton("Triangle");
		
		ButtonGroup radioButtons = new ButtonGroup();
		radioButtons.add(circle);
		radioButtons.add(square);
		radioButtons.add(triangle);
		
		
		slider = new JSlider(0,100);
		
		bold = new JCheckBox("Bold");
		italic = new JCheckBox("Italic");
		underline = new JCheckBox("Underline");
		
		ButtonGroup checkBoxes = new ButtonGroup();
		
		checkBoxes.add(bold);
		checkBoxes.add(italic);
		checkBoxes.add(underline);
		
		add(circle, BorderLayout.SOUTH);
		
		
		
	}
	
}
