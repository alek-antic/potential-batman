package schoolobjects.animals;

import java.awt.Color;

import schoolobjects.LivingThing;
import gpdraw.*;


public class Pig extends LivingThing implements Animal{

	private String myType, mySound;
	
	public Pig(String sound) {
		myType = "pig";
		mySound = "oink";
	}
	
	@Override
	public String getSound() {
		
		return mySound;
	}

	@Override
	public String getType() {
		return myType;
	}
	
	public String toString() {
		return "The " + getType() + " goes " + getSound();
	}

	
	@Override
	public void draw(DrawingTool marker) {
		super.draw(marker);
		marker.setColor(new Color(255,125,125));
		marker.fillOval(100, 50);
		marker.up();
		marker.setDirection(150);
		marker.move(50);
		marker.down();
		marker.fillCircle(25);
		marker.up();
		marker.setDirection(245);
		marker.move(12.5);
		marker.down();
		marker.setColor(Color.BLACK);
		marker.drawOval(25, 12.5);
		marker.up();
		marker.setDirection(235+180);
		marker.move(25);
		marker.down();
		marker.drawCircle(5);
		marker.setDirection(180);
		marker.up();
		marker.move(25);
		marker.down();
		marker.drawCircle(5);
		marker.up();
		marker.move(-15);
		marker.setDirection(90);
		marker.move(10);
		marker.setColor(new Color(255,125,125));
		marker.down();
		marker.fillRect(35, 5);
		marker.up();
		marker.move(getX()+37.5,getY()-25);
		marker.down();
		marker.setColor(new Color(255,125,125));
		marker.fillRect(12.5,25);
		marker.up();
		marker.setDirection(180);
		marker.move(25);
		marker.down();
		marker.fillRect(12.5,25);
		marker.up();
		marker.setDirection(180);
		marker.move(25);
		marker.down();
		marker.fillRect(12.5,25);
		marker.up();
		marker.setDirection(180);
		marker.move(25);
		marker.down();
		marker.fillRect(12.5,25);
		marker.up();
		marker.setDirection(180);
		marker.move(25);
		marker.down();
		
	}
}
