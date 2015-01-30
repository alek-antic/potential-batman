import java.util.ArrayList;


public class IMDB {

	private static final String usersFile = "ml-100k/u.user";
	private static final String moviesFile = "ml-100k/u.item";

	// Add fields to represent your database.
	private static ArrayList<User> users;
	private static ArrayList<Movie> movies;
	private static ArrayList<Rating> rating;


	
	/**
	 * Use ratingsFile to read all data into some local structures.
	 * 
	 * @param ratingsFile The filename of the ratings database.
	 */
	public IMDB(String ratingsFile) {
		
		FileIO reader = new FileIO();
		String userData = reader.readFile(usersFile);
		String movieData = reader.readFile(moviesFile);
		String listData = reader.readFile(ratingsFile);
		
		String[] userLineData = userData.split(reader.lineSeparator);
		String[] movieLineData = movieData.split(reader.lineSeparator);
		String[] ratingLineData = listData.split(reader.lineSeparator);
		
		ArrayList<User> users = new ArrayList<User>();
		ArrayList<Movie> movies = new ArrayList<Movie>();
		ArrayList<Rating> ratings = new ArrayList<Rating>();
		MovieLens100KTranslator trans = new MovieLens100KTranslator();
		
		for(String s : userLineData) {
			User u = trans.lineToUser(s);
			users.add(u);
		}
		
		for(String s : movieLineData) {
			Movie m = trans.lineToMovie(s);
			movies.add(m);
		}
		
		for(String s : ratingLineData) {
			Rating m = trans.lineToRating(s, users, movies);
			ratings.add(m);
		}
	}
	

	/**
	 * Returns an array of objects representing movie data.
	 * 
	 * @return An array of objects representing individual movies.
	 */
	public ArrayList<Movie> getMovieData() {
		return movies;
	}
	

	/**
	 * Returns an array of objects representing user data.
	 * 
	 * @return An array of objects representing individual users.
	 */
	public ArrayList<User> getUserData() {
		return users;
	}

	
	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, return -1.
	 * 
	 * @param userNumber The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or -1 if the user does not exist in the database, the movie does not exist, or the movie has not been rated by this user.
	 */
	public double getRating(int userID, int movieID) {
		User user = null;
		for(User u : users) {
			if(u.getId() == userID) {
				user = u;
			}
		}
		
		ArrayList<Rating> ratings = user.getRatings();
		for(int i = 0; i < user.getRatings().size(); i++) {
			
		}
		
		return -1;
	}
	
	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, use other available data to guess what this user would rate the movie.
	 * 
	 * @param userNumber The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or the best guess if the movie has not been rated by this user.
	 * @pre A user with id userID and a movie with id movieID exist in the database.
	 */
	public double guessRating(long userID, long movieID) {

		return 0;
	}
	
}