import java.util.ArrayList;

public class Farm {
	private ArrayList<Animal> myFarm = new ArrayList<Animal>();

	public Farm() {
		myFarm.add(new Cow());
		myFarm.add(new Chick());
		myFarm.add(new Pig());
	}

	// This method prints out the result of each animal's toString() method to
	// the command
	// line window.
	public void printAnimalSounds() {
		for (Animal a : myFarm) {
			System.out.println(a);
		}

	}

	// This method prints out the lyrics to OldMacDonald, including all animals
	// in the farm.
	public void printOldMacDonaldSong() {

		String out = "";
		for (Animal a : myFarm) {
			String name = a.getType();
			String sound = a.getSound();
			out += "Old MacDonald had a farm,\n" + "E-I-E-I-O.\n\n"
					+ "And on his farm he had some "
					+ name
					+ "s,\n"
					+ "E-I-E-I-O.\n\n"
					+ "With a "
					+ sound
					+ ", "
					+ sound
					+ " here,\n"
					+ "And a "
					+ sound
					+ ", "
					+ sound
					+ " there,\n"
					+ "Here a "
					+ sound
					+ ", there a "
					+ sound
					+ "\n"
					+ "Everywhere a "
					+ sound
					+ ", "
					+ sound
					+ ",\n\n" + "Old MacDonald had a farm,\n" + "E-I-E-I-O.\n\n";
		}
		System.out.println(out);
	}
}
