
import gpdraw.*;

public class KochTest {

    public static void main(String[] args) {
		SketchPad poster = new SketchPad(300, 300, 100);
		DrawingTool marker = new DrawingTool(poster);

		KochSnowflake m = new KochSnowflake(0, 0, new KochCurve (3,300));
		m.draw(marker);
    }

}

