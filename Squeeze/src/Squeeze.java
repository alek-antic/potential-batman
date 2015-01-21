import java.io.*;
import java.util.*;

public class Squeeze {

	private String[] data;
	public Squeeze(String filename) {
		data = readData(filename);
	}
	
	public String[] readData(String filename) {
		FileReader reader;
		String output = "";
		
		try {
			reader = new FileReader(filename);
			Scanner in = new Scanner(reader);
			in.useDelimiter("");
			while(in.hasNext()) {
				output += in.next();
			}
		} catch (IOException e) {
			System.out.println("Error reading file!");
		}
		
		return output.split("\n");
	}
	
	public void squeeze() {
		for(int j = 0; j < data.length; j++){
			int spaces = 0;
			for(int i = 0; i < data[j].length() - 1 && Character.isWhitespace(data[j].charAt(i)); i++) {
				if(Character.isWhitespace(data[j].charAt(i))) {
					spaces++;
				}
			}
			data[j] = spaces + data[j].substring(spaces);
		}
	}
	
	public String toString() {
		String output = "";
		
		for(String s : data) {
			output += s + '\n';
		}
		return output;
	}
}
