/** A program that calculates how many months it will take to pay off an item
 *  based on the interest rate and how much money is paid in interest. The 
 *  program asks the user to input the name of the item, how much money it 
 *  costs, the yearly interest rate on the card, and your monthly payment.
 *  The program assumes an overpayment is made on the last month.
 * 
 */

package creditfuck.java;

/**
 *
 * @author k8port
 */
import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class CreditFuckJava {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // instance variables
        Scanner scan = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("#0.0#%");
        NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
        double amount_owed;     // cost of the item
        double interest_rate;   // yearly interest rate of card
        double mo_interest;     // amount of current month's interest
        double mo_payment;      // monthly payment toward loan
        int months = 0;         // number of months to pay off loan 
        double interest_amt;    // amount of money spent paying off interest
        double total_interest = 0.0; // total interest paid over life of the loan
        double current;         // current months payment toward debt
        
        // gather input from user
        System.out.println("Enter how much your item costs.");
        amount_owed = scan.nextDouble();
        System.out.println("Enter the interest rate on the loan.");
        interest_rate = scan.nextDouble();
        System.out.println("Enter how much your monthly payment will be.");
        mo_payment = scan.nextDouble();
        
        String original = moneyFormat.format(amount_owed);
        // calculate monthly interest rate and format payments and percents
        
        interest_rate /= 100 ; // converts rate to fraction
        String yearly = formatter.format(interest_rate);
        interest_rate /= 12;  // 12 months in a year
        String monthly = formatter.format(interest_rate);
        
        System.out.printf("Yearly interest is %s and monthly interest is %s.%n",
                yearly, monthly);       
        System.out.printf("Amount owed is %s.%n", original);
        System.out.println("");
        
        while (amount_owed > 0) {
            // calculate how much interest you pay this month
            mo_interest = amount_owed * interest_rate; 
            //String interest_paid = moneyFormat.format(mo_interest);
            //System.out.printf("Monthly interest this month is %s.%n", interest_paid);
           
            // keep a tally on how much interest is paid
            total_interest += mo_interest; 
            //String total = moneyFormat.format(total_interest);
            //System.out.printf("Total interest paid over time is %s.%n", total);
            
            // deduct interest from monthly payment
            current = mo_payment - mo_interest;
            //String pymt = moneyFormat.format(current);
            //System.out.printf("This month you pay %s toward your debt.%n", pymt);
            
            // deduct monthly payment amount from debt
            amount_owed -= mo_payment;
            //String owed = moneyFormat.format(amount_owed);
            //System.out.printf("You now owe %s.%n", owed);
            
            // count another monthly payment
            months++; 
            //System.out.printf("You have been paying for %d months.%n", months);
            //System.out.println("");

        } // end while loop because amount owed is paid off
       
        System.out.printf("You will pay $%.2f in interest over a period of %d months.%n",
                total_interest, months);
        int years = months / 12;
        months %= 12;
        System.out.printf("That means %d year(s) and %d month(s).%n", years, months);
    }
    
}
