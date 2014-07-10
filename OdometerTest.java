/** Class to test Odometer.java.
 * 
 */

package odometertest;

import java.util.Scanner;
import java.text.DecimalFormat;
/**
 *
 * @author k8port
 */
public class OdometerTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean setTrip;
        Scanner scan = new Scanner(System.in);
        DecimalFormat decimalFormatter = new DecimalFormat("#0.00");
        System.out.println("Set another trip? true or false.");
        setTrip = scan.nextBoolean();
        Odometer temp, a;
        temp = new Odometer();
        
        while (setTrip) {
            a = new Odometer(); // no-arg constructor
            a.acceptMiles();
            a.setMPG();
            System.out.println(a); 
            System.out.println("Gallons used: " + decimalFormatter.format(a.getGallons()));
            System.out.println("Same as last trip?");
            System.out.println(a.equals(temp));
            temp = a;
            System.out.println("Set another trip? true or false.");
            setTrip = scan.nextBoolean();
        }
            
    }
    
}
