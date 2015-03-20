package schoolobjects.people;

import gpdraw.DrawingTool;
import schoolobjects.Drawable;
import schoolobjects.LivingThing;

/**
 * L.A.11.1
 *
 * The root of the Person hierarchy. All persons have a name and an age and a
 * gender
 */

public class Person extends LivingThing implements Drawable {
	private String myName; // name of the person
	private int myAge; // person's age
	private String myGender; // 'M' for male, 'F' for female

	// constructor
	public Person(String name, int age, String gender) {
		myName = name;
		myAge = age;
		myGender = gender;
	}

	public String getName() {
		return myName;
	}

	public int getAge() {
		return myAge;
	}

	public String getGender() {
		return myGender;
	}

	public void setName(String name) {
		myName = name;
	}

	public void setAge(int age) {
		myAge = age;
	}

	public void setGender(String gender) {
		myGender = gender;
	}

	public String toString() {
		return myName + ", age: " + myAge + ", gender: " + myGender;
	}


	@Override
	public void draw(DrawingTool marker, int x, int y) {
		//setup
		marker.up();
		marker.move(x,y);
		marker.down();
		
		marker.drawCircle(50);
		marker.up();
		marker.move(x,y-50);
		marker.down();
		marker.setDirection(225);
		marker.forward(66);
		marker.up();
		marker.backward(66);
		marker.down();
		marker.setDirection(-45);
		marker.forward(66);
		marker.up();
		marker.backward(66);
		marker.down();
		marker.setDirection(-90);
		marker.forward(100);
		marker.setDirection(-120);
		marker.forward(66);
		marker.backward(66);
		marker.setDirection(-60);
		marker.forward(66);
		
		//reset
		marker.up();
		marker.move(x,y);
		marker.down();
		
	}
}