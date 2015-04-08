package gui;

import javax.swing.*;
import java.awt.*;

public class GUI extends JPanel {

	private Sketch sketch;
	private BottomPanel bp;
	
	public GUI(String filename) {
		super();
		sketch = new Sketch(filename);
		bp = new BottomPanel();
		setLayout(new BorderLayout());
		
		add(sketch, BorderLayout.CENTER);
		add(bp, BorderLayout.SOUTH);
	}
	
}
