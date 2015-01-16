import javax.swing.JOptionPane;


public class CoinsDriver {

	public static void main(String[] args) {
		Coins c = new Coins();
		String cash = JOptionPane.showInputDialog("What is your total change? (In cents)");
		JOptionPane.showMessageDialog(null, c.getCoins(cash));
	}
}
