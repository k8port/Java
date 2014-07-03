/**
 * A program that changes a line of text.
 */

package changetext;

/**
 *
 * @author k8port
 */
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ChangeText {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // declare variables
        Scanner jim, jane;
        String text, chgText, fileTxt, chgFileTxt;
        
        // gather input from console
        jim = new Scanner(System.in);
        System.out.println("Write a sentence with the word \"hate\".");
        text = jim.nextLine();
        
        // change string from console
        int pos = text.indexOf("hate");
        String ending = text.substring(pos + "hate".length());
        chgText = text.substring(0, pos) + " love " + ending; 
        
        System.out.println("From console: ");
        System.out.println("The line of text to be changed is: ");
        System.out.println(text);
        System.out.println("I have rephrased the line to read: ");
        System.out.println(chgText);
        
        // gather input from file
        try {
            jane = new Scanner(new FileInputStream("chg.txt"));
            fileTxt = jane.nextLine();
            // change string from file
            int pos2 = fileTxt.indexOf("hate");
            String fileEnd = fileTxt.substring(pos2 + "hate".length());
            chgFileTxt = fileTxt.substring(0, pos2) + "love" + fileEnd;
            // output result
            System.out.println("From file: ");
            System.out.println("The line of text to be changed is: ");
            System.out.println(text);
            System.out.println("I have rephrased the line to read: ");
            System.out.println(chgText);
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }
        
    }
    
}
