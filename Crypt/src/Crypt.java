import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Crypt {

	public static final String keyword = "crypt";
	private char[][] key = new char[5][5];
	private int[][] indecies = new int[26][2];

	private void generateKey(String keyword) {

		char[] noJKey = keyword.toUpperCase().toCharArray();
		StringBuffer tempKey = new StringBuffer();
		int[] chars = new int[26];

		for (char c : noJKey) {
			if (c == 'J')
				c--;
			tempKey.append(c);
		}

		int tempKeyLen = tempKey.length();
		for (int i = 0; i < tempKeyLen; i++) {
			int k = Character.toUpperCase(tempKey.charAt(i)) - 65;
			if (chars[k] == 0) {
				chars[k]++;
			} else {
				tempKey.deleteCharAt(i);
			}
		}

		for (int i = 0; i < 26; i++) {
			if (i == 'J' - 65)
				continue;
			if (chars[i] == 0) {
				tempKey.append((char) (i + 65));
			}
		}
		
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5; x++) {
				key[y][x] = tempKey.charAt(0);

				indecies[key[y][x] - 65][0] = x;
				indecies[key[y][x] - 65][1] = y;

				tempKey.deleteCharAt(0);
			}
		}
	}

	

	public void encrypt(String inputFileName, String outputFileName,
			String keyword) {

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
			in.useDelimiter("");

			writer = new FileWriter(outputFileName);
			bwriter = new BufferedWriter(writer);

			char one = 0;
			boolean oneUpper = false;
			char two = 0;
			boolean twoUpper = false;
			int counter = 0;
			StringBuffer cache1 = new StringBuffer();
			StringBuffer cache2 = new StringBuffer();

			while (in.hasNext()) {
				char input = in.next().charAt(0);

				StringBuffer digraph = new StringBuffer();

				// if char read is j, make it i
				if (input == 'j' || input == 'J') {
					input--;
				}

				// decide which char to fill
				if (counter % 2 == 0) {
					if (Character.isLetter(input)) {
						one = input;
						oneUpper = Character.isUpperCase(one);
						counter++;
						continue;
					} else {
						cache1.append(input);
						continue;
					}
				} else {
					if (Character.isLetter(input)) {
						two = input;
						twoUpper = Character.isUpperCase(two);
						counter++;

						// Encrypt stuff

						int[] index1 = indecies[Character.toUpperCase(one) - 65];
						int[] index2 = indecies[Character.toUpperCase(two) - 65];

						char newOne = 0;
						char newTwo = 0;

						// checks same column or row
						if (index1[0] == index2[0] || index1[1] == index2[1]) {
							newOne = Character.toUpperCase(two);
							newTwo = Character.toUpperCase(one);
						} else {
							newOne = key[index1[1]][index2[0]];
							newTwo = key[index2[1]][index1[0]];
						}

						// make lowercase if it should be

						if (!oneUpper)
							newOne += 32;
						if (!twoUpper)
							newTwo += 32;

						// link together
						digraph.append(cache1).append(newOne).append(cache2)
								.append(newTwo);

						// Reset chars and caches
						one = 0;
						two = 0;
						oneUpper = false;
						twoUpper = false;
						cache1.delete(0, cache1.length());
						cache2.delete(0, cache2.length());

					} else {
						cache2.append(input);
						continue;
					}
				}

				bwriter.write(digraph.toString());
				counter = 0;
			}
			bwriter.write(cache1.toString());

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
