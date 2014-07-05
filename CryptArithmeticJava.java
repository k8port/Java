/** A program that finds the right decimal digit values (0 - 9) of the letters 
 *  T, O, G and D so that TOO + TOO + TOO + TOO = GOOD. The simplest technique
 *  uses nested loops to test a unique value for each letter.
 */

package cryptarithmetic.java;

/**
 *
 * @author k8port
 */
public class CryptArithmeticJava {

    /**
     * @param args the command line arguments
     */
    private static final int TOO = 4; // #of distinct letters
    private static final int DECIMAL = 10; // # of distinct decimal digits (0-9) 
    
    public static void main(String[] args) {
        
        int T, O, G, D; // 4 letters will have integer values
        int solutions = 0; // number of possible solutions
        
        for (int i = 0; i < DECIMAL; i++) {
            T = i;
            for (int j = 0; j < DECIMAL; j++) {
                O = j;
                for (int k = 0; k < DECIMAL; k++) {
                    G = k;
                    for (int l = 0; l < DECIMAL; l++) {
                        D = l;
                        if ((((T+(O*2))*TOO) == (G+(O*2)+D)) &&
                                (T != O && T != G && T != D && O != G &&
                                O != D && G != D)) {
                            solutions++;
                            System.out.printf("Value of \'T\' is %d. ", T);
                            System.out.printf("Value of \'O\' is %d. ", O);
                            System.out.printf("Value of \'G\' is %d. ", G);
                            System.out.printf("Value of \'D\' is %d.%n", D);
                        } // end of if 
                    } // end of for loop l
                } // end of for loop k
             } // end of for loop j
        } // end of for loop i
        System.out.printf("There are %d different solutions.%n", solutions);
    }
    
}
