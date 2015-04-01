import java.awt.Font;
import java.awt.Shape;


public interface ControlListener {
	
	public void changeShape(Shape s);
	public void changeLocation(int loc);
	public void changeFontStyle(Font font);
	
}
