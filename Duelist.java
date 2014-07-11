/** Program to simulate rounds of duels between three expert marksman, Aaron, 
 *  Bob and Charlie. Each man has a different probability of being able to hit
 *  their mark. Each round follows the following strategy:
 *      1. Each man takes a turn in this order: Aaron, Bob, Charlie.
 *      2. The man whose turn it is shoots at the best marksman based on probability.
 *      3. If a man is hit he is killed.
 *      4. Turns are taken until one shooter remains - The greatest marksman.
 *  
 */

package duelist;

import java.text.DecimalFormat;
/**
 *
 * @author k8port
 */
public class Duelist {
    
    // static variable
    public static int ROUNDS = 10000; // number of rounds 
    
    private String name; // shooter's name
    private Fraction2 probability; // the probability that shooter will hit
    private boolean alive; // true if still living
    
    public Duelist(String dueler, Fraction2 hit_ratio) {
        if (dueler == null || hit_ratio == null) {
            System.out.println("Fatal error.");
            System.exit(0);
        }
        else {
            name = dueler;
            probability = new Fraction2(hit_ratio);
            alive = true;
        }
    }
    
    // standard set and get methods
    /** 
     * Method to set Duelist name.
     * @param dueler the new name
     */
    public void setName(String dueler) {name = dueler;}
    
    /**
     * Method to set Duelist shooting probability.
     * @param fraction the new probability
     */
    public void setProbability(Fraction2 fraction) {
        probability = new Fraction2(fraction);
    }
    
    /**
     * Method to retrieve Duelers name.
     * @return name
     */
    public String getName() {return name;}
    
    /** 
     * Method to retrieve Duelist probability.
     * @return the probability of accuracy.
     */
    public Fraction2 getProbability() {return probability;}
    
    /**
     * Method that kills the Duelist, setting alive to false.
     */
    private void kill() {alive = false;}
    
    /** 
     * Method indicates if Duelist is still alive.
     * @return true if still living.
     */
    public boolean isAlive() {return alive;}
    
    /** 
     * Method that allows user to reset life.
     */
    public void wakeUp() {alive = true;} 
    /**
     * Method that allows Duelist to shoot at target using probability and
     * random number generation to determine if target is shot or not.
     * @param target the duelist being shot at
     */
    public void ShootAtTarget(Duelist target) {
        int shot = (int) (Math.random() * probability.getDenominator()) + 1;
        //System.out.println("shot = " + shot);
        if (shot > probability.getDenominator() - probability.getNumerator()) 
            target.kill();
    }
    
    
    
    /**
     * Method returns string representation of Duelist.
     * @return String representation of Duelist.
     */
    public String toString() {return name + ": " + probability 
                                + ". Alive? " + alive;}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Duelist a = new Duelist("Aaron", new Fraction2(1, 3));
        Duelist b = new Duelist("Brian", new Fraction2(1, 2));
        Duelist c = new Duelist("Charlie", new Fraction2(1, 1));
        Duelist winner = null;
        int aaron = 0, brian = 0, charlie = 0; //counts wins
        DecimalFormat decimalFormat = new DecimalFormat("#0.00%");
                
        for (int i = 0; i < ROUNDS; i++) {
            System.out.printf("Round %d!", i+1);
            //System.out.println("winner is " + winner);
            System.out.println("");
            
            while (winner == null) {
                // Aaron's turn 
                if (a.isAlive()) {
                    System.out.println("Aaron's turn.");
                    if (b.isAlive() && Double.valueOf(b.probability.getValue())  
                        >  Double.valueOf(c.probability.getValue()) || b.isAlive() 
                            && !c.isAlive()) {
                        
                        System.out.printf("%s is shooting at %s and has a %s chance of "
                                + "hitting.%n", a.getName(), b.getName(), 
                                    a.getProbability().toString());
                        a.ShootAtTarget(b);
                        if (b.isAlive()) 
                            System.out.printf("%s missed.%n", a.getName()); 
                        else 
                            System.out.printf("%s is dead!.%n", b.getName());
                    } // shooting at Brian end
                    else if (c.isAlive()) {
                        System.out.printf("%s is shooting at %s and has a %s chance of "
                                    + "hitting.%n", a.getName(), c.getName(), 
                                        a.getProbability().toString());
                        a.ShootAtTarget(c);
                        if (c.isAlive()) 
                            System.out.printf("%s missed.%n", a.getName());
                        else
                            System.out.printf("%s is dead!.%n", c.getName());
                    }  // shooting at Charlie end
                    else {
                        winner = new Duelist(a.getName(), a.getProbability());
                        System.out.println("Aaron wins this round.");
                    }
                    System.out.println("");
                } // end Aaron's turn
            
                // Brian's turn
                if (b.isAlive()) {
                    System.out.println("Brian's turn.");
                    if (c.isAlive() &&
                        Double.valueOf(c.probability.getValue()) > 
                        Double.valueOf(a.probability.getValue()) || c.isAlive()
                            && !a.isAlive()) {
                        System.out.printf("%s is shooting at %s and has a %s chance of "
                                + "hitting.%n", b.getName(), c.getName(), 
                                    b.getProbability().toString());
                        b.ShootAtTarget(c);
                        if (c.isAlive()) 
                            System.out.printf("%s missed.%n", b.getName()); 
                        else
                            System.out.printf("%s is dead!.%n", c.getName());
                    } // shooting at Charlie end
                    else if (a.isAlive()) {
                        System.out.printf("%s is shooting at %s and has a %s chance of "
                                    + "hitting.%n", b.getName(), a.getName(), 
                                        b.getProbability().toString());
                        b.ShootAtTarget(a);
                        if (a.isAlive()) 
                            System.out.printf("%s missed.%n", b.getName());
                        else
                            System.out.printf("%s is dead!.%n", a.getName());
                    }  // shooting at Aaron end
                    else {
                        winner = new Duelist(b.getName(), b.getProbability());
                        System.out.println("Brian wins this round.");
                    }
                    System.out.println("");
                } // end Brian's turn
                
                // Charlie's turn 
                if (c.isAlive()) {
                    System.out.println("Charlie's turn.");
                    if (b.isAlive() &&
                            Double.valueOf(b.probability.getValue()) > 
                            Double.valueOf(a.probability.getValue())
                            || b.isAlive() && !a.isAlive()) {
                        System.out.printf("%s is shooting at %s and has a %s chance of "
                                + "hitting.%n", c.getName(), b.getName(), 
                                    c.getProbability().toString());
                        c.ShootAtTarget(b);
                        if (b.isAlive()) 
                            System.out.printf("%s missed.%n",c.getName()); 
                        else
                            System.out.printf("%s is dead!.%n", b.getName());
                    } // shooting at Aaron end
                    else if (a.isAlive()) {
                        System.out.printf("%s is shooting at %s and has a %s chance of "
                                    + "hitting.%n", c.getName(), a.getName(), 
                                        c.getProbability().toString());
                        c.ShootAtTarget(a);
                        if (a.isAlive()) 
                            System.out.printf("%s missed.%n", c.getName());
                        else
                            System.out.printf("%s is dead!.%n", a.getName());
                    }  // shooting at Brian end
                    else {
                        winner = new Duelist(c.getName(), c.getProbability());
                        System.out.println("Charlie wins this round.");
                    }
                    System.out.println("");
                } // end Charlie's turn
                
            } // end while 
            if (winner.getName().equalsIgnoreCase("Aaron")) {
                    aaron++;
                    //System.out.println("aaron won");
            }
            if (winner.getName().equalsIgnoreCase("Brian")){
                brian++;
                //System.out.println("brian won");
            }
            if (winner.getName().equalsIgnoreCase("Charlie")) {
                charlie++;
                //System.out.println("Charlie won");    
            }
            winner = null;
            a.wakeUp();
            b.wakeUp();
            c.wakeUp();
        } // end for loop round
         
        double aPercent = (double) aaron / (double) ROUNDS;
        double bPercent = (double) brian / (double) ROUNDS;
        double cPercent = (double) charlie / (double) ROUNDS;
        System.out.printf("%s won %s of the time.%n", a.getName(), decimalFormat.format(aPercent));
        System.out.printf("%s won %s of the time.%n", b.getName(), decimalFormat.format(bPercent));
        System.out.printf("%s won %s of the time.%n", c.getName(), decimalFormat.format(cPercent));
    
    } // end main
    
} // end class
