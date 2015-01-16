import gpdraw.DrawingTool;
import gpdraw.SketchPad;


public class House {

	
	private DrawingTool marker;
	
	public House(SketchPad p){
		marker = new DrawingTool(p);
	}
	
	public void drawBody(){
		marker.home();
		marker.drawRect(300, 200);
	}
	
	public void drawRoof(){
		marker.up();
		marker.move(150,100);
		marker.down();
		marker.move(-50,230);
		marker.move(-150,100);
	}
	
	public void drawChimney(){
		marker.up();
		marker.move(30, 177);
		marker.down();
		marker.move(30,225);
		marker.turnRight(90);
		marker.forward(50);
		marker.turnRight(90);
		marker.forward(78);
	}
	
	public void drawWindow() {
		marker.up();
		marker.move(100,50);
		marker.down();
		marker.drawRect(50, 50);
		marker.up();
		marker.move(100,75);
		marker.down();
		marker.backward(50);
		marker.up();
		marker.move(125,50);
		marker.down();
		marker.setDirection(180);
		marker.forward(50);
	}
	
	public void drawDoor() {
		marker.up();
		marker.move(-50,-61);
		marker.down();
		marker.drawRect(50, 78);
		marker.up();
		marker.move(-35, -61);
		marker.down();
		marker.drawCircle(5);
	}
	
	public void draw(){
		drawBody();
		drawRoof();
		drawChimney();
		drawWindow();
		drawDoor();
		marker.home();

	}
	
}
