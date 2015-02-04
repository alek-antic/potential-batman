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
	public ArrayList<Rating> ratings;
	
	
	public Movie(int ID, String title, String rD, String vRD, String URL, ArrayList<Integer> i) {
		mID = ID;
		this.title = title;
		releaseDate = rD;
		vidReleaseDate = vRD;
		this.URL = URL;
		indexes = i;
	}
	
	
	public String toString() {
		String output = "";
		String genre = "";
		for(int i = 0; i < indexes.size(); i++)
			genre += genres[indexes.get(i)];
		output += mID + " "+ title + " " + releaseDate + " " + vidReleaseDate + " " + URL + " " + genre;
		return output;
	}
	
	public void addRating(Rating r) {
		ratings.add(r);
	}
	
	public int getId() {
		return mID;
	}
}
