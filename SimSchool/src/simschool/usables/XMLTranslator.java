package simschool.usables;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;

import simschool.people.Person;

public class XMLTranslator {

	private ArrayList<Person> people;
	private String fileData;
	
	public XMLTranslator(String filename) {
		fileData = FileIO.readFile(filename);
	}
	
	
	
	public void makePerson() {
		DocumentBuilderFactory bom = DocumentBuilderFactory.newInstance();
		
	}
	
}
