import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

/**
 * 
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author Your Name
 * @version Date
 * 
 *          Period - Your Period Assignment - Name of Assignment Sources - List
 *          collaborators
 */
public class Drawing extends JPanel implements ControlListener {

	private Font f;
	private Shape shape;
	private int location;

	public Drawing() {
		super();
		setBackground(Color.WHITE);
		f = new Font("SansSerif", 0, 16);
		location = 50;
		shape = new Ellipse2D.Double();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Call JPanel's paintComponent method
									// to paint the background

		int width = getWidth();

		g.setColor(Color.CYAN);
		g.fillRect((int) (width / 10.0), 95, (int) (width * 8.0 / 10.0), 10);
		g.setColor(Color.BLACK);
		g.drawLine((int) (width / 10.0), 100, (int) (width * 9.0 / 10.0), 100);
		g.setFont(f);
		for (int i = 0; i <= 10; i++) {
			g.drawLine((int) (width / 10.0 + width * i * 2 / 25.0), 91,
					(int) (width / 10.0 + width * i * 2 / 25.0), 109);
			FontMetrics fm = g.getFontMetrics();
			int w = fm.stringWidth(i * 10 + "");
			g.drawString(i * 10 + "",
					(int) (width / 10.0 + width * i * 2 / 25 - w / 2), 70);
		}

		g.setColor(Color.RED);
		if (shape instanceof Ellipse2D.Double) {
			g.fillOval(
					(int) (width / 10.0 + location / 10.0 * width * 2 / 25) - 5,
					95, 10, 10);
		} else if (shape instanceof Rectangle) {
			g.fillRect(
					(int) (width / 10.0 + location / 10.0 * width * 2 / 25) - 5,
					95, 10, 10);
		} else if (shape instanceof Polygon) {
			int[] xpoints = { 
					(int) (width / 10.0 + location / 10.0 * width * 2 / 25) - 5,
					(int) (width / 10.0 + location / 10.0 * width * 2 / 25),
					(int) (width / 10.0 + location / 10.0 * width * 2 / 25) + 5
					};
			int[] ypoints = { 105, 95, 105 };
			g.fillPolygon(new Polygon(xpoints, ypoints, 3));
		}
	}

	@Override
	public void changeShape(Shape s) {
		shape = s;
		repaint();

	}

	@Override
	public void changeLocation(int loc) {
		location = loc;
		repaint();

	}

	@Override
	public void changeFontStyle(Font font) {
		f = font;
		repaint();
	}

}
