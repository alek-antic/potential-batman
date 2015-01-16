import gpdraw.DrawingTool;


public class DragonCurve {
	
	private int length,level;
	
	public DragonCurve(int length, int level) {
		this.length=(int) (length / level / Math.sqrt(2));;
		this.level=level;
	}
	
	public void draw(DrawingTool marker) {
		marker.home();
		marker.setDirection(0);
		drawDragon(length,level,marker);
	}
	
	private String generateTurnSequence(int level) {
		String n = "";
		if(level == 1) {
			n = "1";
		} else {
			String a = generateTurnSequence(level - 1);
			String b=a.substring(0,a.length()/2);
			String x=a.substring(a.length()/2+1,a.length());
			String z="1";
			
			if(a.charAt(a.length()/2)==48) {
				z ="1";
			}
			
			if(a.charAt(a.length()/2)==49) {
				z ="0";
			}
			n=a+"1"+b+z+x;
		}
		return n;
	}
	
	/*
	 * Parses generateTurnSequence() to make the fractal.
	 */
	private void drawDragon(int length,int level, DrawingTool marker) {
		String a = generateTurnSequence(level);
		for(int i = 0; i < a.length(); i ++) {
			marker.forward(length);
			if(a.charAt(i) == '1') {
				marker.turnLeft(90);
			} else {
				marker.turnRight(90);
			}
		}
		
	}
}
