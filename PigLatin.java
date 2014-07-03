/** A program that translates the user's name to pig latin. The program asks 
    for user input on first and last name. Any two words can be entered.
*/

package piglatin;

import java.util.Scanner;
/**
 *
 * @author k8port
 */
public class PigLatin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // initialize variables
	String first, last;
	boolean another;
	char pre, sec;
	Scanner don = new Scanner(System.in);	
	System.out.println("Welcome to PigLatinator 3000!");
        
	// get the person's name
	do {
            System.out.println("Enter a first and last name.");
            first = don.next();
            last = don.next();
	
            System.out.print("Your name in Pig Latin is: ");
            // translate to Pig Latin
            String fullName[] = {first, last};
            String pig[] = {first, last};
            for (int i=0; i<fullName.length; i++) {
                fullName[i] = fullName[i].toLowerCase();
                // System.out.println(fullName[i]);		
                pre = fullName[i].charAt(0);
                sec = fullName[i].charAt(1);
		
                switch (pre) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                            pig[i] = fullName[i] + "yay";
                            break;
                    case 's':         
                        switch (sec){	
                            case 'h':
                            case 'k':
                            case 'l':
                            case 'm':
                            case 'n':
                            case 'p':
                            case 't':
                            case 'w':
                            case 'y':
                                    pig[i] = fullName[i].substring(2) + pre + sec + "ay";
                                    //System.out.println(pig[i]);
                                    break;
                            case 'c':   
                                    if (fullName[i].charAt(2) == 'i')										
                                        pig[i] = fullName[i].substring(2) + pre + sec + "iyay";
                                    else 					
                                        pig[i] = fullName[i].substring(2) + pre + sec + "ay";
                                    break;
                            default:
                                    pig[i] = fullName[i].substring(1) + pre + "ay";
                                    break;
                        }
                        break;
                    default:
                        switch (sec) {
                            case 'h':
                            case 'l':
                            case 'r':
                            case 'y':
                                    pig[i] = fullName[i].substring(2) + pre + sec + "ay";
                                    break;
                            default:
                                    pig[i]	= fullName[i].substring(1) + pre + "ay";
                        }			 				
                } // end translation
                pig[i] = Character.toUpperCase(pig[i].charAt(0)) + pig[i].substring(1);
                System.out.print(pig[i] + " ");
            }
            System.out.println();
            System.out.println("Do you have another name to enter? (true or false)");
            another = don.nextBoolean();
        } while (another);    
    }
}
