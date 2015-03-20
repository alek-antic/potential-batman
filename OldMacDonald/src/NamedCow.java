
public class NamedCow extends Cow {

	private String myName;
	
	public NamedCow(String name) {
		myName = name;
	}
	
	public String getName() {
		return myName;
	}
	
	@Override
	public String toString() {
		return getName() + " goes " + getSound();
	}
}
