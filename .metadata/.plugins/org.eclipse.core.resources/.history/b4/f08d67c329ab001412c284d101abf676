import java.util.ArrayList;


public class Rating {

	
	private User user;
	private Movie movie;
	private double stars;
	private long timestamp;
	
	public Rating(User u, Movie m, double s, long l) {
		user = u;
		movie = m;
		stars = s;
		timestamp = l;
		u.addRating(this);
	}
	
	public double getStars() {
		return stars;
	}
	
	public User getUser() {
		return user;
	}
	
	public Movie getMovie() {
		return movie;
	}
	
	public String toString() {
		return "User: " + user.getId() + " Movie: " + movie.getId() + " Rating: " + stars + " " + timestamp;
	}
}
