import java.util.ArrayList;


public class User {

	private int uID, age;
	private boolean isMale;
	private String occupation, zipCode;
	private ArrayList<Rating> ratings = new ArrayList<Rating>();
	
	
	public User(int ID, int age, boolean isFemale, String occupation, String zipCode) {
		uID = ID;
		this.age = age;
		this.isMale = !isFemale;
		this.occupation = occupation;
		this.zipCode = zipCode;
	}
	
	public String toString() {
		String output = "";
		char c = ' ';
		if(isMale)
			c = 'M';
		else
			c = 'F';
		output += uID + " " + age + " " + c + " " + occupation + " " + zipCode;
		return output;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getId() {
		return uID;
	}
	
	public void addRating(Rating r) {
		ratings.add(r);
	}
	
	public ArrayList<Rating> getRatings() {
		return ratings;
	}
	
	public int getFavoriteGenre() {
		int[] genreCount = new int[19];
		int favoriteGenre = 0;
		
		ArrayList<Rating> userRatings = this.getRatings();
		
		for(int i = 0; i < userRatings.size(); i++) {
			int[] genre = userRatings.get(i).getMovie().getGenres();
			for(int j = 0; j < genre.length; j++) {
				genreCount[genre[j]]++;
			}
		}
		
		for(int i = 0; i < genreCount.length; i ++) {
			if(genreCount[i] > favoriteGenre)
				favoriteGenre = i;
		}
		return 0;
	}
}
