package gui;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import schoolobjects.LivingThing;
import fileio.XMLTranslator;
import gpdraw.SketchPadPanel;

public class Sketch extends SketchPadPanel implements ControlListener {
	
	private ArrayList<LivingThing> drawings;
	
	public Sketch(String filename) {
		super(0);
		XMLTranslator trans = new XMLTranslator();
		trans.readXML(filename);
		drawings = trans.getAlive();
		addKeyListener(new DataRetrival());
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int width = getWidth();
		int height = getHeight();
		
		g.setColor(new Color(153,0,0));
		
		for(LivingThing t : drawings) {
			if(t.getSelected()){
				double y = height/ 2.0  - t.getY();
				double x = width/2.0 + t.getX();
				g.drawRect((int)x - 25, (int) (y + 300), 50, 125);
				g.drawLine((int)(x-50), (int)(y+300), (int)x, (int)(y + 300 - 100/Math.sqrt(2)));
				g.drawLine((int)x, (int)(y + 300 - 100/Math.sqrt(2)), (int) (x+50), (int)(y+300));
				g.drawLine((int)(x-50), (int)(y+300), (int)(x+50), (int)(y+300));
				
			}
		}
		
	}
	@Override
	public ArrayList<LivingThing> getDrawings() {
		return drawings;
	}

	
	@Override
	public void setSelected(LivingThing t, boolean selected) {
		for(LivingThing thing : drawings)
			if(t.equals(thing))
				thing.setSelected(selected);
		repaint();
		grabFocus();
	}

	private class DataRetrival implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			LivingThing thing = null;
			for(LivingThing t : drawings)
				if(t.getSelected())
					thing = t;
			if(thing != null)
				if(key == KeyEvent.VK_ENTER)
					JOptionPane.showConfirmDialog(Sketch.this, thing.toString(), "Info", JOptionPane.OK_OPTION);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
