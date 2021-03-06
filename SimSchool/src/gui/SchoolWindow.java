package gui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import schoolobjects.LivingThing;
import gpdraw.*;

public class SchoolWindow extends SketchPad {
	
	
	private Sketch s;
	private BottomPanel bp;
	
	public SchoolWindow(int x, int y, Sketch s) {
		
		super(x,y,s);
		setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		
		this.s = s;
		bp = new BottomPanel(s);
		setLayout(new BorderLayout());
		
		add(s, BorderLayout.CENTER);
		add(bp, BorderLayout.SOUTH);
	
		
		remove(pad);
		
		setLayout(new BorderLayout());
		pad = s;
		add(pad, BorderLayout.CENTER);
		add(bp, BorderLayout.SOUTH);
		
		DrawingTool dt = new DrawingTool(this);
		ArrayList<LivingThing> drawings = s.getDrawings();
		int width = getWidth();
		for(int i = 0; i < drawings.size(); i++) {
			LivingThing lt = drawings.get(i);
			lt.setX(-width/3.0 + i*150);
			lt.draw(dt);
		}
	}
	
}
