import gpdraw.*;

public class Benzene {

	private DrawingTool marker;
	
	public Benzene(SketchPad pad) {
		marker = new DrawingTool(pad);
	}
	
	public void draw() {

		marker.home();
		marker.drawCircle(100);
		marker.up();
		marker.move(150);
		marker.down();
		marker.setDirection(-30);

		marker.forward(150);
		marker.setDirection(270);
		marker.forward(150);
		marker.setDirection(210);
		marker.forward(150);
		marker.setDirection(150);
		marker.forward(150);
		marker.setDirection(90);
		marker.forward(150);
		marker.setDirection(30);
		marker.forward(150);
	}
}
