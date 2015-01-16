import javax.swing.JOptionPane;


public class EasterCalc {
	
	public static void main(String[] args) {
		Easter easter = new Easter();
		String s = JOptionPane.showInputDialog(null, "What year would you like to calculate Easter for?");
		JOptionPane.showMessageDialog(null, "Easter is on " + easter.getMonthAndDate(s));
	}
	
}
