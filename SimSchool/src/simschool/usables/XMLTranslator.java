package simschool.usables;

import java.util.ArrayList;
import javax.xml.parsers.*;
import simschool.people.*;
import org.w3c.dom.*;
import java.io.*;

public class XMLTranslator {

	private ArrayList<Person> people;
	private ArrayList<Teacher> teachers;
	private ArrayList<Student> students;
	private ArrayList<CollegeStudent> collegeStudents;
	
	public XMLTranslator() {
		people = new ArrayList<Person>();
		teachers = new ArrayList<Teacher>();
		students = new ArrayList<Student>();
		collegeStudents = new ArrayList<CollegeStudent>();
	}

	public void readXML(String filename) {
		try {
			File xml = new File(filename);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document document = builder.parse(xml);

			document.getDocumentElement().normalize();
			System.out.println(document.getDocumentElement().getNodeName());

			NodeList persons = document.getElementsByTagName("Person");
			NodeList teacher = document.getElementsByTagName("Teacher");
			NodeList student = document.getElementsByTagName("Student");
			NodeList collegeStudent = document.getElementsByTagName("CollegeStudent");

			for (int i = 0; i < persons.getLength(); i++) {
				Node nNode = persons.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) nNode;

					String name = e.getAttribute("name");
					int age = Integer.parseInt(e.getAttribute("age"));
					String gender = e.getAttribute("gender");
					Person p = new Person(name, age, gender);
					people.add(p);
				}
			}

			for (int i = 0; i < teacher.getLength(); i++) {
				Node nNode = teacher.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) nNode;

					String name = e.getAttribute("name");
					int age = Integer.parseInt(e.getAttribute("age"));
					String gender = e.getAttribute("gender");
					String subject = e.getAttribute("subject");
					double salary = Double.parseDouble(e.getAttribute("salary"));
					Teacher p = new Teacher(name, age, gender,subject,salary);
					teachers.add(p);
				}
			}
			
			for(int i = 0; i < student.getLength(); i++) {
				Node nNode = student.item(i);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element)nNode;
					
					String name = e.getAttribute("name");
					int age = Integer.parseInt(e.getAttribute("age"));
					String gender = e.getAttribute("gender");
					String ID = e.getAttribute("ID");
					double GPA = Double.parseDouble(e.getAttribute("GPA"));
					Student p = new Student(name,age,gender,ID,GPA);
					students.add(p);
				}
			}
			
			for(int i = 0; i < collegeStudent.getLength(); i++) {
				Node nNode = collegeStudent.item(i);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element)nNode;
					
					String name = e.getAttribute("name");
					int age = Integer.parseInt(e.getAttribute("age"));
					String gender = e.getAttribute("gender");
					String ID = e.getAttribute("ID");
					double GPA = Double.parseDouble(e.getAttribute("GPA"));
					int year = Integer.parseInt(e.getAttribute("year"));
					String major = e.getAttribute("major");
					CollegeStudent p = new CollegeStudent(name,age,gender,ID,GPA,year,major);
					collegeStudents.add(p);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Person> getPeople() {
		return people;
	}
	
	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}
	
	public ArrayList<CollegeStudent> getCollegeStudents() {
		return collegeStudents;
	}
}