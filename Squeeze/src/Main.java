
public class Main {

	public static void main(String[] args) {
		FileIO f = new FileIO();
		String[] s = f.readFile("squeeze.txt").split(f.lineSeparator);
		Squeeze squeezer = new Squeeze();
		squeezer.squeeze(s);
		for(String x : s) {
			System.out.println(x);
		}
	}

}
