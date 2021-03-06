package fileio;

import java.util.ArrayList;

import javax.xml.parsers.*;

import schoolobjects.LivingThing;
import schoolobjects.animals.*;
import schoolobjects.people.*;

import org.w3c.dom.*;

import java.io.*;

public class XMLTranslator {

	private ArrayList<LivingThing> livers;
	
	public XMLTranslator() {
		livers = new ArrayList<LivingThing>();
	}

	public void readXML(String filename) {
		try {
			File xml = new File(filename);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document document = builder.parse(xml);

			document.getDocumentElement().normalize();

			NodeList persons = document.getElementsByTagName("Person");
			NodeList teacher = document.getElementsByTagName("Teacher");
			NodeList student = document.getElementsByTagName("Student");
			NodeList collegeStudent = document.getElementsByTagName("CollegeStudent");
			NodeList animal = document.getElementsByTagName("Animal");

			for (int i = 0; i < persons.getLength(); i++) {
				Node nNode = persons.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) nNode;

					String name = e.getElementsByTagName("name").item(0).getTextContent();
					int age = Integer.parseInt(e.getElementsByTagName("age").item(0).getTextContent());
					String gender = e.getElementsByTagName("gender").item(0).getTextContent();
					Person p = new Person(name, age, gender);
					livers.add(p);
				}
			}

			for (int i = 0; i < teacher.getLength(); i++) {
				Node nNode = teacher.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) nNode;

					String name = e.getElementsByTagName("name").item(0).getTextContent();
					int age = Integer.parseInt(e.getElementsByTagName("age").item(0).getTextContent());
					String gender = e.getElementsByTagName("gender").item(0).getTextContent();
					String subject = e.getElementsByTagName("subject").item(0).getTextContent();
					double salary = Double.parseDouble(e.getElementsByTagName("salary").item(0).getTextContent());
					Teacher p = new Teacher(name, age, gender,subject,salary);
					livers.add(p);
				}
			}
			
			for(int i = 0; i < student.getLength(); i++) {
				Node nNode = student.item(i);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element)nNode;
					
					String name = e.getElementsByTagName("name").item(0).getTextContent();
					int age = Integer.parseInt(e.getElementsByTagName("age").item(0).getTextContent());
					String gender = e.getElementsByTagName("gender").item(0).getTextContent();
					String ID = e.getElementsByTagName("ID").item(0).getTextContent();
					double GPA = Double.parseDouble(e.getElementsByTagName("GPA").item(0).getTextContent());
					Student p = new Student(name,age,gender,ID,GPA);
					livers.add(p);
				}
			}
			
			for(int i = 0; i < collegeStudent.getLength(); i++) {
				Node nNode = collegeStudent.item(i);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element)nNode;
					
					String name = e.getElementsByTagName("name").item(0).getTextContent();
					int age = Integer.parseInt(e.getElementsByTagName("age").item(0).getTextContent());
					String gender = e.getElementsByTagName("gender").item(0).getTextContent();
					String ID = e.getElementsByTagName("ID").item(0).getTextContent();
					double GPA = Double.parseDouble(e.getElementsByTagName("GPA").item(0).getTextContent());
					int year = Integer.parseInt(e.getElementsByTagName("year").item(0).getTextContent());
					String major = e.getElementsByTagName("major").item(0).getTextContent();
					CollegeStudent p = new CollegeStudent(name,age,gender,ID,GPA,year,major);
					livers.add(p);
				}
			}
			
			
			for(int i = 0; i < animal.getLength(); i++) {
				Node nNode = animal.item(i);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) nNode;
					
					String type = e.getElementsByTagName("type").item(0).getTextContent();
					
					if(type.equals("Cow"))
						livers.add(new Cow(e.getElementsByTagName("sound").item(0).getTextContent()));
					if(type.equals("Pig"))
						livers.add(new Pig(e.getElementsByTagName("sound").item(0).getTextContent()));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<LivingThing> getAlive() {
		return livers;
	}
}
