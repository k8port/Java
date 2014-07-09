/** A program that searches a dictionary for the word with the most 
 *  consecutive vowels.
 */

package findconsecutivevowels;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/**
 *
 * @author k8port
 */
public class FindConsecutiveVowels {
    /** Method to determine if given char is a vowel.
     * @param a the char being examined
     * @return true if char is a vowel
     */
    public static boolean isVowel(char a) {
        boolean vowel = false;  // true if is a vowel - assume not a vowel
        if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' 
                || a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U') 
           vowel = true;
        return vowel;
    }
    
    /** Returns a value for how many consecutive vowels are in a word.
     * @param word the word for which to count the vowels
     * @return the number of consecutive vowels
     */
    public static int countVowels(String word) {
        //System.out.println("inside countVowels method");
        int length = word.length();
        int count = 0, temp_count = 0;
        for (int i = 0; i < word.length(); i++) {

            if (isVowel(word.charAt(i))) {
                temp_count++;
                int j = i + 1;
                while (j < length && isVowel(word.charAt(j))) {
                    // System.out.println("inside dbl condition while loop");
                    temp_count++;
                    j++;
                }
                if (temp_count > count) {
                    // System.out.println("inside if statement");
                    count = temp_count;
                    temp_count = 0;
                }
            }
        }
        // System.out.println("leaving count vowel method");
        return count;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // instance variables
        Scanner scan;
        int temp_count; // the current word vowel count
        int vowel_count = 0; // the longest number of consecutive vowels
        String word; // the current word being examined
        String result = "No consecutive vowels"; // word with the most consecutive vowels
        
        // read file
        try {
            scan = new Scanner(new FileInputStream("wordlist.txt"));
            while (scan.hasNext()) {
                word = String.valueOf(scan.nextLine()); 
                System.out.println(word);
                temp_count = countVowels(word);
                if (temp_count > vowel_count) {
                    vowel_count = temp_count;
                    result = word;
                }
            }
            System.out.println("The word with the most consecutive vowels in "
                    + "this dictionary is: " + result + " with " + vowel_count  
                    + " vowels in a row.");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            System.exit(0);
        }
    }
    
}
