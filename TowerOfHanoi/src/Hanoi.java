
/**
 * n	iterations
 * 1	1
 * 2	3
 * 3	7
 * 4	15
 * 5	31
 * 6	63
 * 7	127
 * 8	255
 * 9	511
 * 10	1023
 * 
 * equation: 2 * hanoiSolution(n-1) + 1
 * 
 * @author Aleksandar Antic
 *
 */
public class Hanoi {

	private int pole1, pole2, pole3;
	public static int iterations = 0;
	
	public Hanoi( int pole1, int pole2, int pole3) {
		this.pole1 = pole1;
		this.pole2 = pole2;
		this.pole3 = pole3;
	}
	
	public void printHanoiSolution(int numDisks) {
		getHanoiSolution(numDisks, pole1, pole3, pole2);
		System.out.println(iterations);
	}
	
	private void getHanoiSolution(int numDisks, int from, int to, int storage) {
		iterations++;
		if(numDisks > 1) {
			getHanoiSolution(numDisks-1, from,storage,to);
			System.out.println("Move top disk from pole # " + from + " to pole # " + to);
			getHanoiSolution(numDisks-1, storage,to, from);
		} else {
			System.out.println("Move top disk from pole # " + from + " to pole # " + to);
		}
	}
}
