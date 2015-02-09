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
		
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				key[i][j] = tempKey.charAt(0);
				if(isIFirst) {
					if(key[i][j] >= 'J') {
						indecies[key[i][j] - 66][0] = i;
						indecies[key[i][j] - 66][1] = j;
					} else {
						indecies[key[i][j] - 65][0] = i;
						indecies[key[i][j] - 65][1] = j;
					}
				} else {
					if(key[i][j] >= 'I') {
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

	public void encrypt(String inputFileName, String outputFileName, String keyword) {
		FileIO accessor = new FileIO();
		String data = accessor.readFile(inputFileName);
		StringBuffer story = new StringBuffer(data);
		for(int i = 0; i < story.length(); i++) {
			if(Character.isWhitespace(story.charAt(i)))
				story.deleteCharAt(i);
		}
		generateKey(keyword);
		String output ="";
		
		for(int i = 0; i < story.length(); i++) {
		char[] d = data.substring(2 * i, 2* i + 2).toCharArray();
		int x = indecies[Character.toUpperCase(d[0])- 65][1];
		int y = indecies[Character.toUpperCase(d[0])- 65][0];
		int x2 = indecies[Character.toUpperCase(d[1])- 65][1];
		int y2 = indecies[Character.toUpperCase(d[1])- 65][0];
		
		output += "" + key[y2][x] + "" + key[y][x2];
		}
		accessor.writeFile(outputFileName, output);
	}

	public void decrypt(String inputFileName, String outputFileName, String keyword) {
		encrypt(inputFileName, outputFileName, keyword);
	}
}
