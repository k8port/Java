package fraction;

/** Program that tests Fraction.java.
 * 
 */

/**
 *
 * @author k8port
 */

public class MakeFractions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // comments indicate portion of class being tested
        Fraction a = new Fraction(); // no-arg constructor
        System.out.println("No arg constructor: " + a); // toString, no-arg constructor
        Fraction b = new Fraction(25); // constructor with numerator param
        System.out.println("Second constructor(sets numerator): " + b); // toString, 2nd constructor
        Fraction c = new Fraction(18, 136); // constructor with both num and den params
        System.out.println("Third constructor(sets numerator and denominator): " + c);
        System.out.println("");
        
        // setDenominator()
        b.setDenominator(65); 
        System.out.println("setDenominator() method changes second fraction to: " + b);
        System.out.println("");
        
        // setNumerator()
        b.setNumerator(39); 
        System.out.println("setNumerator() method changes second fraction again to: " + b);
        System.out.println("");
        
        // getNumerator() and getDenominator()
        System.out.printf("Put another way the second fraction is %d/%d.%n", b.getNumerator(), b.getDenominator());
        System.out.printf("The third fraction is %d/%d.%n", c.getNumerator(), c.getDenominator());
        System.out.println("");
         
        // getLCF()
        System.out.print("In simpler terms: ");
        System.out.print(b.getLowestTerms());
        System.out.println(" and " + c.getLowestTerms());
        System.out.println("");
        
        // equals
        System.out.println("True or false: fractions are equal?");
        System.out.println(c.equals(b));
        
    }
        
    
}
