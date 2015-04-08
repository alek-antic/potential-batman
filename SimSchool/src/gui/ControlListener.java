package gui;

import java.util.ArrayList;

import schoolobjects.LivingThing;

public interface ControlListener {

	public ArrayList<LivingThing> getDrawings();
	public void setSelected(LivingThing t);
	
}
