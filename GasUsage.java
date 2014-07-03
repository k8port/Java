/** A program that calculates how much money you need to pay for gas on your road trip.  The program asks the user to input how many 
    miles the trip is, the current price of a gallon of gas, and the fuel economy of the car being driven.
 */

package gasusage;

/**
 *
 * @author k8port
 */

import java.util.Scanner;

public class GasUsage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //instance variables
        Scanner scan = new Scanner(System.in);
        double miles_to_go, gallon_price, mpg, trip_price;
        
        // gather info
        System.out.println("How many miles is your trip?");
        miles_to_go = scan.nextDouble();
        System.out.println("What is the current price of a gallon of gas?");
        gallon_price = scan.nextDouble();
        System.out.println("What is the average fuel economy of your car?");
        mpg = scan.nextDouble();
        
        // perform calc
        trip_price = (miles_to_go / mpg) * gallon_price;
        
        // output result
        System.out.printf("The total cost of travelling %.1f miles with a fuel"
                           + " economy of %.1f%ngallons per mile at the current "
                            + "price of $%.2f a gallon is: $%.2f%n", miles_to_go,
                                mpg, gallon_price, trip_price);
        
    }
    
}
