/** The program calculates the exponential function e^x where x is a value
 *  input by the user of the program.
 */

package exponentialfunction;

import java.util.Scanner;
/**
 *
 * @author k8port
 */
public class ExponentialFunction {
    
    /** Returns the value of the exponential function with the exponent as    
     *  the parameter. The function is: 1 + x + x^2/2! + x^3/3! + ... + x^n/n!.
     *  @param x An integer value x.
     *  @param x An integer value n.
     *  @return the result of e^n for .
     */ 
    private static double ExpFx(int x, int n) {
        int[] factorial = new int[n];
        int[] exp = new int[n];
        int f = 1, e =1;
        double result = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
            e *= e;
            factorial[i-1] = f;
            exp[i-1] = e; 
        }
        for (int j = n; j > 1; j--) 
            result += exp[n] / factorial[n];
        return result;
    }
    
    private static final int[] INPUT = {1, 10, 50, 100}; 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // instance variables
        Scanner scan = new Scanner(System.in);
        int x; // user input value to solve 
        String ans; // user input yes or no 'y' or 'n'
        boolean go = true; // flag to determine on and off status of program
        
        // gather data
        System.out.println("Tool for calculating the exponential function.");
        do {
            System.out.println("Please input a value x to calculate e^x.");
            x = scan.nextInt();
        
            // solve the equation for inputs 1, 10, 50 and 100
            for (int i = 0; i < INPUT.length; i++) {
                System.out.println("For input of " + INPUT[i] + ":");
                System.out.println(ExpFx(x, INPUT[i]));
            }
            System.out.println("Would you like to quit? y or n.");
            ans = scan.next();
            if (ans == "yes")
                go = false;
        } while (go);
    
    }
}
