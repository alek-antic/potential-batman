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
	
	public Movie() {
		mID = 0;
		title = "";
		releaseDate = "";
		vidReleaseDate = "";
		URL = "";
		indexes = null;
	}
	
	public Movie(int ID, String title, String rD, String vRD, String URL, int[] indecies) {
		mID = ID;
		this.title = title;
		releaseDate = rD;
		vidReleaseDate = vRD;
		this.URL = URL;
		for(int i = 0; i < indecies.length; i++)
			indexes.add(indecies[i]);
	}
	
	
	public String toString() {
		String output = "";
		String genre = "";
		for(int i = 0; i < indexes.size(); i++)
			genre += genres[indexes.get(i)];
		output += mID + " "+ title + " " + releaseDate + " " + vidReleaseDate + " " + URL + " " + genre;
		return output;
	}
}
