import java.util.Scanner;


public class RecursiveStringTools {
	
	
	public int length(String in) {
		if(in.isEmpty()) {
			return 0;
		} else {
			return 1 + length(in.substring(1));
		}
	}
	
	
	
	public boolean equals(String in1, String in2) {
		if(in1.length() != in2.length()) {
			return false;
		} else if(in1.isEmpty() && in2.isEmpty()) {
			return true;
		} else if (in1.charAt(0) != in2.charAt(0)){
			return false;
		} else {
			return equals(in1.substring(1), in2.substring(1));
		}
	}
	
	
	
	public boolean matches(String in1, String in2) {
		if(in1.length() != in2.length()) {
			return false;
		} else if(in1.isEmpty() && in2.isEmpty()) {
			return true;
		} else if (in1.charAt(0) == '?' || in2.charAt(0) == '?') {
			return matches(in1.substring(1), in2.substring(1));
		} else if (in1.charAt(0) != in2.charAt(0)) {
			return false;
		} else {
			return matches(in1.substring(1), in2.substring(1));
		}
	}
	

	public String reverse(String in) {
		if(in.isEmpty()) {
			return "";
		} else {
			return reverse(in.substring(1)) + in.charAt(0);
		}
	}
	
	
	/*
	 *Base Case:
	 *	string length is 1 or less -> true
	 *	first and last chars of string are both letters and not equal.
	 *Recursive Case:
	 *	If first char is not letter, take substring w/o it and do a recursive call
	 *	Otherwise, if the last char is not  a letter, take a substring without it and do a recursive call
	 *	Otherwise, take a substring without both of them and do a recursive call
	 */
	public boolean isPalindrome(String in) {
		if(in.length() <= 1) {
			return true;
		} else if (!Character.isLetterOrDigit(in.charAt(0))){
			return isPalindrome(in.substring(1));
		} else if (!Character.isLetterOrDigit(in.charAt(in.length()-1))) {
			return isPalindrome(in.substring(0,in.length()-1));
		} else {
			return isPalindrome(in.substring(1,in.length()-1));
		}
	}
	
	

	/*
	 * 
	 * Use Private helper method
	 */
	public void permutation(String str) { 
	    permutation("", str); 
	}

	private void permutation(String prefix, String str) {
	    int n = str.length();
	    
	    if (n == 0) {
	    	System.out.println(prefix);
	    } else {
	    	loop(0, prefix, str);
	    }
	}
	
	private void loop(int i, String prefix, String str) {
		
		permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, str.length()));
		
		if(i < str.length()) {
			
		} else {
			loop(i+1, "",str);
		}
	}
	
	/*
	 * use private helpers
	 * 	isVowel
	 * 	findFirstVowel
	 * 	findEndOfWord
	 * 	piglatineateWord
	 */
	public String piglatinate(String in) {
		return "";
	}
	
	
	
	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		System.out.println("Please enter a string!");
		String s = kboard.nextLine();
	
		RecursiveStringTools runner = new RecursiveStringTools();
		runner.permutation(s);
		//System.out.print("\n\nThe result is --> " + out + "\n\n");
	}
}
