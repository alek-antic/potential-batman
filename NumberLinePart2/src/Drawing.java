import java.awt.*;

import javax.swing.*;

/**
 * 
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
public class Drawing extends JPanel {
	
	private BottomPanel panel;
	

	public Drawing(BottomPanel panel) {
		super();
		setBackground(Color.WHITE);
		this.panel = panel;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Call JPanel's paintComponent method
									// to paint the background

		int width = getWidth();
		
		
		g.setColor(Color.CYAN);
		g.fillRect((int)(width/12.0), 95, (int)(width*10.0/12.0), 10);
		g.setColor(Color.BLACK);
		g.drawLine((int)(width/12.0), 100, (int)(width*11.0/12), 100);
		g.setFont(new Font("SansSerif", Font.BOLD, 17));
		for(int i = 0; i <=10; i++) {
			g.drawLine((int)(width/12.0 + width*i/12.0), 91, (int)(width/12.0 + width*i/12.0), 109);
			FontMetrics fm = g.getFontMetrics();
			int w = fm.stringWidth(i*10+"");
			g.drawString(i * 10 + "", (int)(width/12.0 + width*i/12.0 - w/2), 70);
			
			
		}
	}

}
