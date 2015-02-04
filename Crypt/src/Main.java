
public class Main {
	
	public static void main(String[] args) {
		FileIO accessor = new FileIO();
		String data = accessor.readFile("u.item");
		accessor.writeFile("testcopy", data);
	}
}
