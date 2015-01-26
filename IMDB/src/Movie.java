import java.util.ArrayList;


public class Movie {

	private int mID;
	private String title, releaseDate, vidReleaseDate, URL;
	public final String genres[] = {
			"unknown", "Action", "Adventure", "Animation",
            "Children\'s", "Comedy", "Crime", "Documentary", "Drama", "Fantasy",
            "Film-Noir", "Horror", "Musical", "Mystery", "Romance", "Sci-Fi",
            "Thriller", "War", "Western"
	};
	public ArrayList<Integer> indexes;
}
