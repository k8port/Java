/** A program that calculates ideal body weight given someone's height.
 */

package idealbodyweight;

/**
 *
 * @author k8port
 */
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class IdealBodyWeight {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // declare variables
        String name;
        int feet, inches;  // for a person's height
        Scanner tenneile = new Scanner(System.in);
        Scanner captain = new Scanner(System.in);
        
        // gather user info
        System.out.println("Please enter your height in first in feet and then "
                + "in inches.\nPut a space between the two variables.");
        feet = tenneile.nextInt();
        inches = tenneile.nextInt();
        
        // calculate ideal weight   
        int ideal = 110 + ((feet - 5) * 110) + (inches * 5);
        // output result
        System.out.println("Your ideal body weight is: " + ideal);
        
        System.out.println("Now let's gather info from the database file.");
        try {
            captain = new Scanner(new FileInputStream("heights.txt"));
            name = captain.nextLine();
            feet = captain.nextInt();
            inches = captain.nextInt();
            ideal = 110 + ((feet - 5) * 110) + (inches * 5);
            System.out.printf("%s's ideal body weight at %d feet and "
                        + "%d inches is %d.%n", name, feet, inches, ideal);
            String clear = captain.nextLine();
            name = captain.nextLine();
            feet = captain.nextInt();
            inches = captain.nextInt();
            ideal = 110 + ((feet - 5) * 110) + (inches * 5);
            System.out.printf("%s's ideal body weight at %d feet and "
                        + "%d inches is %d.%n", name, feet, inches, ideal);  
            clear = captain.nextLine();
            name = captain.nextLine();
            feet = captain.nextInt();
            inches = captain.nextInt();
            ideal = 110 + ((feet - 5) * 110) + (inches * 5);
            System.out.printf("%s's ideal body weight at %d feet and "
                        + "%d inches is %d.%n", name, feet, inches, ideal);  
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }
       
    }
    
}
