/** A program that computes the yearly depreciation of an item.
 */

package depreciation;

/**
 *
 * @author k8port
 */

import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class Depreciation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // variables
        double price, sal_val, depre;
        int years;
        Scanner smith;
        NumberFormat depForm;
        
        // gather info
        smith = new Scanner(System.in);
        System.out.println("What was the purchase price of your item?");
        price = smith.nextDouble();
        System.out.println("How many years can you use this item");
        years = smith.nextInt();
        System.out.println("What is the expected resale value of the item once"
                + " you have completed its use?");
        sal_val = smith.nextDouble();
        
        // compute depreciation
        depre = (price - sal_val) / years;
        
        // output result
        depForm = NumberFormat.getCurrencyInstance();
        System.out.print("The yearly depreciation in value for your item is ");
        System.out.println(depForm.format(depre));
    }
    
}
