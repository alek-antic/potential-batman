import java.util.ArrayList;


public class IMDB {

	private static final String usersFile = "ml-100k/u.user";
	private static final String moviesFile = "ml-100k/u.item";

	// Add fields to represent your database.
	private ArrayList<User> users;
	private ArrayList<Movie> movies;
	private ArrayList<Rating> ratings;


	
	/**
	 * Use ratingsFile to read all data into some local structures.
	 * 
	 * @param ratingsFile The filename of the ratings database.
	 */
	public IMDB(String ratingsFile) {
		
		FileIO reader = new FileIO();
		String userData = reader.readFile(usersFile);
		String movieData = reader.readFile(moviesFile);
		String ratingsData = reader.readFile(ratingsFile);
		String[] userLineData = userData.split(reader.lineSeparator);
		String[] movieLineData = movieData.split(reader.lineSeparator);
		String[] ratingLineData = ratingsData.split(reader.lineSeparator);
		
		users = new ArrayList<User>();
		movies = new ArrayList<Movie>();
		ratings = new ArrayList<Rating>();
		
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
			Rating r = trans.lineToRating(s, users, movies);
			ratings.add(r);
		}
	}
	

	/**
	 * Returns an array of objects representing movie data.
	 * 
	 * @return An array of objects representing individual movies.
	 */
	public Object[] getMovieData() {
		Object movies[] = new Object[this.movies.size()];
		for(int i = 0; i < this.movies.size(); i++) {
			movies[i] = this.movies.get(i);
		}
		return movies;
	}
	

	/**
	 * Returns an array of objects representing user data.
	 * 
	 * @return An array of objects representing individual users.
	 */
	public Object[] getUserData() {
		Object users[] = new Object[this.users.size()];
		for(int i = 0; i < this.users.size(); i++) {
			users[i] = this.users.get(i);
		}
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
		
		if(user == null)
			return -1;
		
		ArrayList<Rating> ratings = user.getRatings();
		
		for(int i = 0; i < ratings.size(); i++) {
			if(ratings.get(i).getMovie().getId() == movieID)
			{
				return ratings.get(i).getStars();
			}
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
		double rating = 4;
		double averageMovieRating = 0;
		Movie movie = null;
		User user = null;
		boolean genreBonus = false;
		int favoriteGenre = 0;
		int[] movieGenre;
		
		
		for(Movie m : movies) {
			if(m.getId() == movieID)
				movie = m;
		}
		
		for(User u : users) {
			if(u.getId() == userID)
				user = u;
		}
		
		movieGenre = movie.getGenres();

		ArrayList<Rating> movieRatings = movie.getRatings();
		
		for(Rating r : movieRatings) {
			if(r.getUser().getId() == userID)
				return r.getStars();
		}
		
		
		//ALGORITHM BELOW
		
		favoriteGenre = user.getFavoriteGenre();
		/*
		int similarUserAverageRating = 0;
		int similarUsers = 0;
		for(User u : users) {
			int t = u.getFavoriteGenre();
			ArrayList<Rating> temp = u.getRatings();
			if(t == favoriteGenre){
				for(Rating r : temp) {
					if(r.getMovie().getId() == movieID) {
						similarUserAverageRating += r.getStars();
						similarUsers++;
					}
				}
			}
		}
		
		
		if(similarUsers != 0)
			similarUserAverageRating /= similarUsers;
		*/
		for(int i = 0; i < movieGenre.length; i ++) {
			if(movieGenre[i] == favoriteGenre)
				genreBonus = true;
		}
		
		for(Rating r : movieRatings) {
			averageMovieRating += r.getStars();
		}
		
		if(movieRatings.size() != 0)
			averageMovieRating /= movieRatings.size();
		
		if(genreBonus) {
			rating = averageMovieRating + averageMovieRating * 0.04;
		} else {
			rating = averageMovieRating;
		}
		
		return rating;
	}
	
}
