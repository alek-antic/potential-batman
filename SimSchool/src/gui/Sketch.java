package gui;

import java.util.ArrayList;

import schoolobjects.LivingThing;
import fileio.XMLTranslator;
import gpdraw.SketchPadPanel;

public class Sketch extends SketchPadPanel implements ControlListener {
	
	private ArrayList<LivingThing> drawings;
	
	public Sketch(String filename) {
		XMLTranslator trans = new XMLTranslator();
		trans.readXML(filename);
		drawings = trans.getAlive();
	}
	
	
	@Override
	public ArrayList<LivingThing> getDrawings() {
		return drawings;
	}

	
	@Override
	public void setSelected(LivingThing t) {
		
	}

}