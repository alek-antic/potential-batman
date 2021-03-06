import java.io.*;
import java.util.Scanner;

public class FileIO {

	public String lineSeparator;
	
	public FileIO() {
		lineSeparator = System.getProperty("line.separator");
	}
	
	public String readFile(String filename) {
		
		BufferedReader breader = null;
		FileReader reader = null;
		String fileData = null;
		Scanner in = null;
		try {
			
			reader = new FileReader(filename);
			breader = new BufferedReader(reader);
			in = new Scanner(breader);
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
		
		BufferedWriter bwriter = null;
		FileWriter writer = null;
		
		try {
			
			writer = new FileWriter(filename);
			bwriter = new BufferedWriter(writer);
			bwriter.write(data);
			
			bwriter.flush();
			
			
		} catch (FileNotFoundException ex) {
			
			
			
		} catch (IOException ex) {
			
			ex.printStackTrace();
			
		} finally {
			if(bwriter != null) { 
				try {
					bwriter.close();
				} catch (IOException ex) {
					System.out.println("Make like a hockey team"
							+ " and get the puck outta here");
					ex.printStackTrace();
				}
			}
		}
		
	}
	



	public Object readObject(String filename) {
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		Object out = null;
		
		try {
			
			fis = new FileInputStream(filename);
			ois = new ObjectInputStream(fis);
			
			
			out = ois.readObject();
			
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			if(ois != null) { 
				try {
					ois.close();
				} catch (IOException ex) {
					System.out.println("Make like a hockey team"
							+ " and get the puck outta here");
					ex.printStackTrace();
				}
			}
		}
		
		return out;
	}
	
	
	
	public void writeObject(String filename, Object data) {
		
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		
		try {
			
			fos = new FileOutputStream(filename);
			oos = new ObjectOutputStream(fos);
			
			
			
			oos.writeObject(data);
			
			oos.flush();
			
			
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if(oos != null) { 
				try {
					oos.close();
				} catch (IOException ex) {
					System.out.println("Make like a hockey team"
							+ " and get the puck outta here");
					ex.printStackTrace();
				}
			}
		}
	}
	
}
