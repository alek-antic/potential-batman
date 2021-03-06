package BigRealEstate;

public class BRE {

	
	public static void main(String[] args) {
		
		
		FileIO accessor = new FileIO();
		
		
		String plotData = accessor.readFile("realestate.txt");
		
		String[] plots = plotData.split(System.lineSeparator());
		
		Plot[] allPlots = new Plot[plots.length];
		
		for(int i = 0; i < plots.length; i++) {
			
			String[] argues = plots[i].split(" \" ");
			
			if(argues.length != 4)
				continue;
			
			allPlots[i] = new Plot(argues[0], Integer.parseInt(argues[1]),
							Integer.parseInt(argues[2]), Integer.parseInt(argues[3]));
		}
		
		double bestRatio = 0;
		String name = "";
		double secondRatio = 0;
		String name2 = "";
		for(Plot p : allPlots) {
			if(p == null)
				continue;
			
			double ratio = p.getAreaToPriceRatio();
			if(ratio > bestRatio) {
				secondRatio = bestRatio;
				bestRatio = ratio;
				name2 = name;
				name = p.toString();
			} else if(ratio > secondRatio) {
				secondRatio = ratio;
				name2 = p.toString();
			}
		}
		
		System.out.println(name + "; " + name2);
		
	}
	
	
	
}
