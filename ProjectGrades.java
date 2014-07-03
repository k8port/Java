/** A program that calculates the total grade for three classroom exercises as 
 *  a percentage and summarizes the scores in a table. 
 */

package projectgrades;

/**
 *
 * @author k8port
 */
import java.util.Scanner;
import java.text.DecimalFormat;

public class ProjectGrades {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        
        // instance variables
        String ex1, ex2, ex3;
        int score1, score2, score3, totScrPoss1, totScrPoss2, totScrPoss3;
        int totalScore, totalPoss;
        String str1 = "Exercise", str2 = "Score", str3 = "Total Possible";
        Scanner scan = new Scanner(System.in);
        DecimalFormat prcntForm = new DecimalFormat("00.00%");
        
        // gather input
        System.out.println("Enter 1st classroom exercise.");
        ex1 = scan.nextLine();
        System.out.println("Enter 2nd classroom exercise.");
        ex2 = scan.nextLine();
        System.out.println("Enter 3rd classroom exercise.");
        ex3 = scan.nextLine();
        
        System.out.println("Enter score received for exercise 1.");
        score1 = scan.nextInt();
        System.out.println("Enter score received for exercise 2.");
        score2 = scan.nextInt();
        System.out.println("Enter score received for exercise 3.");
        score3 = scan.nextInt();
        totalScore = score1 + score2 + score3;
        
        System.out.println("Enter total points possible for exercise 1.");
        totScrPoss1 = scan.nextInt();
        System.out.println("Enter total points possible for exercise 2.");
        totScrPoss2 = scan.nextInt();
        System.out.println("Enter total points possible for exercise 3.");
        totScrPoss3 = scan.nextInt();
        totalPoss = totScrPoss1 + totScrPoss2 + totScrPoss3;
        
        System.out.printf("%-30s %-10s %-10s%n", str1, str2, str3);
        System.out.printf("%-30s %-10d %-10d%n", ex1, score1, totScrPoss1);
        System.out.printf("%-30s %-10d %-10d%n", ex2, score2, totScrPoss2);
        System.out.printf("%-30s %-10d %-10d%n", ex3, score3, totScrPoss3);
        
        double percent = (double) totalScore / (double) totalPoss;
        String str4 = str3.substring(0, "Total".length());
        String str5 = prcntForm.format(percent);
        System.out.printf("%-30s %-10d %-10d%n", str4, totalScore, totalPoss);
        System.out.printf("Your %s is %d out of %d, or %s%n", str4, totalScore, 
                                                                totalPoss, str5);
    }
    
}
