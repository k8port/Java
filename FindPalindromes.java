/** A program that reads through a dictionary of words and finds the longest
 *  word that is a palindrome. Any text file containing one word per line can 
 *  used.
 */

package findpalindromes;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/**
 *
 * @author k8port
 */
public class FindPalindromes {
    /** Method to test if word is a palindrome. Palindromes are 
     *  even length words where the first half mirrors the second half.
     * @param word the word to test for palindrome condition
     * @return true if word is a palindrome.
     */
    public static boolean isPalindrome(String word) {
        boolean isPalindrome = true; // assume not a palindrome 
        int length = word.length();
        if (length % 2 != 0)   // check for even length word
            isPalindrome = false;
        else {
            char a, b;
            for (int i = 0, j = length-1; i < j; i++, j--) {
                a = word.charAt(i);
                b = word.charAt(j);
                if (a != b)
                    isPalindrome = false;
            }
        }
        if (isPalindrome) {
            System.out.println("Palindrome: " + word);
        }
        return isPalindrome;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // instance variables
        Scanner scan;
        int max = 0; // the length of the longest word that is a palindrome
        String word; // the current word being examined
        String result = "No Palindromes"; // the longest word that is a palindrome
        
        // read file
        try {
            scan = new Scanner(new FileInputStream("words.txt"));
            while (scan.hasNext()) {
                word = String.valueOf(scan.nextLine()); 
                if (FindPalindromes.isPalindrome(word)) {
                    if (word.length() > max) {
                        result = word;
                        max = word.length();
                    }
                }
            }
            System.out.println("Longest palindrome in the dictionary is: " + result);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            System.exit(0);
        }
        
        
    }
    
}
