package dw;
/**
 * Palindrome Class
 */
public class Palindrome  {
	public static boolean isPalindrome(String data ) {
		 // remove all whitespace from input 
		 char[] pack = new char[data.length()];
		 int index=0;
		 for (int i=0; i<data.length(); i++)  {
		    char c = data.charAt(i);
		    if (Character.isLetter(c) || Character.isDigit(c)) {
		       pack[index++]= Character.toLowerCase(c) ;
		    }
        }
        // now test for palindrome:  are chars the same backward and forward
        for (int i=0; i<index/2; i++) {
            if (pack[i] != pack[index-1-i]) return false;
        }
        return true;
    }
}