import javax.swing.JOptionPane;


public class IRS {

	private static final String[] MARITAL_STATUS = {"Single", "Married, filing jointly"};
	
	public double getTax() {
		if(JOptionPane.showOptionDialog(null, "What is your marital status?", "Single or Married?",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, MARITAL_STATUS, 0) == 0) {
			String i = JOptionPane.showInputDialog(null, "What is your taxable income?", "Income");
			double j = Double.parseDouble(i);
			if(j < 27050) {
				return 0.15 * j;
			} else if(j < 65550){
				return 4057.50 + 0.275 * (j-27050);
			} else if(j < 136750) {
				return 14645.00 + 0.305 * (j-65550);
			} else if(j < 297350) {
				return 36361.00 + .355 * (j-136750);
			} else {
				return 93374.00 + .391 * (j-297350);
			}
		} else {
			String i = JOptionPane.showInputDialog(null, "What is your taxable income?", "Income");
			double j = Double.parseDouble(i);
			if(j < 45200) {
				return 0.15 * j;
			} else if(j < 109250){
				return 6780.00 + .275 * (j-45200);
			} else if(j < 166500) {
				return 24393.75 + .305 * (j-109250);
			} else if(j < 297350) {
				return 41855.00 + .355 * (j-166500);
			} else {
				return 88306.00 + .391 * (j-297350);
			}
		}
	}
	
	public void alert() {
		JOptionPane.showMessageDialog(null, "Taxes due: " + getTax(), "Taxes", JOptionPane.INFORMATION_MESSAGE);
	}
}
