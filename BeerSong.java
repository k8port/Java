package bottlesofbeer;

/** A class that defines the  song "99 Bottles of Beer".
 * 
 */

/**
 *
 * @author Kate
 */
public class BeerSong {
   
    // instance variables
    private int bottleNumber;
    
    // constructor
    /** Constructor for BeerSong
     * 
     * @param numOfBottles the number of bottles indicates verse to start song
     */
    public BeerSong(int numOfBottles) {
        if (numOfBottles > 99)
            bottleNumber = 99;
        else if (numOfBottles < 0)
            bottleNumber = 0;
        else
            bottleNumber = numOfBottles;
    }
    
    // methods
    /** Prints out all verses of the song beginning with first verse.
     * 
     */
    public void printSong() {
        while (bottleNumber  > 0) {
            System.out.printf("%d bottles of beer on the wall,%n", bottleNumber);
            System.out.printf("%d bottles of beer,%n", bottleNumber);
            System.out.println("Take one down, pass it around,");
            System.out.printf("%d bottles of beer on the wall.%n", bottleNumber);
            System.out.println("");
            bottleNumber--;
        }
    }
}
