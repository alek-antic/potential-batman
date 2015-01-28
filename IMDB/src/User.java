
public class User {

	private int uID, age;
	private boolean isMale;
	private String occupation, zipCode;
	
	
	public User(int ID, int age, boolean isFemale, String occupation, String zipCode) {
		uID = ID;
		this.age = age;
		this.isMale = !isFemale;
		this.occupation = occupation;
		this.zipCode = zipCode;
	}
	
	public String toString() {
		String output = "";
		output += uID + " " + age + " " + isMale + " " + occupation + " " + zipCode;
		return output;
	}
}
