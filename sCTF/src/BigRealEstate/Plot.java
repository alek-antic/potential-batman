package BigRealEstate;

public class Plot {
	
	private String name;
	private int price, width, length;
	
	public Plot(String name, int price ,int width, int length) {
		this.name = name;
		this.price = price;
		this.width = width;
		this.length = length;
	}
	
	public double getAreaToPriceRatio() {
		return width * length / price;
	}
	
	
	public String toString() {
		return name;
	}

}
