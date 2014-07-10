/** Class used to represent a ration of two integers. Includes a mutator method
 *  that allows user to set the numerator and denominator. Includes a method
 *  that returns the value of numerator divided by denominator. Includes a 
 *  method that outputs the value of the fraction in its lowest terms (most
 *  simplified).  Class that uses object called "MakeFractions.java".
 */

package fraction;

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
     */
    public Fraction(int numerator) {
        this.numerator = numerator;
        denominator = 1;
    }
    
    /** Constructor that allows user to set numerator and denominator.
     * 
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
    
    /** Method to access private variable.   
     * @return the numerator
     */
    public int getNumerator() {return numerator;}
    
    /** Method to access private variable.
     * @return the denominator
     */
    public int getDenominator() {return denominator;}
    
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
    
    /** Method to evaluate if fraction is equal to calling object.
     *  @pre The calling object and the parameter object have been reduced to 
     *          lowest terms,
     *  @param otherFraction The fraction we are evaluating against this
     *  @return boolean true if equal
     */
    public boolean equals(Fraction otherFraction) {
        return (numerator == otherFraction.getNumerator()) &&
                (otherFraction.getDenominator() == denominator);
    }
    
    /** Method to return String representation of Fraction object.
     * @return String representation of Fraction.
     */
    @Override
    public String toString() {
        return this.getNumerator() + "/" + this.getDenominator();
    }
}
