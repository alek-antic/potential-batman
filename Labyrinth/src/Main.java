
public class Main {

	public static void main(String[] args) {
		Labyrinth runner = new Labyrinth("test3.txt");
		int x = runner.findPath();
		System.out.println(runner);
		System.out.println(x);
	}

}
