
/**
 * 
 * @author Aleksandar Antic
 * 
 * Algorithm by Alex Yang.
 *
 */
public class Shipment {

	
	private double d1, d2, d3, w;
	
	public Shipment(double dim1, double dim2, double dim3, double weight) {
		d1 = dim1;
		d2 = dim2;
		d3 = dim3;
		w = weight;
	}
	
	public boolean[] checkSize() {
		boolean[] sizes = new boolean[2];
		sizes[0] = false;
		sizes[1] = false;
		double p;
		if(d1>= d2 && d1>=d3) {
			p = d1+2*d2+2*d3;
		} else if(d2>=d1 && d2>=d3) {
			p = d2+2*d1+2*d3;
		} else {
			p = d3+2*d1+2*d2;
		}
		
		if(p > 100) {
			sizes[0] = true;
			if(w > 70) {
				sizes[1] = true;
				return sizes;
			} else {
				return sizes;
			}
		} else {
			if(w > 70) {
				sizes[1] = true;
				return sizes;
			} else {
				return sizes;
			}
		}
	}
	
	public String toString() {
		if(checkSize()[0] && checkSize()[1]) {
			return "The package is too heavy and too large.";
		} else if(checkSize()[0]) {
			return "The package is too large."; 
		} else if(checkSize()[1]) {
			return "The package is too heavy.";
		} else {
			return "The package is acceptable.";
		}
	}
}
