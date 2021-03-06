import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/*

	Coded by:
	Modified on:

*/

public class Labyrinth {

	private static final int rows = 20;
	private static final int cols = 20;
	private char[][] data;

	// Constructs an empty grid
	public Labyrinth() {
		data = new char[cols][rows];
	}

	// Constructs the grid defined in the file specified
	public Labyrinth(String filename) {
		data = readData(filename);
	}

	// Finds a path through the labyrinth and returns the number of moves required to exit
	public int findPath() {
		return findPath(findX('C'), findY('C'));
	}

	// Private recursive version of findPath()
	private int findPath(int x, int y) {
		int x1 = findX('X');
		int x2 = findX('C');
		int y1 = findY('X');
		int y2 = findY('C');
		if(!contains('C') || !contains('X')) {
			return -1;
		} else if((y2 == y1 +1 || y2 == y1 -1) && x2 == x1) {
			return 1;
		} else if((x2 == x1 +1 || x2 == x1 -1) && y2 == y1) {
			 return 1;
		} else {
			int moves = 0;
			moves++;
			moves+=findPath(x+1,y);
			moves+=findPath(x-1,y);
			moves+=findPath(x,y+1);
			moves+=findPath(x,y-1);
			moves --;
			return moves;
		}
	}


	private boolean contains(char c) {
		for(int y = 0; y < data.length; y++)
			for(int x = 0; x < data[y].length; x++)
				if(data[y][x] == c)
					return true;
		return false;
	}

	private int findX(char c) {
		for (int y = 0; y < data.length; y++)
			for(int x = 0; x < data[y].length; x ++)
				if(data[y][x] == c)
					return x;
		return -1;
	}
	
	private int findY(char c) {
		for (int y = 0; y < data.length; y++)
			for(int x = 0; x < data[y].length; x ++)
				if(data[y][x] == c)
					return y;
		return -1;
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