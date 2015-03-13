package simschool.people;

import gpdraw.DrawingTool;

public class CollegeStudent extends Student {

	
	private String major;
	private int year;
	
	public CollegeStudent(String name, int age, String gender, String iDNum, double gpa, int year, String major) {
		super(name, age, gender, iDNum, gpa);
		this.major = major;
		this.year = year;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public String toString() {
		return super.toString() + ", year: " + year +  ", major: " + major;
	}
	
	@Override
	public void draw(DrawingTool marker, int x, int y) {
		super.draw(marker,x,y);
		
		marker.drawRect(25, 0);
		marker.up();
		marker.move(x-18,y);
		marker.down();
		marker.drawCircle(6);
		marker.up();
		marker.move(x+18,y);
		marker.down();
		marker.drawCircle(6);
		
		//reset
		marker.up();
		marker.move(x,y);
		marker.down();
	}
}