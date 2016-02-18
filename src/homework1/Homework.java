package homework1;

import library.TextIO;

/*
 * Designated letters "t, m, i, e, s" with their ASCII equivalent using IF's.
 * Stored each row in their appropriate spot (named one, two, etc)
 * To get the end result, I just print out each row in order.
 * 
 */

public class Homework {

	public static void main(String[] args) {
		
		String input = TextIO.getlnString().toLowerCase();
		char[] charArray = input.toCharArray();
		String one = "";
		String two = "";
		String three = "";
		String four = "";
		String five = "";
		char t = 't';
		char m = 'm';
		char I = 'i';
		char e = 'e';
		char s = 's';
		
		
		
		for (int i = 0; i < input.length(); i++) {
			System.out.println(charArray[i]);
			if (charArray[i] == t) {
				
				one = one + "***** ";
				two = two + "  *   ";
				three = three + "  *   ";
				four = four + "  *   ";
				five = five + "  *   ";
				
			}else if (charArray[i] == e) {
				one = one + "***** ";
				two = two + "*     ";
				three = three + "***** ";
				four = four + "*     ";
				five = five + "***** ";
				
			}else if (charArray[i] == s) {
				one = one + " ***  ";
				two = two + "*     ";
				three = three + " ***  ";
				four = four + "    * ";
				five = five + " ***  ";
			
			
			}else if (charArray[i] == I) {
				one = one + "  *   ";
				two = two + "  *   ";
				three = three + "  *   ";
				four = four + "  *   ";
				five = five + "  *   ";
			
			
			}else if (charArray[i] == m) {
				one = one + "    * *     ";
				two = two + "   * * *    ";
				three = three + "  *     *   ";
				four = four + " *       *  ";
				five = five + "*         * ";
			
			
			}else  {
				one = one + "      ";
				two = two + "      ";
				three = three + "      ";
				four = four + "      ";
				five = five + "      ";
			
			
			}
			
			if (i == input.length() - 1) {
				System.out.println(one);
				System.out.println(two);
				System.out.println(three);
				System.out.println(four);
				System.out.println(five);
			}
		
		
	}
	
	
	
}
}
