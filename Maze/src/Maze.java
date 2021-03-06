import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/*

	Coded by:
	Modified on:

*/

public class Maze {

	private static final int rows = 12;
	private static final int cols = 12;
	private char[][] data;

	// Constructs an empty grid
	public Maze() {
		data = new char[cols][rows];
	}

	// Constructs the grid defined in the file specified
	public Maze(String filename) {
		data = readData(filename);
	}

	// Finds a path through the maze and modifies data to show the path
	public void findPath() {
		findPath(5,5);
	}

	// Private recursive version of findPath()
	private boolean findPath(int x, int y) {
		if(data[x][y] == '*' || data[x][y] == '!') {
			return false;
		} else if(x == 0 || y == 0 || x == data.length -1 || y == data[0].length -1) { // BASE
			data[x][y] = '!';
			return true;
		} else { // RECURSIVE
			
			data[x][y] = '!';
			
			if(findPath(x, y-1))
				return true;
			
			if(findPath(x-1, y))
				return true;
			if(findPath(x+1, y))
				return true;
			if(findPath(x, y+1))
				return true;
			
			data[x][y] = ' ';
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