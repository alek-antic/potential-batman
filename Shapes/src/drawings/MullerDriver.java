package drawings;
import gpdraw.*;


public class MullerDriver {
	
	public MullerDriver() {
		SketchPad pad = new SketchPad(1000,1000);
		DrawingTool marker = new DrawingTool(pad);
		Muller m = new Muller();
		m.draw(marker);
	}
	
	public static void main (String[] args) {
		MullerDriver mD = new MullerDriver();
	}
}
