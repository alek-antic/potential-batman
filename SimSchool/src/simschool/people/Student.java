package simschool.people;

import gpdraw.DrawingTool;

/**
 * L.A.11.1
 *
 * A student, is a Person with an id number and a grade point average
 */

public class Student extends Person {
	private String myIdNum; // Student Id Number
	private double myGPA; // grade point average

	// constructor
	public Student(String name, int age, String gender, String idNum, double gpa) {
		// use the super class' constructor
		super(name, age, gender);

		// initialize what's new to Student
		myIdNum = idNum;
		myGPA = gpa;
	}

	public String getIdNum() {
		return myIdNum;
	}

	public double getGPA() {
		return myGPA;
	}

	public void setIdNum(String idNum) {
		myIdNum = idNum;
	}

	public void setGPA(double gpa) {
		myGPA = gpa;
	}

	public String toString() {
		return super.toString() + ", student id: " + myIdNum + ", gpa: "
				+ myGPA;
	}
	
	@Override
	public void draw(DrawingTool marker, int x, int y) {
		super.draw(marker,x,y);
		marker.up();
		marker.move(x,y-75);
		marker.down();
		marker.drawRect(37.5, 50);
		
		marker.up();
		marker.move(x,y);
		marker.down();
		
	}
}