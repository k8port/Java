/** A program to calculate the estimated height of a child based on the heights
 *  of the parents or persons contributing genes. Program assumes that a child 
 *  is made from one male and one female. 
 */

package howtallwillmykidbe.java;

/**
 *
 * @author k8port
 */
import java.util.Scanner;

public class HowTallWillMyKidBeJava {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        
        // instance variables
        /** Scanner object to gather input from the console */
        Scanner scan = new Scanner(System.in);
        /** flag is set to true if child is male */
        boolean aBoy;
        /** height in inches of each parent */
        int maHi, paHi; 
        /** holds height inputs */
        int ft, in;
        /** variables used to output estimated height of the child */
        int babyFt, babyIn;
        /** flag to determine whether to keep using or stop */
        boolean use;
        System.out.println("This program will calculate the adult height of your "
                        + "child. ");
        do {            
            // gather input from user
            System.out.println("Enter the height of the father in feet and inches."
                        + "\nUse a space between each value.");
            ft = scan.nextInt();
            in = scan.nextInt();
            paHi = (ft * 12) + in; // calculate height in inches
            System.out.println("Father is " + paHi + " inches.");
            
            System.out.println("Now enter height of the mother.");
            ft = scan.nextInt();
            in = scan.nextInt();
            maHi = (ft * 12) + in; // calculate height in inches
            System.out.println("Mother is "+ maHi + " inches.");
            
            System.out.println("True or false: My child is a boy.");
            aBoy = scan.nextBoolean();
            System.out.println("My child is a boy: " + aBoy);
            
            System.out.println("Calculating height of your child...");
            if (aBoy) {
                babyIn = (int) (paHi * 13) / 12;
                babyIn += maHi;
                babyIn /= 2;
            } 
            else { 
                babyIn = (int)(maHi * 12) / 13;
                babyIn += paHi;
                babyIn /= 2;
            }
            
            // convert to feet and inches
            babyFt = babyIn / 12;
            babyIn %= 12;
            System.out.printf("Your child is estimated to be %d %d tall.%n",babyFt, babyIn);
            System.out.println("Would you like to perform another estimation?");
            use = scan.nextBoolean();
        } while (use);
        
        
        
    }
    
}
