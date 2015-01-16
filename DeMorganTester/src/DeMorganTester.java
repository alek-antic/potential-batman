
public class DeMorganTester {

	public boolean systemOne(boolean one, boolean two) {
		return !one && !two;
		
	}
	
	public boolean systemTwo(boolean one, boolean two) {
		return !one || !two;
		
	}
	
	public boolean systemThree(boolean one, boolean two) {
		return !one || !two;
		
	}
	
	public boolean systemFour(boolean one, boolean two) {
		return !one && !two;
		
	}
	public static void main(String[] args) {
		boolean one, two;
		boolean[] result1 = new boolean[4];
		boolean[] result2 = new boolean[4];
		boolean[] result3 = new boolean[4];
		boolean[] result4 = new boolean[4];
		DeMorganTester d = new DeMorganTester();
		
		for(int i = 0; i < 4; i++) {
			if(i==0){
				one=true;
				two=true;
			} else if(i==1) {
				one=true;
				two=false;
			} else if(i==2){
				one=false;
				two=true;
			} else {
				one=false;two=false;
			}
			result1[i] = d.systemOne(one,two);
			result2[i] = d.systemTwo(one,two);
			result3[i] = d.systemThree(one, two);
			result4[i] = d.systemFour(one,two);
		}
		
		/*
		 * Bad style below to make formatting of printing easier.
		 */
		
		
		System.out.print("!((x >= 5) || (y < 7))                  ");System.out.println("(!(x < 5) && !(y >= 7))");
		System.out.print("TRUTH TABLE                             ");System.out.println("TRUTH TABLE");
		System.out.print("-----------------------------           ");System.out.println("-----------------------------");
		System.out.print("| x>=5  |  y<7   |  RESULT  |           ");System.out.println("|  x<5  |  y>=7  |  RESULT |");
		System.out.print("| true  |  true  |  false   |           ");System.out.println("| true  |  true  |  " + result1[0] + "  |");
		System.out.print("| true  | false  |  false   |           ");System.out.println("| true  | false  |  " + result1[1] + "  |");
		System.out.print("| false |  true  |  false   |           ");System.out.println("| false |  true  |  " + result1[2] + "  |");
		System.out.print("| false | false  |  true    |           ");System.out.println("| false | false  |  " + result1[3] + "   |");
		System.out.print("-----------------------------           ");System.out.println("-----------------------------");
		
		
		System.out.print("!((a != b) && (g == 5))                 ");System.out.println("(!(a == b) || !(g !=5))");
		System.out.print("TRUTH TABLE                             ");System.out.println("TRUTH TABLE");
		System.out.print("-----------------------------           ");System.out.println("-----------------------------");
		System.out.print("| a!=b  |  y<7   |  RESULT  |           ");System.out.println("| a==b  |  g!=5  |  RESULT |");
		System.out.print("| true  |  true  |  false   |           ");System.out.println("| true  |  true  |  " + result2[0] + "  |");
		System.out.print("| true  | false  |  true    |           ");System.out.println("| true  | false  |  " + result2[1] + "   |");
		System.out.print("| false |  true  |  true    |           ");System.out.println("| false |  true  |  " + result2[2] + "   |");
		System.out.print("| false | false  |  true    |           ");System.out.println("| false | false  |  " + result2[3] + "   |");
		System.out.print("-----------------------------           ");System.out.println("-----------------------------");
		
		System.out.print("!((x <= 8) && (y > 4))                  ");System.out.println("(!(x > 8) || !(y <= 4))");
		System.out.print("TRUTH TABLE                             ");System.out.println("TRUTH TABLE");
		System.out.print("-----------------------------           ");System.out.println("-----------------------------");
		System.out.print("| x<=8  |  y>4   |  RESULT  |           ");System.out.println("|  x>8  |  y<=4  |  RESULT |");
		System.out.print("| true  |  true  |  false   |           ");System.out.println("| true  |  true  |  " + result3[0] + "  |");
		System.out.print("| true  | false  |  true    |           ");System.out.println("| true  | false  |  " + result3[1] + "   |");
		System.out.print("| false |  true  |  true    |           ");System.out.println("| false |  true  |  " + result3[2] + "   |");
		System.out.print("| false | false  |  true    |           ");System.out.println("| false | false  |  " + result3[3] + "   |");
		System.out.print("-----------------------------           ");System.out.println("-----------------------------");
		
		System.out.print("!((i > 4) || (j <= 6))                  ");System.out.println("(!(i <= 4) && !(j > 6))");
		System.out.print("TRUTH TABLE                             ");System.out.println("TRUTH TABLE");
		System.out.print("-----------------------------           ");System.out.println("-----------------------------");
		System.out.print("|  i>4  |  j<=6  |  RESULT  |           ");System.out.println("| i<=4  |  j>6   |  RESULT |");
		System.out.print("| true  |  true  |  false   |           ");System.out.println("| true  |  true  |  " + result4[0] + "  |");
		System.out.print("| true  | false  |  false   |           ");System.out.println("| true  | false  |  " + result4[1] + "  |");
		System.out.print("| false |  true  |  false   |           ");System.out.println("| false |  true  |  " + result4[2] + "  |");
		System.out.print("| false | false  |  true    |           ");System.out.println("| false | false  |  " + result4[3] + "   |");
		System.out.print("-----------------------------           ");System.out.println("-----------------------------");
	}
}
