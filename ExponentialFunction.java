/** The program calculates the exponential function e^x where x is a value
 *  input by the user of the program. 
 *  The function is: 1 + x + x^2/2! + x^3/3! + ... + x^n/n!.
 */

package exponentialfunction;

import java.util.Scanner;
import java.text.DecimalFormat;
/**
 *
 * @author k8port
 */
public class ExponentialFunction {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // instance variables
        DecimalFormat decimal = new DecimalFormat("#0.00");
        Scanner scan = new Scanner(System.in);
        double x; // user input value to solve 
        String ans; // user input yes or no 'y' or 'n'
        boolean go = true; // flag to determine on and off status of program
        double result; // variable to store result of function
        int n = 1; // inputs of n for the exponential function
        double num, den; // numerator and denominator of exponential function
        
        // gather data
        System.out.println("Tool for calculating the exponential function.");
        do {
            System.out.println("Input a positive whole positive number x to "
                    + "calculate e^x.");
            x = scan.nextDouble();
            while (n <= 100 && n >= 1) {
                result = 1 + x;
                num = x;
                den = n;
                if (n > 1) {
                    for (int i = 2; i <= n; i++) 
                        num *= num;
                    for (int j = n-1; j > 0; j--) 
                        den *= j;
                    result += num / den; 
                }  
                if (n <= 10 || n == 50 || n == 100) 
                  System.out.println("The value of e^" + x + " when n is " 
                          + n + ": " + decimal.format(result));
                n++; 
            }
            
            System.out.println("Would you like to quit? yes or no.");
            ans = scan.next();
            if (ans.equalsIgnoreCase("yes"))
                go = false;
        } while (go);
    
    }
}
