/** A program that calculates the total grade for N classroom exercises as 
 *  a percentage and summarizes the scores in a table. 
 */

package projectgrades2;

/**
 *
 * @author k8port
 */
import java.util.Scanner;
import java.text.DecimalFormat;

public class ProjectGrades2 {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        
        // instance variables
        double score, possScore; // points earned and points possible
        double totalScore = 0, totalPoss = 0; // cumulative totals
        int N; // number of exercises
        Scanner scan = new Scanner(System.in);
        DecimalFormat percentForm = new DecimalFormat("#0.00%");
        
        // gather input
        System.out.println("How many exercises to input?");
        N = scan.nextInt();
        
        for (int i = 1; i <= N; i++) {
            System.out.printf("Score received for exercise %d:%n", i);
            score = scan.nextDouble();
            totalScore += score;
            System.out.printf("Total points possible for exercise %d:%n", i);
            possScore = scan.nextDouble();
            totalPoss += possScore;
            System.out.printf("Exercise %-10d %-10f %-10f%n", i, score, possScore);
        }
        
     
        double percent =  totalScore / totalPoss;
        System.out.println("Your total is " + totalScore + " out of " + totalPoss 
                + " or " + percentForm.format(percent));
    }
    
}
