
import gpdraw.*;

public class DragonTest {

    public static void main(String[] args) {
		SketchPad poster = new SketchPad(300, 300, 50);
		DrawingTool marker = new DrawingTool(poster);

		DragonCurve m = new DragonCurve(50,25);
		m.draw(marker);
    }

}

