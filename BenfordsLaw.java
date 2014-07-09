/** A program to test Benford's Law which states that when dealing with numbers
 *  from data sources, the leading digit will be 1 30% of the time and then 
 *  drop with larger digits so that the leading digit is 9 about 5% of the time.
 */

package benfordslaw;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

/**
 *
 * @author k8port
 */
public class BenfordsLaw {
    
    /** A method that returns the first digit of any number.
     * @param data_num to retrieve first digit of this number
     * @return the first digit of data_num
     */
    public static int getFirstDigit(int data_num) {  
        while (data_num / 10 > 0) 
            data_num /= 10;
        return data_num;
    } 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // declare variables
        Scanner scan;
        DecimalFormat decimalFormatter = new DecimalFormat("#0.##%");
        int data; // numerical data
        int digit; // first digit of data number
        int one = 0, two = 0, three = 0, four = 0, five = 0, six = 0, 
                seven = 0, eight = 0, nine =0;
        int total = 0; // total data numbers analyzed
        
        try {
            scan = new Scanner(new FileInputStream("WorldPopulations.txt"));
            while (scan.hasNext()) {
                total++;
                data = scan.nextInt();
                digit = getFirstDigit(data);
                System.out.println(digit);
                switch (digit) {
                    case 1:
                        one++;
                        break;
                    case 2:
                        two++;
                        break;
                    case 3:
                        three++;
                        break;
                    case 4:
                        four++;
                        break;
                    case 5:
                        five++;
                        break;
                    case 6:
                        six++;
                        break;
                    case 7:
                        seven++;
                        break;
                    case 8:
                        eight++;
                        break;
                    case 9:
                        nine++;
                        break;
                    default:
                        System.out.println("Program error");
                        System.exit(1);
                        break;
                } // end switch
            } // end while
            System.out.println(one/total);
            System.out.printf("Data starts with 1 %s of the time.%n", 
                    decimalFormatter.format((double)one/(double)total));
            System.out.printf("Data starts with 2 %s of the time.%n", 
                    decimalFormatter.format((double)two/(double)total));
            System.out.printf("Data starts with 3 %s of the time.%n", 
                    decimalFormatter.format((double)three/(double)total));
            System.out.printf("Data starts with 4 %s of the time.%n", 
                    decimalFormatter.format((double)four/(double)total));
            System.out.printf("Data starts with 5 %s of the time.%n", 
                    decimalFormatter.format((double)five/(double)total));
            System.out.printf("Data starts with 6 %s of the time.%n", 
                    decimalFormatter.format((double)six/(double)total));
            System.out.printf("Data starts with 7 %s of the time.%n", 
                    decimalFormatter.format((double)seven/(double)total));
            System.out.printf("Data starts with 8 %s of the time.%n", 
                    decimalFormatter.format((double)eight/(double)total));
            System.out.printf("Data starts with 9 %s of the time.%n", 
                    decimalFormatter.format((double)nine/(double)total));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }
    }
    
}
