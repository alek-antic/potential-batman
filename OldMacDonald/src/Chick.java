
public class Chick implements Animal{

	private String myType, mySound1, mySound2;
	private boolean makes2Sounds;
	
	public Chick() {
		myType= "chick";
		mySound1 = "cheep";
		mySound2 = "cluck";
	}
	
	public Chick(boolean twoSounds) {
		myType= "chick";
		mySound1 = "cheep";
		mySound2 = "cluck";
		makes2Sounds = twoSounds;
	}
	
	@Override
	public String getSound() {
		if(makes2Sounds) 
			if(Math.random() < 0.5)
				return mySound1;
			else 
				return mySound2;
		else 
			return mySound1;
		
	}

	@Override
	public String getType() {
		return myType;
	}
	
	public String toString() {
		return "The " + getType() + " goes " + getSound();
	}

}
