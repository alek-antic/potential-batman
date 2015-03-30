import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class NumberLine {

	
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		GUI gui = new GUI();
		gui.setVisible(true);
	}
}
