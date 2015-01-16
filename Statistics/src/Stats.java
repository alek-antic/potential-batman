
public class Stats {

	private int totalData;
	
	public int[] readData(String filename) {
		ArrayReader reader = new ArrayReader(filename);
		int[] data = new int[10000];
		totalData = reader.fillArray(data);
		return data;
	}
	
	public int getTotalData() {
		return totalData;
	}
	
	public double average(int[] data, int totalData) {
		double average = 0;
		for(int i = 0; i < totalData; i++)
			average += data[i];
		
		return average/totalData;
	}
	
	public double sD(int[] data, int totalData) {
		double sD = 0;
		double ave = average(data, totalData);
		for(int i = 0; i < totalData; i++) 
			sD += (ave - data[i]) * (ave-data[i]);
		
		return Math.sqrt(sD/(totalData-1));
	}
	
	public int[] modes(int[] data, int totalData) {
		int maxCount = 0;
		int count = 0;
		int modesFound = 0;
		int[] modes = new int[2];
		for(int i = 0; i < totalData; i++) {
				for(int j = 0; j < totalData; j++) {
					if(data[i]==data[j])
						count++;
				}
				if(count > maxCount) {
					maxCount = count;
					modes[modesFound] = data[i];
				}
				count = 0;
			}
		return modes;
	}
	
	public int compact(int[] data) {
		int i = 0;
		for(int x : data) {
			if(x != 0) {
				data[i]=x;
				i++;
			}
		}
		for(int j = i; j < data.length; j++)
			data[j] = 0;
		return i;
	}
	
	public static void main(String[] args) {
		Stats s = new Stats();
		System.out.println(s.average(s.readData("numbers.txt"), s.getTotalData()));
		System.out.println(s.sD(s.readData("numbers.txt"), s.getTotalData()));
		int[] modes = s.modes(s.readData("numbers.txt"), s.getTotalData());
		System.out.println(modes[0] + " " + modes[1]);
		System.out.println();
		System.out.println(s.average(s.readData("numbers2.txt"), s.getTotalData()));
		System.out.println(s.sD(s.readData("numbers2.txt"), s.getTotalData()));
		modes = s.modes(s.readData("numbers2.txt"), s.getTotalData());
		System.out.println(modes[0] + " " + modes[1]);
		System.out.println();
		System.out.println(s.average(s.readData("numbers3.txt"), s.getTotalData()));
		System.out.println(s.sD(s.readData("numbers3.txt"), s.getTotalData()));
		modes = s.modes(s.readData("numbers3.txt"), s.getTotalData());
		System.out.println(modes[0] + " " + modes[1]);
		System.out.println();
		System.out.println(s.average(s.readData("numbers4.txt"), s.getTotalData()));
		System.out.println(s.sD(s.readData("numbers4.txt"), s.getTotalData()));
		modes = s.modes(s.readData("numbers4.txt"), s.getTotalData());
		System.out.println(modes[0] + " " + modes[1]);
		
		int[] data = s.readData("compact.txt");
		System.out.println(s.compact(data));
		for(int i = 0; i < s.getTotalData(); i++)
			System.out.println(data[i]);
		
		data = s.readData("numbers2.txt");
		int size = s.compact(data);
		System.out.println("\n" + s.average(data, size));
		System.out.println(s.sD(data, size));
		System.out.println(s.modes(data, size)[0]);
		

		data = s.readData("numbers3.txt");
		int size3 = s.compact(data);
		System.out.println("\n" + s.average(data, size3));
		System.out.println(s.sD(data, size3));
		System.out.println(s.modes(data, size3)[0]);
		

		
	}
}
