import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

public class Crypt {

	public static final String keyword = "crypt";
	private char[][] key = new char[5][5];
	private int[][] indecies = new int[25][2];
	private boolean isIFirst;

	public void generateKey(String keyword) {

		isIFirst = keyword.indexOf('I') <= keyword.indexOf('J');
		keyword = keyword.toUpperCase();
		if (isIFirst) {
			keyword = keyword.replaceAll("J", "I");
		} else {
			keyword = keyword.replaceAll("I", "J");
		}

		StringBuffer tempKey = new StringBuffer(keyword);
		int[] chars = new int[26];

		for (int i = 0; i < tempKey.length(); i++) {
			int k = Character.toUpperCase(tempKey.charAt(i)) - 65;
			if (chars[k] == 0) {
				chars[k]++;
			} else {
				tempKey.deleteCharAt(i);
			}
		}

		for (int i = 0; i < 26; i++) {
			if (chars[i] == 0) {
				tempKey.append((char) (i + 65));
			}
		}
		String temp = tempKey.toString();
		isIFirst = temp.indexOf('I') <= temp.indexOf('J');
		if (isIFirst) {
			temp = temp.replaceAll("J", "");
		} else {
			temp = temp.replaceAll("I", "");
		}

		tempKey = new StringBuffer(temp);

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				key[i][j] = tempKey.charAt(0);
				if (isIFirst) {
					if (key[i][j] >= 'J') {
						indecies[key[i][j] - 66][0] = i;
						indecies[key[i][j] - 66][1] = j;
					} else {
						indecies[key[i][j] - 65][0] = i;
						indecies[key[i][j] - 65][1] = j;
					}
				} else {
					if (key[i][j] >= 'I') {
						indecies[key[i][j] - 66][0] = i;
						indecies[key[i][j] - 66][1] = j;
					} else {
						indecies[key[i][j] - 65][0] = i;
						indecies[key[i][j] - 65][1] = j;
					}
				}
				tempKey.deleteCharAt(0);
			}
		}
	}

	public char[][] getKey() {
		return key;
	}

	public int[][] getIndecies() {
		return indecies;
	}

	public void encrypt(String inputFileName, String outputFileName,
			String keyword) {

		String lineSeparator = System.getProperty("line.separator");

		BufferedReader breader = null;
		FileReader reader = null;
		Scanner in = null;
		BufferedWriter bwriter = null;
		FileWriter writer = null;
		generateKey(keyword);

		try {

			reader = new FileReader(inputFileName);
			breader = new BufferedReader(reader);
			in = new Scanner(breader);

			writer = new FileWriter(outputFileName);
			bwriter = new BufferedWriter(writer);

			StringBuffer leftoverChar = new StringBuffer();
			StringBuffer changingFileData = new StringBuffer();
			
			while (in.hasNextLine()) {
				String input = in.nextLine();
				changingFileData.append(leftoverChar);
				changingFileData.append(input);
				changingFileData.append(lineSeparator);
				
				StringBuffer cache1

				while(changingFileData.length() > 0) {
					
				}

				changingFileData.delete(0, changingFileData.length());
				
				bwriter.write(0);
			}

			bwriter.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (in != null)
				in.close();
			if (bwriter != null) {
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

	public void decrypt(String inputFileName, String outputFileName,
			String keyword) {
		encrypt(inputFileName, outputFileName, keyword);
	}
}
