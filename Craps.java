/** A program to simulate a game of craps. This program does not require user
 *  input and instead rolls the dice and plays 10,000 games. The number of
 *  wins and the number of losses are added and probability of winning and 
 *  losing is output.
 *  Rules of craps: 
 *     Two six-sided dice are rolled. The first roll is called the "come out 
 *      roll". If you roll 7 or 11 you automatically win, but if you roll 2,
 *      3, or 12 you automatically lose.  Any other number rolled (4, 5, 6, 8
 *      9, 10) becomes "the point". You will continue to roll the dice until
 *      either the number 7 or "the point" is rolled. If you roll "the point"
 *      than you win, but if you roll a 7 first, you lose.
 */

package craps;

/**
 *
 * @author k8port
 */
import java.text.DecimalFormat;

public class Craps {
    
    // number of rounds program plays
    private static final int GAMES = 10000;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // variable declarations
        /** The 2 dice and their sum*/
        int die1, die2; 
        /** The sum of the die in each round */
        int round1, round2;
        /** Wins and losses count start at 0 */
        int wins=0, losses=0;
        /** Object used to format percentages */
        DecimalFormat formatter = new DecimalFormat("00.00%");
        /** A flag to determine whether to roll again */
        boolean roll;
        
        // Let's play!
        System.out.println("Let's play craps!");
        for (int i = 1; i <= GAMES; i++) {
            System.out.println("");
            System.out.printf("Game %d, Round 1:%n", i);
            die1 = (int) (Math.random() * 6) + 1;
            die2 = (int) (Math.random() * 6) + 1;
            
            round1 = die1 + die2;
            System.out.printf("You rolled a %d and a %d.%n", die1, die2);
            switch (round1) {
                case 2:
                case 3:
                case 12:
                    System.out.printf("You rolled %d!%n", round1);
                    System.out.println("You lose.");
                    losses++;
                    break;
                case 7:
                case 11:
                    System.out.printf("You rolled %d!%n", round1);
                    System.out.println("You win!");
                    wins++;
                    break;
                default:
                    System.out.printf("You rolled %d!%n", round1);
                    System.out.println("This is the point for the next round.");
                    System.out.println("Round 2: ");
                    roll = true; // set roll again flag to true 
                    do {
                        die1 = (int) (Math.random() * 6) + 1;
                        die2 = (int) (Math.random() * 6) + 1;
                        round2 = die1 + die2;
                        System.out.printf("You rolled a %d and a %d.%n", die1, die2);
                        // for debug
                        /*System.out.printf("Round 1 roll: %d. Round 2 roll: %d.%n", round1, round2);
                        System.out.println("Round 1 roll same as round 2? " + (round1 == round2));*/
                        if (round2 == round1 || round2 == 7)
                            roll = false;
                    } while (roll);
                    switch (round2) {
                        case 4:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                            System.out.printf("You rolled %d!%n", round2);
                            System.out.println("You rolled the point!");
                            System.out.println("You win!");
                            wins++;
                            break;
                        case 7:
                            System.out.println("You rolled 7.");
                            System.out.println("You lose.");
                            losses++;
                            break;
                    default:
                            System.out.println("Program error");
                            break;
                    }  // end round 2 switch 
                    break;
            } // end round 1 switch statement
        }  // end of GAME
        
        // calculate probability
        System.out.printf("%nYou won %d times and lost %d times.%n", wins, losses);
        double probable_wins = (double) wins / (double) GAMES; 
        double probable_losses = (double) losses/(double) GAMES;
        
        String win = formatter.format(probable_wins);
        String lose = formatter.format(probable_losses);
        System.out.println("You won " + win + " of the time.");
        System.out.println("You lost " + lose + " of the time.");
        if (probable_wins > probable_losses) 
            System.out.println("You are a winner!");
        else 
            System.out.println("You are a loser!");
         
        
    } // end main
    
}
