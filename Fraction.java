/** Class used to represent a ration of two integers. Includes a mutator method
 *  that allows user to set the numerator and denominator both separately and
 *  together. Includes a method that returns the value of numerator divided by 
 *  denominator. Includes a method that outputs the value of the fraction in its 
 *  lowest terms (most simplified).  Equals method evaluates Fractions for equality
 *  in value. Main method allows user to create a Fraction and then loops 
 *  repeatedly until user wants to quit. Program allows user to enter a target
 *  fraction into an anonymous object and learn whether fractions are identical
 *  in value.
 */

package fraction;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 *
 * @author k8port
 */
public class Fraction {

    // instance variables
    private int numerator;
    private int denominator;
    
    // constructors
    /** No argument constructor. Initializes to 1/1 
     * 
     */
    public Fraction() {
        numerator = 1;
        denominator = 1;
    }
    
    /** Constructor that allows user to set numerator.
     *  Sets denominator to 1.
     *  @param numerator the top half of the fraction
     */
    public Fraction(int numerator) {
        this.numerator = numerator;
        denominator = 1;
    }
    
    /** Constructor that allows user to set numerator and denominator.
     *  @param numerator the top half of Fraction
     *  @param denominator the bottom half of Fraction
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    // accessor and mutator methods
    /** Method that allows user to set or change the numerator.
     * 
     * @param numerator the number to use as the numerator.
     */
    public void setNumerator(int numerator) {
        if (numerator < 1) {
            System.out.println("Fatal error.");
            System.exit(1);
        }
        else
            this.numerator = numerator;
    }
    
    /** Method to allow user to set or change the denominator.
     * @param denominator the number to use as the denominator.
     */
    public void setDenominator(int denominator) {
        if (denominator < 1) {
            System.out.println("Fatal error.");
            System.exit(1);
        }
        else
            this.denominator = denominator;
    }
    
    /**
     *  Method that allows user to set both numerator and denominator.
     *  Must be positive whole numbers.
     *  @param num the top half of Fraction
     *  @param den the bottom half of Fraction
     */
    public void setFraction(int num, int den) {
        if (num < 1 || den < 1) {
            System.out.println("Fatal error.");
            System.exit(1);
        }
        else {
            numerator = num;
            denominator = den;
        }    
    }
    
    /** Method to access private variable.   
     * @return the numerator
     */
    public int getNumerator() {return numerator;}
    
    /** Method to access private variable.
     * @return the denominator
     */
    public int getDenominator() {return denominator;}
    
    /** 
     *  Method to return Fraction expressed as numerator divided by denominator.
     *  @return the numerator divided by the denominator expressed as String percentage. 
     */
    public String getPercent()  {
        DecimalFormat decimalFormatter = new DecimalFormat("#0.0#%");
        return decimalFormatter.format((double)numerator/(double)denominator);
    }
    
    // other methods
    /** Method to return the largest common factor of the calling Fraction object.
     *  @param aFraction the Fraction object
     *  @return the largest factor of the two integers in the Fraction object.
     */
    private int getLCF() {
        int lcf = 1;
        if (numerator > denominator) {
            for (int i = denominator; i > 0; i--) {
                if (numerator % i == 0 && denominator % i == 0) 
                    return i;
            }
        }
        else {
            for (int j = numerator; j > 0; j--) {
                if (denominator % j == 0 && numerator % j == 0) 
                    return j;
            }
        }
        return lcf;
    }
    
    /** Method to output the fraction in its lowest terms.
     * @return Fraction in its lowest terms.
     */
    public Fraction getLowestTerms() {
        int lcf = this.getLCF();
        //System.out.println("Returning largest common factor: " + lcf);
        Fraction fraction = new Fraction(numerator/lcf, denominator/lcf);
        return fraction;
    }
    
    /** Method to evaluate if parameter fraction is equal to calling object.
     *  Evaluates both fractions as if they are in lowest terms.
     *  @param otherFraction The fraction we are evaluating against calling Fraction
     *  @return boolean true if equal
     */
    public boolean equals(Fraction otherFraction) {
        if (otherFraction == null) 
            return false;
        else {
            Fraction calling = this.getLowestTerms();
            Fraction param = otherFraction.getLowestTerms();
            return (calling.getNumerator() == param.getNumerator()) &&
                (calling.getDenominator() == param.getDenominator());
        }
    }
    
    /** Method to return String representation of Fraction object.
     * @return String representation of Fraction.
     */
    @Override
    public String toString() {
        return this.getNumerator() + "/" + this.getDenominator();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        StringTokenizer stringTokenizer;
        Scanner scanner = new Scanner(System.in);
        boolean enter; // true if continue entering Fractions
        String temp; // to hold user input for evaluation
        Fraction a; // the current fraction being evaluated
        
        do {            
            System.out.println("Enter a Fraction:");
            temp = scanner.nextLine();
            stringTokenizer = new StringTokenizer(temp, ",/ ");
            // construct the Fraction
            a = new Fraction(Integer.valueOf(stringTokenizer.nextToken()), Integer.valueOf(stringTokenizer.nextToken()));
            System.out.println("You entered " + a.toString());
            System.out.println("In its lowest terms: " + a.getLowestTerms());
            System.out.println("Now reset the denominator.");
            temp = scanner.nextLine();
            a.setDenominator(Integer.valueOf(temp));
            System.out.println("Fraction is now " + a);
            System.out.println("As a percentage it is " + a.getPercent());
            System.out.println("In lowest terms it is " + a.getLowestTerms());
            System.out.println("Now lets test for equality.");
            System.out.println("Enter another fraction to compare:");
            temp = scanner.nextLine();
            stringTokenizer = new StringTokenizer(temp, ",/ ");
            System.out.println("Equal? " + a.equals(new Fraction(Integer.valueOf
                                (stringTokenizer.nextToken()), Integer.valueOf
                                (stringTokenizer.nextToken()))));
            System.out.println("Would you like to keep using program? True or False.");
            enter = scanner.nextBoolean();
            temp = scanner.nextLine(); // clear
        } while (enter);
    }
}
