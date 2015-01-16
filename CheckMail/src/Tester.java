import javax.swing.JOptionPane;


public class Tester {

	
	public static void main(String[] args) {
		double d1 = Double.parseDouble(JOptionPane.showInputDialog(null,
				"What is one dimension of your package?", "CheckMail", JOptionPane.QUESTION_MESSAGE));
		double d2 = Double.parseDouble(JOptionPane.showInputDialog(null,
				"What is another dimension of your package?", "CheckMail", JOptionPane.QUESTION_MESSAGE));
		double d3 = Double.parseDouble(JOptionPane.showInputDialog(null,
				"What is the last dimension of your package?", "CheckMail", JOptionPane.QUESTION_MESSAGE));
		double w = Double.parseDouble(JOptionPane.showInputDialog(null,
				"What is the weight of your package?", "CheckMail", JOptionPane.QUESTION_MESSAGE));
		Shipment p = new Shipment(d1,d2,d3,w);
		JOptionPane.showMessageDialog(null, p, "CheckMail", JOptionPane.INFORMATION_MESSAGE);
		
	}
}
