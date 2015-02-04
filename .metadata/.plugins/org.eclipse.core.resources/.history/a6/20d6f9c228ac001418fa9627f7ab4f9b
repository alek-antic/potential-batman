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
	
	public int getId() {
		return uID;
	}
	
	public void addRating(Rating r) {
		ratings.add(r);
	}
	
	public ArrayList<Rating> getRatings() {
		return ratings;
	}
}
