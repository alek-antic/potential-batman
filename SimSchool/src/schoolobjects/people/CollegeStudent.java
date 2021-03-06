package schoolobjects.people;

import gpdraw.DrawingTool;

public class CollegeStudent extends Student {

	private String major;
	private int year;

	public CollegeStudent(String name, int age, String gender, String iDNum,
			double gpa, int year, String major) {
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
		return super.toString() + ", year: " + year + ", major: " + major;
	}

	@Override
	public void draw(DrawingTool marker) {
		super.draw(marker);

		marker.up();
		marker.move(getX() - 25 * Math.sqrt(2), getY() + 25 * Math.sqrt(2));
		marker.down();
		marker.setDirection(90);
		marker.forward(25);
		marker.setDirection(0);
		marker.forward(70);
		marker.setDirection(-90);
		marker.forward(25);

		// reset
		super.draw(marker);
	}
}
