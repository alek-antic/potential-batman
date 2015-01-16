import gpdraw.*;


public class KochSnowflake {
	
	
	private int x, y;
	private KochCurve kc;
	
	public KochSnowflake(int x, int y, KochCurve kc) {
		this.x=x;
		this.y=y;
		this.kc=kc;
		
	}
	
	public void draw(DrawingTool marker) {
		marker.up();
		marker.move(x, y + kc.getLength()/(2 * Math.toDegrees(Math.cos(30))));
		marker.down();
		marker.setDirection(-60);
		kc.draw(marker);
		marker.setDirection(180);
		kc.draw(marker);
		marker.setDirection(60);
		kc.draw(marker);
	}
}
