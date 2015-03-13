package simschool.testers;

import simschool.people.CollegeStudent;
import gpdraw.*;
import simschool.people.Person;
import simschool.people.Student;
import simschool.people.Teacher;


public class SchoolTester {

	
	public static void main(String[] args) {
		Person bob = new Person("Coach Bob", 27, "M");
		System.out.println(bob);

		Student lynne = new Student("Lynne Brooke", 16, "F", "HS95129", 3.5);
		System.out.println(lynne);

		Teacher mrJava = new Teacher("Duke Java", 34, "M", "Computer Science", 50000);
		System.out.println(mrJava);

		CollegeStudent ima = new CollegeStudent("Ima Frosh", 18, "F", "UCB123",
		                                         4.0, 1, "English");
		System.out.println(ima);
		SketchPad pad = new SketchPad(500,500);
		DrawingTool marker = new DrawingTool(pad);
		ima.draw(marker, 0,0);

	}
}
