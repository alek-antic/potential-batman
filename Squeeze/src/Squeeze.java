import java.io.*;
import java.util.*;

public class Squeeze {

	private String data;
	public Squeeze(String filename) {
		data = readData(filename);
	}
	
	public String readData(String filename) {
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
		
		return output;
	}
	
	public void squeeze() {
		String copy = "";
		int temp = 0;
		for(int i = data.indexOf('\n'); i != -1; i = data.indexOf('\n', i+1)) {
			int spaces = 0;
			int j = 0;
			for(j = temp + 1; j < i || data.charAt(j) != ' '; j++) {
				if(data.charAt(j) == ' ')
					spaces++;
			}
			System.out.println(j);
			copy += spaces + data.substring(temp+spaces, i) + "\n";
			temp = i;
		}
		data = copy;
	}
	
	public String toString() {
		return data;
	}
}
