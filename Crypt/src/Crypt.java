
public class Crypt {

	
	public static final String keyword = "crypt";
	private char[][] key = new char[5][5];
	private int[][] indecies = new int[26][2];
	
	public void encrypt(String inputFileName, String outputFileName, String keyword) {
		FileIO accessor = new FileIO();
		String data = accessor.readFile(inputFileName);
		
		StringBuffer tempKey = new StringBuffer(keyword);
		int[] chars = new int[25];
		
		for(int i = 0; i < chars.length; i ++) {
			int k = Character.toUpperCase(tempKey.charAt(i)) - 65;
			
			if((chars[8] != 0 && k == 10) || (chars[9] != -0 && k == 9)) {
				tempKey.deleteCharAt(i);
			} else if(chars[k] == 0) {
				chars[k]++;
			} else {
				tempKey.deleteCharAt(i);
			}
		}
		
		for(int i = 0; i < 26; i++) {
			if(chars[i] == 0) {
				tempKey.append((char)(i+65));
			}
		}
		
		
		
		accessor.writeFile(outputFileName, data);
	}
	
	public void decrypt(String inputFileName, String outputFileName, String keyword) {
		FileIO accessor = new FileIO();
		String data = accessor.readFile(inputFileName);
		
		
		accessor.writeFile(outputFileName, data);
	}
}
