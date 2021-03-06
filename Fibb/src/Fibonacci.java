/**
 * @(#)Fibonacci.java
 *
 *
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Fibonacci {

	//20th Fibonacci number is 6765
    public static int computeFibonacci(int x) {
    	if(x < 0) {
    		throw new IllegalArgumentException("Input must be positive");
    	}
    	if (x <= 1) {
    		return x;
    	} else {
    		int answer = computeFibonacci(x-2) + computeFibonacci(x-1);
    		return answer;
    	}

    }

	public static void main (String[] args) {
		boolean success = false;
		int answer = 0, x = 0;
		do {
			try{
				Scanner kboard = new Scanner (System.in);
				System.out.print("Which fibonacci number would you like to find? --> ");
				 x = kboard.nextInt();
				answer = computeFibonacci(x);
				success = true;
				System.out.println ("The " + x + " fibonacci number is " + answer + ".");
			} catch (IllegalArgumentException ex) {
				System.out.println();
			} catch (StackOverflowError ex) {
				System.out.println("Your number is too big!");
			} catch (InputMismatchException ex){
				System.out.println("Not an integer!");
			}
		}while(!success);
	}

}



