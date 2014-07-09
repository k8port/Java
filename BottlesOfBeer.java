/** Program that uses the class BeerSong to sing the song "Bottles of Beer".
 * 
 */
package bottlesofbeer;

/**
 *
 * @author Kate
 */
public class BottlesOfBeer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BeerSong beersong = new BeerSong(99);
        beersong.printSong();
    }
}
