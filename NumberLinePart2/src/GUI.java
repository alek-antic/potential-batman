import java.awt.BorderLayout;

import javax.swing.*;


public class GUI extends JFrame {
	
	
	private BorderLayout border;
	private Drawing numberLine;
	private BottomPanel bottomPanel;
	
	
	public GUI() {
		super("Number Line");
		border = new BorderLayout();
		setLayout(border);
		bottomPanel = new BottomPanel();
		numberLine = new Drawing();
		bottomPanel.addControlListener(numberLine);
		
		
		setBounds(100, 100, 640, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(numberLine, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
		setResizable(true);
	}
}
