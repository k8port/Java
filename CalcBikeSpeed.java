/**
 * Calculates the speed of a bicycle for a gear size of 100 inches and
 * a cadence of 90 rpm.
 */

package calcbikespeed;

/**
 *
 * @author k8port
 */
public class CalcBikeSpeed {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // declare variables
        double speed; // miles per hour
        int gear = 100; // gear size in inches
        int cadence = 90; // pedal revolutions per minute
        
        // calculate speed
        speed = (gear * Math.PI * 1 * 1 * cadence * 60) / 12 * 5280 * 1;
        
        System.out.println("You will travel at a speed of " + speed + " miles per hour.");
        
    }
    
}
