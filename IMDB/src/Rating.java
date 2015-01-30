import java.util.ArrayList;


public class Rating {

	
	private User user;
	private Movie movie;
	private double stars;
	
	public Rating(User u, Movie m, double s) {
		user = u;
		movie = m;
		stars = s;
		u.addRating(this);
	}
	
	public String toString() {
		return "User:" + user.getId() + " Movie: " + movie.getID() + " Rating: " + stars;
	}
}