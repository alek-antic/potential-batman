
public class Pig implements Animal{

	private String myType, mySound;
	
	public Pig() {
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

}
