import java.util.Scanner;

/**
 * 
 * @author aantic235
 * 
 * 	magicSquare()
 * 
 * 	n     runtime(nanoseconds)    Iterations
 * 	1     4665					  0
 * 	2     9330					  4
 * 	3     6531					  32
 * 	4     19282					  200
 * 	5     138395				  1184
 * 	6     775635				  6924
 * 	7     2356451				  40384
 * 	8     3811933				  235408
 * 	9     25668426				  1372096
 * 	10    114391579				  7997204
 * 
 * 
 * 
 * 
 * 	fibonacci()
 * 
 * 	n	runtime(nanoseconds)	Iterations
 * 	10	22081					177
 * 	20	581263					21891
 * 	30	13077026				2692537
 * 	40	1479566836				331160281
 * 	45	16449609536				3672623805
 *
 *	fibonacciLoop()
 * 
 * 	n	runtime(nanoseconds)	Iterations
 * 	10	5909					10
 * 	20	8397					20
 * 	30	8708					30
 * 	40	5287					40
 * 	45	9330					45
 * 
 * 
 * The loop is far faster because there are fewer times
 * the increment++ is called. This is because the method
 * calculates each "previous" on the way to finding the
 * the nth Fibonacci number. Likewise, the timing data 
 * is faster, however, both are inconsistent because the
 * computer randomly does other tasks in between calculating
 * Fibonacci numbers, causing inconsistencies in timing.
 * In fibonacciLoop(), the pattern between iterations(i) and
 * n is i=n. However, for the recursive method, the equation
 * is approximately i = 2 * fibbonaci(n+1) - 1, or i = 1.44 * 1.62 ^ x.
 * 
 * 
 * 
 */
public class FunLoops {
	
	private static long iterations = 0;

	public static long LCM(long a, long b) {
		long tempA = a;
		long tempB = b;
		
		// finds GCD
		while (tempB > 0) {
			long temp = tempB;
			tempB = tempA % tempB;
			tempA = temp;
		}
		// uses GCD to get LCM
		return a * (b / tempA);

	}

	public static long[] magicSquare(int n) {
		long[] results = new long[n];
		long tri = 1;
		long triInc = 1;
		long square = 1;
		long squareInc = 1;
		int found = 0;
		
		while (found<n) {
			while(square != tri) {
				for(;square < tri; square  = squareInc * squareInc){ squareInc++; iterations++;}
				for(;square > tri; tri += triInc) triInc++;
			}
			results[found] = square;
			found++;
			
			squareInc++;
			square = squareInc * squareInc;
		}
		return results;
	}

	public static long factorial(long n) {
		if(n <= 1) { //Base Case
			return 1;
		} else { //Recursive Case
			long previous = factorial(n - 1);
			return previous * n;
		}
	}
	/**
	 * @pre n cannot be negative
	 * @param n the nth fibonacci number desired
	 * @return if n is 0, returns 0. If n is 1, returns 1. Otherwise, returns fibonacci(n-1) + fibonacci(n-2).
	 */
	public static long fibonacci(long n) {
		iterations++;
		if(n==1) {
			return 1;
		} else if(n == 0) {
			return 0;
		} else {
			return fibonacci(n-1) + fibonacci(n-2);
		} 
	}
	
	public static long fibonacciLoop(long n) {
		long result = 0;
		long prev1 = 0;
		long prev2 = 1;
		if(n <= 1) {
			result += n;
		} else {
			for(long i = 0; i < n; i++) {
				iterations++;
				result = prev1 + prev2;
				prev2 = prev1;
				prev1 = result;
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		/*System.out
				.println("Enter two numbers to find the Least Common Multiple of:");
		int a = s.nextInt();
		int b = s.nextInt();
		System.out.println(LCM(a, b) + "\n\n\n");
		*/
		System.out.println("Enter the nth fibonacci number:");
		int n = s.nextInt();	
		long start = System.nanoTime();
		long answer = fibonacciLoop(n);
		long stop = System.nanoTime();
		System.out.println("Runtime for the " + n + " fibonacci number: " + (stop-start));
		System.out.println(answer);
		System.out.println("Iterations: " + iterations);
	}
}
