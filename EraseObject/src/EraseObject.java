import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/*

	Coded by:
	Modified on:

*/

public class EraseObject {

	private static final int rows = 20;
	private static final int cols = 20;
	private char[][] data;

	// Constructs an empty grid
	public EraseObject() {
		data = new char[cols][rows];
	}

	// Constructs the grid defined in the file specified
	public EraseObject(String filename) {
		data = readData(filename);
	}

	// Finds a path through the maze and modifies data to show the path
	public void eraseObject() {
		eraseObject(1,6);
	}

	// Private recursive version of findPath()
	private boolean eraseObject(int x, int y) {
		if(data[x][y] == ' ') {
			return false;
		} else if(x == 0 || y == 0 || x == data.length - 1 || y == data[0].length  - 1) { 
			return false;
		} else {
			
			data[x][y] = ' ';
			
			if(eraseObject(x, y-1))
				return true;
			if(eraseObject(x-1, y))
				return true;
			if(eraseObject(x+1, y))
				return true;
			if(eraseObject(x, y+1))
				return true;

			return false;
		}
	}

	// Formats this grid as a String to be printed (one call to this method returns the whole multi-line grid)
	public String toString() {
		String output = "";
		for(char[] c : data)
		{
			for(char d : c) {
				output += d;
			}
			output += '\n';
		}
		return output;
	}

	public char[][] readData (String filename) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			char[][] gameData = new char[rows][cols];

			int count = 0;

			FileReader reader = null;
			try {
					reader = new FileReader(dataFile);
					Scanner in = new Scanner(reader);


					while (in.hasNext() && count < rows) {
						String line = in.nextLine();
						for(int i = 0; i < line.length(); i++)
							gameData[count][i] = line.charAt(i);

						count++;
					}

			} catch (IOException ex) {
				System.out.println("File cannot be read.");
				return null;
			} catch (NumberFormatException ex) {
				System.out.println("File is in the wrong format.");
				return null;
			} finally {
				try {
					reader.close();
				} catch (IOException ex) {
					System.out.println("File cannot be closed.");
					return null;
				}
			}
			return gameData;
		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
    }

}