import java.io.*;
import java.util.*;

/*

 Represents a Game Of Life grid.

 Coded by:
 Modified on:

 */

public class Life {

	private static final int rows = 20;
	private static final int cols = 20;
	private boolean[][] grid;

	// Constructs an empty grid
	public Life() {
		grid = new boolean[cols][rows];
	}

	// Constructs the grid defined in the file specified
	public Life(String filename) {
		grid = readData(filename);
	}

	// Runs a single turn of the Game Of Life
	public void step() {
		boolean[][] copy = copyOf(grid);

		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy[i].length; j++) {
				int aliveNeighbors = 0;
				
				if (i == 0 && j == 0) {
					if (copy[i][j+1])
						aliveNeighbors++;
					if (copy[i+1][j])
						aliveNeighbors++;
					if (copy[i+1][j+1])
						aliveNeighbors++;
				} else if (i == copy.length - 1 && j == copy[i].length - 1) {
					if (copy[i - 1][j])
						aliveNeighbors++;
					if (copy[i][j - 1])
						aliveNeighbors++;
					if (copy[i - 1][j - 1])
						aliveNeighbors++;
				} else if (i == 0 && j == copy[i].length - 1) {
					if (copy[i][j - 1])
						aliveNeighbors++;
					if (copy[i + 1][j])
						aliveNeighbors++;
					if (copy[i + 1][j - 1])
						aliveNeighbors++;
				} else if (i == copy.length - 1 && j == 0) {
					if (copy[i][j + 1])
						aliveNeighbors++;
					if (copy[i - 1][j])
						aliveNeighbors++;
					if (copy[i - 1][j + 1])
						aliveNeighbors++;
				} else if (i == 0) {
					if (copy[i][j + 1])
						aliveNeighbors++;
					if (copy[i + 1][j + 1])
						aliveNeighbors++;
					if (copy[i + 1][j])
						aliveNeighbors++;
					if (copy[i + 1][j - 1])
						aliveNeighbors++;
					if (copy[i][j - 1])
						aliveNeighbors++;
				} else if (i == copy.length - 1) {
					if (copy[i][j + 1])
						aliveNeighbors++;
					if (copy[i - 1][j + 1])
						aliveNeighbors++;
					if (copy[i - 1][j])
						aliveNeighbors++;
					if (copy[i - 1][j - 1])
						aliveNeighbors++;
					if (copy[i][j - 1])
						aliveNeighbors++;
				} else if (j == 0) {
					if (copy[i - 1][j])
						aliveNeighbors++;
					if (copy[i - 1][j + 1])
						aliveNeighbors++;
					if (copy[i][j + 1])
						aliveNeighbors++;
					if (copy[i + 1][j + 1])
						aliveNeighbors++;
					if (copy[i - 1][j])
						aliveNeighbors++;
				} else if (j == copy[i].length - 1) {
					if (copy[i - 1][j])
						aliveNeighbors++;
					if (copy[i - 1][j - 1])
						aliveNeighbors++;
					if (copy[i][j - 1])
						aliveNeighbors++;
					if (copy[i + 1][j - 1])
						aliveNeighbors++;
					if (copy[i - 1][j])
						aliveNeighbors++;
				} else {
					if (copy[i - 1][j - 1])
						aliveNeighbors++;
					if (copy[i][j + 1])
						aliveNeighbors++;
					if (copy[i + 1][j + 1])
						aliveNeighbors++;
					if (copy[i + 1][j])
						aliveNeighbors++;
					if (copy[i + 1][j - 1])
						aliveNeighbors++;
					if (copy[i - 1][j])
						aliveNeighbors++;
					if (copy[i - 1][j + 1])
						aliveNeighbors++;
					if (copy[i][j - 1])
						aliveNeighbors++;
				}

				if (copy[i][j]) {
					if (aliveNeighbors == 0 || aliveNeighbors == 1
							|| aliveNeighbors > 3)
						grid[i][j] = false;
					else 
						grid[i][j] = true;
				} else {
					if (aliveNeighbors == 3)
						grid[i][j] = true;
					else
						grid[i][j] = false;
				}
			}
		}
	}

	// Runs n turns of the Game Of Life
	public void step(int n) {
		boolean[][] copy = copyOf(grid);

		for (int i = 0; i < n; i++){
			step();
		}
	}

	// Formats this Life grid as a String to be printed (one call to this method
	// returns the whole multi-line grid)
	public String toString() {
		String output = "";
		for (boolean[] y : grid) {
			for (boolean x : y) {
				if (x)
					output += "*";
				else
					output += " ";
			}
			output += "\n";
		}

		return output;
	}

	public boolean[][] readData(String filename) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			boolean[][] gameData = new boolean[cols][rows];

			int count = 0;

			FileReader reader = null;
			try {
				reader = new FileReader(dataFile);
				Scanner in = new Scanner(reader);

				while (in.hasNext() && count < rows) {
					String line = in.nextLine();
					for (int i = 0; i < line.length(); i++)
						if (line.charAt(i) == '*')
							gameData[count][i] = true;

					count++;
				}

				in.close();
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
			throw new IllegalArgumentException("Data file " + filename
					+ " does not exist.");
		}
	}

	private boolean[][] copyOf(boolean[][] input) {
		boolean[][] copy = new boolean[cols][rows];
		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy[i].length; j++) {
				copy[i][j] = input[i][j];
			}
		}
		return copy;
	}

}