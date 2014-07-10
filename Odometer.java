/** A class that creates an Odometer object to track fuel and mileage for a car.
 *  Class contains instance variables to track the miles driven and the fuel 
 *  efficiency in miles per gallon. Class includes mutator methods to reset the
 *  odometer to 0 miles, to set the fuel efficiency and to accept miles driven
 *  for a trip and add it to odometer total. Class includes an accessor method
 *  that returns the number of gallons of gas the car has consumed since the 
 *  odometer was last reset. See test program "OdometerTest.java" that creates
 *  several trips with different fuel efficiencies.
 */

package odometertest;

import java.util.Scanner;

/**
 *
 * @author k8port
 */
public class Odometer {
    
    // class variable
    private double miles; // the miles driven in a trip
    private double mpg;   // the fuel efficiency of the vehicle in miles per gallon
    
    // constructors
    /** No argument constructor sets miles driven to 0 and fuel efficiency to 
     *  average combined fuel efficiency for 2014 vehicles.
     */
    public Odometer() {
        miles = 0;
        mpg = 29.5;
    }
    
    // mutator and accessor methods
    /** No argument method to reset the odometer to 0.
     * 
     */
    public void resetZero() {miles = 0;};
    
    /** Method that allows user to set the fuel efficiency of a vehicle.
     *  Uses Scanner to get input from user instead of argument.
     */
    public void setMPG() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Set the fuel efficiency of your vehicle.");
        System.out.println("What is the combined (city/highway) fuel efficiency of the car?");
        mpg = scan.nextDouble();
        while (mpg < 10 || mpg > 150) {
            System.out.println("Error entering fuel efficiency. Please reenter.");
            mpg = scan.nextDouble();
        }
    }
    
    /** Method that allows user to input miles driven for a trip and adds it to
     *  the odometer total. Also tells user how much gas was used for these miles.
     */
    public void acceptMiles() {
        double trip;
        Scanner scan = new Scanner(System.in);
        System.out.println("How many miles were driven on this trip?");
        trip = scan.nextDouble();
        while (trip < 0) {
            System.out.println("You must enter a positive number or 0 if no trip was taken.");
            trip = scan.nextDouble();
        }
        miles += trip;
    }
    
    /** Method that allows user to request price of gas based on current odometer
     *  reading.
     *  @return the number of gallons of gas used since odometer was last set
     */
    public double getGallons() {return miles/mpg;}
    
    // other methods
    /** Method to test equality of Odometer objects.
     * @param other the other Odometer
     * @return true if objects are the same
     */
    public boolean equals(Odometer other) {
        return (mpg == other.mpg && miles == other.miles);
    }
    
    /** Method that returns String representation of Odometer object.
     *  @return String representing Odometer object.
     */
    @Override
    public String toString() {
        return miles + " miles driven at " + mpg + " miles per gallon.";
    }
}   

