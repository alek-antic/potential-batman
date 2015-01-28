import java.io.*;
import java.util.Scanner;

public class FileIO {

	public String lineSeparator;
	
	public FileIO() {
		lineSeparator = System.getProperty("line.separator");
	}
	
	public String readFile(String filename) {
		
		FileReader reader;
		String fileData = null;
		Scanner in = null;
		try {
			
			reader = new FileReader(filename);
			in = new Scanner(reader);
			fileData = "";
			
			while(in.hasNextLine()) {
				String input = in.nextLine();
				fileData += input + lineSeparator;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(in != null)
				in.close();
		}
		
		return fileData;
	}
}
