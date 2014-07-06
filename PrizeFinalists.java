/** Program that picks 3 random prize winners from a pool of 50 entries for the
 *  outdoor backyard barbecue from the Thrifty Mart annual sweepstakes. 
 *  
 */

package prizefinalists;

/**
 *
 * @author k8port
 */
public class PrizeFinalists {
    
    private static final int POOL = 30; // the size of the entry pool
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int win1, win2, win3; // the three winning numbers
        boolean identical = true; // flag to indicate if winning numbers match
        
        win1 = (int)(Math.random() * POOL + 1);
        do {
            win2 = (int)(Math.random() * POOL + 1);           
            win3 = (int)(Math.random() * POOL + 1);
            if (win3 != win2 && win3 != win1 && win2 != win1) 
                identical = false;
        } while (identical);
        
        System.out.printf("Numbers %d, %d, and %d come on down! You are the"
                + " winners of the brand%nnew Thrifty Mart backyard barbecue!%n",
                win1, win2, win3);
    }
    
}
