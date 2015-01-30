import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {

		FileIO reader = new FileIO();
		String userData = reader.readFile("ml-100k/u.user");
		String movieData = reader.readFile("ml-100k/u.item");
		String listData = reader.readFile("ml-100k/u.data");
		
		
		
		String[] userLineData = userData.split(reader.lineSeparator);
		String[] movieLineData = movieData.split(reader.lineSeparator);
		String[] ratingLineData = listData.split(reader.lineSeparator);
		
		ArrayList<User> users = new ArrayList<User>();
		ArrayList<Movie> movies = new ArrayList<Movie>();
		MovieLens100KTranslator trans = new MovieLens100KTranslator();
		
		for(String s : userLineData) {
			User u = trans.lineToUser(s);
			users.add(u);
		}
		
		for(String s : movieLineData) {
			Movie m = trans.lineToMovie(s);
			movies.add(m);
		}
		
		System.out.println(listData);
	}

}