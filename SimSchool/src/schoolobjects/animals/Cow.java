package schoolobjects.animals;

import gpdraw.DrawingTool;
import schoolobjects.LivingThing;

public class Cow extends LivingThing implements Animal {
	private String myType;
	private String mySound;

	public Cow(String sound) {
		myType = "cow";
		mySound = sound;
	}

	public String getSound() {
		return mySound;
	}

	public String getType() {
		return myType;
	}

	public String toString() {
		return "The " + getType() + " goes " + getSound();
	}

	@Override
	public void draw(DrawingTool marker) {
		super.draw(marker);
		marker.drawOval(150, 250);
		marker.up();
		marker.move(getX() + 45, getY() + 50);
		marker.down();
		marker.fillOval(50, 50);
		marker.up();
		marker.move(getX() - 45, getY() - 32);
		marker.down();
		marker.fillOval(37, 40);
		marker.up();
		marker.move(getX(), getY() + 150);
		marker.down();
		marker.drawOval(100, 50);
		marker.up();
		marker.move(marker.getXPos(), marker.getYPos() - 12);
		marker.down();
		marker.drawOval(37, 12);
		marker.up();
		marker.move(marker.getXPos() + 20, marker.getYPos() + 20);
		marker.down();
		marker.drawCircle(7.5);
		marker.up();
		marker.move(marker.getXPos()-40, marker.getYPos());
		marker.down();
		marker.drawCircle(7.5);
		super.draw(marker);
	}

}
