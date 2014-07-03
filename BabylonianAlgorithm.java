/** Calculates the square root of any double using the Babylonian algorithm.
 * 
 */

package babylonianalgorithm;

/**
 *
 * @author k8port
 */
import java.text.DecimalFormat;
import java.util.Scanner;

public class BabylonianAlgorithm {

    /**
     * @param args the command line arguments
     */
    private static final double PERCENT = 0.01;
    
    public static void main(String[] args) {
        
        // instance variables
        double r, temp, guess;
        int n = -1; // initialize n to -1
        Scanner scan = new Scanner(System.in);
        
        // gather user input
        while (n < 1) {            
            System.out.println("Enter a number to calculate square root using "
                + "the babylonian algorithm.");
            n = scan.nextInt();
        } 
        DecimalFormat formatter = new DecimalFormat("000.00");
        
        // iteration one
        guess = n / 2;
        do {
            temp = guess;
            // System.out.println("iterate");
            r = n / guess;
            guess = (guess + r) / 2;
        } while ((temp - guess) >= (PERCENT * temp));
        
        System.out.println(formatter.format(guess));
        
    }
    
}
