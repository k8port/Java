/** 
 *  Program that reads in the average monthly rainfall for a city for each 
 *  month of the year and then reads in the actual monthly rainfall for each 
 *  of the previous 12 months. Program then outputs a formatted table to show
 *  deviations from the average. Program uses an object called RainfallData to
 *  store the average rainfall, the actual rainfall and the deviation (whether
 *  it be positive or negative). The program contains a method display() which
 *  outputs a table of the data.
 */

package rainfalldata;

import java.util.Scanner;

/**
 *
 * @author k8port
 */
public class RainfallData {
    
    enum Months {JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, 
                    SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER};
    
    // class variables
    Months[] months; // an array to hold the enum type
    String city; // name of city
    private double[] averages;  // array to hold average rainfall per month
    private double[] actuals;   // array to hold actual rainfall per month
    private double[] deviation; // array to hold amonth of deviation from actual to average
    
    /**
     * Constructs an RainfallData object which holds average and actual rainfall
     * as well as deviations. Uses user input to gather data.
     */
    public RainfallData() {
        Scanner kbd = new Scanner(System.in);
        months = Months.values();
        System.out.println("Enter city name: ");
        city = kbd.nextLine();
        fillAverage(kbd);
        fillActual(kbd);
        fillDeviation();
    }
    
    /**
     * Method to fill averages[] with average monthly average rainfall amounts.
     * @param scanner the object used to gather data from console
     * @param month the array to hold the month values
     */
    private void fillAverage(Scanner scanner) {
        averages = new double[months.length];
        for (int i = 1; i <= months.length; i++) {
            System.out.println("Enter " + city + " average rainfall for " 
                    + months[i-1] + ":");
            averages[i-1] = scanner.nextDouble();
        }
        System.out.println("");
    }
    
    /**
     * Method to fill actuals[] with actual monthly rainfall amounts.
     * @param scanner the I/O console object
     * @param month the array to hold month values
     */
    private void fillActual(Scanner scanner) {
        actuals = new double[months.length];
        System.out.println("Enter the current month number:");
        int response = scanner.nextInt();
        System.out.println("");
        for (int i = response-1; i > 0; i--) {
            System.out.println("Enter " + city + " actual rainfall for " 
                    + months[i-1] + ":");
            actuals[i-1] = scanner.nextDouble();
        }
        for (int j = months.length; j >= response; j--) {
            System.out.println("Enter " + city + " actual rainfall for " 
                    + months[j-1] + ":");
            actuals[j-1] = scanner.nextDouble();
        }
        System.out.println("");
    }
    
    /**
     * Method to fill deviation[] with difference between average and actual
     * monthly rainfall. Negative amounts indicate actual rainfall was less 
     * than average. Positive amounts indicate actual rainfall was greater 
     * than average.
     * @param month the array to hold month values
     */
    private void fillDeviation(){
        deviation = new double[months.length];
        for (int i = 0; i < months.length; i++) {
            deviation[i] = actuals[i] - averages[i];
        }
    }
    
    /**
     * Method that outputs a table showing rainfall data. 
     */
    public void display() {
        String one = "Average";
        String two = "Actual";
        String three = "Deviation";
        System.out.println(city.toUpperCase());
        for (int i = 0; i < months.length; i++) {
            System.out.printf("%-13s%n",months[i].toString());
            System.out.printf("%5s %5s %5s%n", one, two, three);
            System.out.printf("%5.2f   %5.2f    %5.2f", averages[i], 
                    actuals[i], deviation[i]);
            System.out.println("");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RainfallData yourCity = new RainfallData();
        yourCity.display();
    }
    
}




