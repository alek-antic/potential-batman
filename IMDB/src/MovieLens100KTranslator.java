import java.util.ArrayList;


public class MovieLens100KTranslator {

	public User lineToUser(String line) {
		String sorted[] = line.split("\\|");
		int id = Integer.parseInt(sorted[0]);
		int age = Integer.parseInt(sorted[1]);
		boolean isFemale = sorted[2].charAt(0) == 'F';
		String occupation = sorted[3];
		String zip = sorted[4];
		
		return new User(id, age, isFemale, occupation, zip);
	}
	
	public Movie lineToMovie(String line) {
		String sorted[] = line.split("\\|");
		int id = Integer.parseInt(sorted[0]);
		String title = sorted[1];
		String rD = sorted[2];
		String vRD = sorted[3];
		String url = sorted[4];
		ArrayList<Integer> genres = new ArrayList<Integer>();
		for(int i = 5; i < sorted.length; i ++) {
			if(Integer.parseInt(sorted[i]) == 1)
				genres.add(i-5);
		}
		
		return new Movie(id, title, rD, vRD, url, genres);
	}
	
	public Rating lineToRating(String line, ArrayList<User> users, ArrayList<Movie> movies) {
		String sorted[] = line.split("\t");
		User u = null;
		Movie m = null;
		
		int uID = Integer.parseInt(sorted[0]);
		int mID = Integer.parseInt(sorted[1]);
		
		for(User user : users) {
			if(user.getId() == uID)
				u = user;
		}
		
		for(Movie movie : movies) {
			if(movie.getId() == mID) {
				m = movie;
			}
		}
		
		return new Rating(u,m, Double.parseDouble(sorted[2]), Long.parseLong(sorted[3]));
		
	}
	
}
