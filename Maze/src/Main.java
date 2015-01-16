
public abstract class Main {

	public static void main(String[] args) {
		Maze runner = new Maze("mazeData.txt");
		runner.findPath();
		System.out.println(runner);
	}

}
