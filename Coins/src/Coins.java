
public class Coins {

	private int total;
	
	public int getQuarters()
	{
		int numberQ = total / 25;
		return numberQ;
	}
	
	public int getDimes()
	{
		int numberQ = total /25;
		int dimeMax = total - (numberQ * 25);
		int numberD = dimeMax / 10;
		return numberD;
	}
	public int getNickles()
	{
		int numberQ = total /25;
		int dimeMax = total - (numberQ * 25);
		int numberD = dimeMax / 10;
		int nickleMax = dimeMax - (numberD * 10);
		int numberN = nickleMax/ 5;
		return numberN;
	}
	public int getPennies()
	{
		int numberQ = total /25;
		int dimeMax = total - (numberQ * 25);
		int numberD = dimeMax / 10;
		int nickleMax = dimeMax - (numberD * 10);
		int numberN = nickleMax/ 5;
		int pennies = nickleMax - (numberN * 5);
		return pennies;
	}
	
	public String getCoins(String cash) {
		
		int q,d,n,p;
		total = Integer.parseInt(cash);
		q= getQuarters();
		d= getDimes();
		n = getNickles();
		p= getPennies();
		
		return "Quarter(s): " + q + "\nDime(s): " + d + "\nNickel(s): " + n + "\nPenny(s): "+ p;
	}
}
