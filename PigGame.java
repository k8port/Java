/** A program that simulates 'Pig', a simple 2-player dice game. 
 *  Rules of the game:
 *      Players take turns. On each turn,  the player rolls the die. 
 *      1-If the player rolls a 1, they get no new points and their turn ends.
 *      2-If the player rolls a 2 through 6, they have 2 choices:
 *          ROLL AGAIN or
 *          HOLD. At this point, the sum of all rolls is added to the player's
 *              score and their turn ends.
 *      3-The first player to reach 100 points wins.
 *  The program designates one player as the user and the other player as the
 *  computer. On the user's turn the program shows both player's scores and
 *  each player's previous roll. The program allows the user to choose 'r' for
 *  roll and 'h' for hold.  On the computer's turn the program continues to roll
 *  until it has accumulated 20 points or they roll a 1.
 */

package piggame;

/**
 *
 * @author k8port
 */
import java.util.Scanner;

public class PigGame {

    private static final String HOLD = "h";
    private static final String ROLL = "r";
    private static final int DIE = 6;   // the 6 sides of the die
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // variable declarations
        Scanner scan = new Scanner(System.in);
        int dieRoll =  0;   // the current roll of the dice
        int turn = 0;  // the points for this tirm
        int playerGame = 0, puterGame = 0; // cumulative points of the whole game
        boolean play = true, puter = false;  // true if it is users turn
        String temp;   // for keyboard input
        int playerLast = 0, puterLast = 0; // displays the last roll
        boolean winner = false; // if there is a winner
        
        // Play the game.
        System.out.println("Let's play Pig.");
        do {        
            // player's turn
            while (play) {
                if (playerLast > 0 && puterLast > 0) {
                    System.out.printf("Your last roll: %d%n", playerLast);
                    System.out.printf("My last roll: %d%n", puterLast);
                    System.out.println("");
                }
                dieRoll = (int)(Math.random() * DIE + 1);
                switch (dieRoll) {
                    case 1: 
                        System.out.println("You rolled a 1. My turn.");
                        play = false;
                        puter = true;
                        playerLast = 1;
                        turn = 0;
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        turn += dieRoll;
                        System.out.printf("You rolled a %d. Would you like to hold"
                                + " or roll? Press \'r\' to roll and \'h\' to hold."
                                + "%n", dieRoll);
                        System.out.printf("Your turn points are %d.%n", turn);
                        temp = scan.nextLine();
                        if (temp.equalsIgnoreCase(HOLD)) {
                            playerGame += turn;
                            playerLast = turn;
                            turn = 0;
                            System.out.println("You are holding.");
                            play = false;
                            puter = true;
                        }
                        break;
                    default:
                        System.out.println("Program error.");
                        System.exit(0);
                        break;
                } // end switch
            } // end player turn while
            System.out.println("");
            
            // check to see if player has won
            if (playerGame >= 100) {
                winner = true;
                puter = false;
            }
            
            while (puter) {
                //System.out.println("Inside my turn.");
                dieRoll = (int)(Math.random() * DIE + 1);  
                switch (dieRoll) {
                    case 1: 
                            System.out.println("I rolled a 1. Your turn.");
                            play = true;
                            puterLast = 1;
                            puter = false;
                            turn = 0;
                            break;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            turn += dieRoll;
                            System.out.printf("I rolled a %d.%n", dieRoll);
                            if (turn >= 20) {
                                //System.out.println("inside if >= 20");
                                puterGame += turn;
                                puterLast = turn;
                                turn = 0;
                                puter = false;
                                play = true;
                            }                         
                            break;
                        default:
                            System.out.println("Program error.");
                            System.exit(0);
                            break;
                }   // end switch
            }  // ends puter turn while   
            //System.out.println("Outside the end of computer turn.");
            System.out.println("");
            if (playerGame >= 100 || puterGame >= 100)
                winner = true;
        } while (!winner);   // no winner yet keep playing
        
        if (playerGame >= 100) {
            System.out.printf("You win with %d points.%n", playerGame);
            System.out.printf("I had %d points.%n", puterGame);
        }    
        else {
            System.out.printf("I win with %d points.%n", puterGame);
            System.out.printf("You had %d points.%n", playerGame);
        }
    } // end main
    
} // end class
