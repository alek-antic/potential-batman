package schoolobjects.people;

import gpdraw.DrawingTool;

public class Teacher extends Person {

	private String subject;
	private double salary;

	public Teacher(String name, int age, String gender, String subject,
			double salary) {
		super(name, age, gender);
		this.subject = subject;
		this.salary = salary;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getSubject() {
		return subject;
	}

	public double getSalary() {
		return salary;
	}

	public String toString() {
		return super.toString() + ", subject: " + subject + ", salary: "
				+ salary;
	}

	@Override
	public void draw(DrawingTool marker) {
		super.draw(marker);

		marker.drawRect(25, 0);
		marker.up();
		marker.move(getX() - 18, getY());
		marker.down();
		marker.drawCircle(6);
		marker.up();
		marker.move(getX() + 18, getY());
		marker.down();
		marker.drawCircle(6);

		// reset
		super.draw(marker);
	}
}
