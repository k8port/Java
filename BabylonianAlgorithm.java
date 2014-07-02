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
  
    private static final double PERCENT = 0.01;  // percentage of accuracy for determining number of iterations
    
    public static void main(String[] args) {
        
        // declare variables
        double r, temp, guess;
        Scanner scan = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("000.00"); // for formatting ressults 
        
        // gather input from console
        System.out.println("Enter a number to calculate square root using "
                + "the babylonian algorithm.");
        int n = scan.nextInt();
        
        // calculate algorithm
        // repeat loop until result is within 1% of previous result
        guess = n / 2;
        do {
            temp = guess;
            System.out.println("iterate");
            r = n / guess;
            guess = (guess + r) / 2;
        } while ((temp - guess) >= (PERCENT * temp));
        
        System.out.println(formatter.format(guess));
        
    }
    
}
