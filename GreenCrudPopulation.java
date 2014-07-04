/** This program calculates green crud population numbers over a number of
 *  days. The user inputs the number of days and the starting population in
 *  pounds. The program assumes no deaths. The formula for the rate of growth 
 *  follows the Fibonacci number sequence. It also assumes 2 time periods to
 *  mature to reproducing age and then one reproduction per time period. This
 *  formula applies most directly toward asexual reproduction at a rate of one
 *  offspring per time period.
 */

package greencrudpopulation;

/**
 *
 * @author k8port
 */
import java.util.Scanner;

public class GreenCrudPopulation {

    /**
     * @param args the command line arguments
     */
    
    // green crud time periods are 5 days
    private static final int TIME_PERIOD = 5;
    
    /** Iterative method for calculating the Fibonacci sequence 
    *   of a certain length n.
    *   @param n The length of the sequence 
    *   @return the next number in the sequence
    */
    private static int fibonacci(int n) {  
        int f1 = 1, f2 = 1, f = 1;
        if (n <= 0) {
            System.out.println("Error: argument must be a positive integer.");
            System.exit(0);
        }
        if (n == 1 || n == 2)
            return 1;
        for (int i = 3; i < n; i++) {
            f = f1 + f2;
            f1 = f2;
            f2 = f;       
        }
        return f;
    }
 
    public static void main(String[] args) {
        
        // instance variables
        Scanner scan = new Scanner(System.in);
        int pounds;     // original size in pounds of population
        int days;       // the number of days we wish to observe
        int fib;        // the length of the fibonacci sequence
        
        System.out.println("Please enter the size in pounds of the current population.");
        pounds = scan.nextInt();
        System.out.println("How many days will you be observing the population?");
        days = scan.nextInt();
        
        // Each time period is 5 days. Sequence advances every 5 days.
        fib = days / 5;  // will return the last day the population numbers changed
        
        System.out.printf("Population of the green crud after %d days:%n", days);
        System.out.println(fibonacci(fib) * pounds + " ");
     
    }   
    
}
