/** Program that tracks sales of a Hot dog stand chain. 
 */

package hotdogstand;

import java.util.Scanner;
/**
 *
 * @author k8port
 */
public class HotDogStand {
    
    // class variables
    private int standID;   // each stand has its own ID
    private int dogSold;    // number of dogs sold that day
    
    // static variables
    private static int ALLSOLD = 0; // number of hot dogs sold by all stands
    
    // Constructor
    /** Constructor for HotDogStand object allows user to initialize standID 
     *  and dogSold.
     *  @param id the individual stand ID must be 3 digits greater than 0 
     *  @param dogs the number of dogs sold that day must be positive or 0
     */
    public HotDogStand(int id, int dogs) {
        if (id < 001 || id > 999 || dogs < 0) {
            System.out.println("Fatal error.");
            System.exit(1);
        } 
        standID = id;
        dogSold = dogs;
        ALLSOLD += dogSold;
    }
    
    // accessor and mutator methods
    /** 
     * Method that increments dogSold by 1. 
     * Tracks hot dogs sold by stand that day.
     */
    public void justSold() {
        dogSold++;
        ALLSOLD++;
    }
    
    /**
     *  Method that returns number of hot dog sold for the day.
     *  @return the number of hot dogs sold at stand that day.
     */
    public int numberSold() {return dogSold;}
    
    /**
     *  Method that returns id number of the current stand.
     *  @return id number of stand
     */
    public int getID() {return standID;}
    /**
     *  Method that returns the number of hot dogs sold by all stands.
     *  @return number of hot dogs sold at all stands for the day.
     */
    public static int getALLSOLD() {return ALLSOLD;}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        // stand id and number of dogs sold
        int id1, id2, id3, dogs1, dogs2, dogs3;  
        char temp;      // to register user input
        
        System.out.println("Welcome to Buddy Hot Dog Sales System.");
        System.out.println("Please enter your 3 digit hot dog stand number.");
        
        id1 = scanner.nextInt();
        System.out.println("Have you sold any dogs today? Enter number if yes, 0 "
                + " if no.");
        dogs1 = scanner.nextInt();
        
        // create HotDogStand
        HotDogStand stand1 = new HotDogStand(id1, dogs1-1);
        
        do {
            stand1.justSold();
            System.out.println("Press 'x' to sell a hot dog.");
            System.out.println("Press 'q' to quit.");
            temp = scanner.next().charAt(0);
        } while (temp != 'q');    
        
        // for stand 2
        System.out.println("Please enter your 3 digit hot dog stand number.");
        id2 = scanner.nextInt();
        System.out.println("Have you sold any dogs today? Enter number if yes, 0 "
                + " if no.");
        dogs2 = scanner.nextInt();
        
        // create HotDogStand
        HotDogStand stand2 = new HotDogStand(id2, dogs2-1);
        
        do {
            stand2.justSold();
            System.out.println("Press 'x' to sell a hot dog.");
            System.out.println("Press 'q' to quit.");
            temp = scanner.next().charAt(0);
        } while (temp != 'q'); 
        
        
        // stand 3
        System.out.println("Please enter your 3 digit hot dog stand number.");
        id3 = scanner.nextInt();
        System.out.println("Have you sold any dogs today? Enter number if yes, 0 "
                + " if no.");
        dogs3 = scanner.nextInt();
        
        // create HotDogStand
        HotDogStand stand3 = new HotDogStand(id3, dogs3-1);
        
        do {
            stand1.justSold();
            System.out.println("Press 'x' to sell a hot dog.");
            System.out.println("Press 'q' to quit.");
            temp = scanner.next().charAt(0);
        } while (temp != 'q'); 
        
        System.out.printf("First stand %d sold %d dogs today.%n", 
                stand1.getID(), stand1.numberSold());
        System.out.printf("Second stand %d sold %d dogs today.%n", 
                stand2.getID(), stand2.numberSold());
        System.out.printf("Third stand %d sold %d dogs today.%n", 
                stand3.getID(), stand3.numberSold());
        System.out.printf("Altoghether the stands sold %d dogs today.%n",
                HotDogStand.getALLSOLD());
    }
    
}
