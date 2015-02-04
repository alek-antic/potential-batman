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
			
			StringBuffer changingFileData = new StringBuffer();
			
			while(in.hasNextLine()) {
				String input = in.nextLine();
				changingFileData.append(input);
				changingFileData.append(lineSeparator);
			}
			
			fileData = changingFileData.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(in != null)
				in.close();
		}
		
		return fileData;
	}
	
public void writeFile(String filename, String data) {
		
		FileWriter writer = null;
		
		try {
			
			writer = new FileWriter(filename);
			writer.write(data);
			
			
		} catch (FileNotFoundException ex) {
			
			
			
		} catch (IOException ex) {
			
			ex.printStackTrace();
			
		} finally {
			if(writer != null) { 
				try {
					writer.close();
				} catch (IOException ex) {
					System.out.println("Make like a hockey team"
							+ " and get the puck outta here");
					ex.printStackTrace();
				}
			}
		}
		
	}
	
	
}
