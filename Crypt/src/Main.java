
public class Main {
	
	public static void main(String[] args) {
		Crypt crypt = new Crypt();
		crypt.encrypt("Romeo.txt", "results.txt", "crypt");
		crypt.generateKey("crypt");
		char[][] key = crypt.getKey();
		int[][] indecies = crypt.getIndecies();
		for(int i = 0; i <key.length; i++) {
			for(int j = 0; j < key[i].length; j++){
				System.out.print(key[i][j]);
			}
			System.out.println();
		}
		
		for(int y=0; y <indecies.length; y++) {
			for(int x = 0; x< indecies[y].length; x++) {
				System.out.print(indecies[y][x]);
			}
			System.out.println();
		}
		
	}
	
}