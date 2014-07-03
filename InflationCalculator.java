/** A program to gauge the expected cost of an item in a specified number of
 *  years. The program asks for the cost of the item, the number of years from
 *  now that the item will be purchased and the rate of inflation. It then 
 *  outputs the estimated cost of the item after the specified period.
 */

package inflationcalculator;

/**
 *
 * @author k8port
 */
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class InflationCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // instance variables
        Scanner scan = new Scanner(System.in);
        DecimalFormat form = new DecimalFormat("#0.0#%");
        NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
        String item;        // the item
        int years;          // the number of years
        double inflation;   // the rate of inflation
        double cost;        // the cost of the item
        
        // gather input
        System.out.println("Inflation Calculator.");
        System.out.println("Enter the item you are purchasing.");
        item = scan.nextLine();
        System.out.println("Enter how much it costs.");
        cost = scan.nextDouble();
        System.out.println("Enter how many years from now you will be purchasing"
                + "  the item.");
        years = scan.nextInt();
        System.out.println("Enter the current rate of inflation.");
        inflation = scan.nextDouble();
        
        inflation /= 100; // convert percentage to a fraction
        
        for (int i = 0; i < years; i++) {
            cost += cost * inflation;            
        }
        
        String percent = form.format(inflation);
        String money = moneyFormat.format(cost);
        //System.out.println("cost: " + money);
        //System.out.println("Inflation: " + percent);
        System.out.printf("In %d years with an inflation rate of %s the cost "
               + "will be %s.%n", years, percent, money);
    }
    
}
