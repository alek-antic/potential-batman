
public class Main {
	
	public static void main(String[] args) {
		Life runner = new Life("life100.txt");
		runner.step(5);
		System.out.println(runner);
	}
}
