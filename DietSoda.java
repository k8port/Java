/*
 *  A program that calculates how much diet soda is safe to drink without 
 *  dying while on a diet.
 */

package dietsoda;

/**
 *
 * @author k8port
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class DietSoda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // declare variables
        double killMouse; // amount of sweetener that killed the mouse
        double killYou;  // amount of sweetener needed to kill you at goal weight
        double mouseWeight;
        double startWeight;
        double goalWeight;
        Scanner blah;
        DecimalFormat pattern;
        
        // initialize the mouse's information
        killMouse = .039; // amount in grams
        mouseWeight = .48; // amount in pounds
        
        // initialize the dieter's information 
        blah = new Scanner(System.in);
        System.out.println("Enter your current weight in pounds.");
        startWeight = blah.nextDouble();
        System.out.println("Enter your goal weight in pounds.");
        goalWeight = blah.nextDouble();
        
        // calculate number of diet sodas a day
        killYou = (killMouse * goalWeight) / mouseWeight;
        System.out.println("Amount needed to kill you is " + killYou + " grams");
        double total = killYou / (killYou * .001);
        int sodaTotal = (int) total;
        
        // output
        pattern = new DecimalFormat("#0.0##");
        System.out.println("The number of diet sodas you can drink a day is "
                + pattern.format(total));
        

        
        
    }
    
}
