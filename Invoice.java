/** A program that formats an invoice based on inputs for item, 
 *  price and quantity.
 */

package invoice;

/**
 *
 * @author k8port
 */
import java.util.Scanner;
import java.text.DecimalFormat;

public class Invoice {

    /**
     * @param args the command line arguments
     */
    
    public static final double TAX = .0625;
    
    public static void main(String[] args) {
        
        // variables
        double price1, price2, price3, total1, total2, total3, sales_tax, grand_total;
        int quantity1, quantity2, quantity3;
        String name1, name2, name3, str1 = "Item", str2 = "Quantity", 
                        str3 = "Price", str4 = "Total";
        Scanner scan;
        DecimalFormat dec;
        
        // gather info
        scan = new Scanner(System.in);
        // item 1
        System.out.println("Enter name of item 1:");
        name1 = scan.nextLine();
        System.out.println("Enter name of item 2:");
        name2 = scan.nextLine();
        System.out.println("Enter name of item 3:");
        name3 = scan.nextLine();
        
        System.out.println("Enter quantity of item 1:");
        quantity1 = scan.nextInt();
        System.out.println("Enter quantity of item 2:");
        quantity2 = scan.nextInt();
        System.out.println("Enter quantity of item 3:");
        quantity3 = scan.nextInt();
        
        System.out.println("Enter price of item 1:");
        price1 = scan.nextDouble();  
        System.out.println("Enter price of item 2:");
        price2 = scan.nextDouble();  
        System.out.println("Enter price of item 3:");
        price3 = scan.nextDouble();  
        
        total1 = price1 * quantity1;
        total2 = price2 * quantity2;
        total3 = price3 * quantity3;
        grand_total = total1 + total2 + total3;


        
        
        System.out.println("Your bill:");
        System.out.println("");
        System.out.printf("%-30s %-10s %-10s %-10s%n", str1, str2, str3, str4);
        System.out.printf("%-30s %-10d %-10.2f %-10.2f%n", name1, quantity1, price1, 
                                total1);
        System.out.printf("%-30s %-10d %-10.2f %-10.2f%n", name2, quantity2, price2, 
                                total2);
        System.out.printf("%-30s %-10d %-10.2f %-10.2f%n", name3, quantity3, price3, 
                                total3);
               
        sales_tax = TAX * grand_total;
        dec = new DecimalFormat("0.00%");
        String percent = dec.format(TAX);
        String str5 = "Subtotal";
        System.out.printf("%-50s %10.2f%n", str5, grand_total);
        System.out.printf("%-50s %10.2f%n", percent, sales_tax);
        grand_total += sales_tax;
        System.out.printf("%-50s %10.2f%n", str4, grand_total);
        
    }
    
}
