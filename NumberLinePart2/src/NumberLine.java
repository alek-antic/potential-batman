import java.awt.*;

import javax.swing.*;

/**
 * TODO Write a one-sentence summary of your class here. Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author Your Name
 * @version Date
 * 
 *          Period - Your Period 
 *          Assignment - Name of Assignment
 *          Sources - List collaborators
 */
public class NumberLine extends JPanel {
	// TODO Your Instance Variables Here
	
	
	private BorderLayout border;
	

	public NumberLine() {
		super();
		setBackground(Color.WHITE);
		// TODO Add GUI customizations to the panel
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Call JPanel's paintComponent method
									// to paint the background

		int width = getWidth();
		int height = getHeight();
		
		g.setColor(Color.CYAN);
		g.fillRect((int)(width/12.0), 95, (int)(width*10.0/12.0), 10);
		g.setColor(Color.BLACK);
		g.drawLine((int)(width/12.0), 100, (int)(width*11.0/12), 100);
		g.setFont(new Font("Sans Serif", Font.BOLD, 17));
		for(int i = 0; i <=10; i++) {
			g.drawLine((int)(width/12.0 + width*i/12.0), 91, (int)(width/12.0 + width*i/12.0), 109);
			g.drawString(i * 10 + "", (int)(width/12.0 + width*i/12.0 - 10), 70);
		}
		
		
		

		// TODO Draw on the panel here
	}

}
