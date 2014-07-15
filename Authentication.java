/** Program that simulates the authentication process and requires
 *  a 5 digit pin entry. The system guards against "shoulder surfing" attacks, 
 *  where a thief looks over a victim's shoulder while they are entering their
 *  pin number. The system uses a randomized challenge-response where digits 
 *  are entered based on a code displayed to the screen. The code changes at
 *  each login. An array is used to assign random numbers between 0 and 9 and 
 *  then output to the screen. The user enters the random numbers that 
 *  corresponds to their pin. If a match is found the login is successful.
 */

package hanumaninternational;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.StringTokenizer;

/**
 *
 * @author k8port
 */
public class Authentication {
    
    private static final int DECIMAL = 10; // number of decimal digits 0-9
    private static final int PINLENGTH = 5; // length of the pin
    private static final boolean DEBUG = false; // true if in debug mode
    
    // class variables
    Scanner kbd; // input from console
    Scanner fileInput; // input from file
    PrintWriter pw; // output to file
    StringTokenizer st; // to read lines in database file and separate userID from pin
    
    private int[] code; // the random digits assigned to numbers 0-9 for encrypting pin
    private int[] pin;  // a 5-digit array of ints representing the pin
    String userID; // a string of letters and numbers between 8-12 characters representing user
    

    /** Constructor for Authentication(userId/pin) object. Requests data 
     *  from the user.
     */
    public Authentication() {
        if (DEBUG) {
            System.out.println("inside constructor");
        }
        kbd = new Scanner(System.in);
        pin = new int[PINLENGTH];
        do {
            System.out.println("\nEnter a username of 8-12 characters length"
                + " and comprised \nonly of letters and/or digits.");
            userID = kbd.nextLine(); // read userID from console
            System.out.println("Lets pick a pin. Enter pin:");   
            pin = getPinArray(kbd.nextInt());  // convert pin into array          
        } while (!pinOK() || !uidOK());   // check that userID and pin follow formats   
        code = generateCode();  // assign code to encode pin entry
        writeToFile(); // store newly created user data in the database file
    }
    
    /** 
     * Method to turn 5 digit integer value into an array holding 5 digits.
     * @param xPin the 5 digit integer value
     * @return an array of length 5 holding each of the 5 digits
     */
    private int[] getPinArray(int xPin) {
        if (DEBUG) {
            System.out.println("\ninside getPinArray()");
        }
        int[] x = new int[pin.length];
        for (int j = pin.length; j > 0; j--) {
            x[j-1] = xPin % 10;
            xPin /= 10;
        }
        if (DEBUG) {
            System.out.println("printing return value:");
            for (int i = 0; i < x.length; i++) 
                System.out.print("index[" + i + "]: " + x[i] + " ");
            System.out.println("");
        }
        return x;
    }
    
    /** Method that returns true if userId matches format. Must be
     *  between 8-12 characters and be a letter, digit or symbol
     *  @return true if userID matches format
     */
    private boolean uidOK() {
        if (DEBUG) {
            System.out.println("inside uidOK()");
        }
        if ((userID.length() > 12) || (userID.length() < 8)) {
            // clear
            String clear = kbd.nextLine();
            System.out.println("Incorrect userID - keep between 8 and 12 characters.");
            return false;
        }
        for (int i = 0; i < userID.length(); i++) {
                if (Character.isWhitespace(userID.charAt(i))) {
                    System.out.println("Incorrect userID. Please use"
                            + " only letters and/or digits.");
                    return false;
                }
        }
        return true;
    }
    
    /** Method that returns true is pin matches format. Must be 5 digits
     *  long.
     *  @return true if pin matches format
     */
    private boolean pinOK() {
        if (DEBUG) {
            System.out.println("inside pinOK()");
        }
        if (pin.length != 5) {
            System.out.println("Error: Pin must be 5 digits long.");
            return false;
        }
        return true;
    }
    
    /** Method that generates a code for each of the decimal digits. 
     *  The digit at index i is the code number for digit i so the user
     *  will enter the code instead of the actual pin in an attempt to
     *  prevent "shoulder surfing".
     *  @return an array containing the code
     */
    private int[] generateCode() {
        if (DEBUG) {
            System.out.println("\ninside generateCode()");
        }
        int[] codedigs = new int[DECIMAL];
        for (int i = 0; i < DECIMAL; i++) 
            codedigs[i] = (int) (Math.random() * 3) + 1; 
        if (DEBUG) {
            System.out.println("printing return value:");
            for (int i = 0; i < codedigs.length; i++) 
                System.out.print("index[" + i + "]: " + codedigs[i] + " ");
            System.out.println("");
        }
        return codedigs;
    }
    
    /**
     * Method that writes ID and pin to file.
     */
    private void writeToFile() {
        if (DEBUG) {
            System.out.println("inside writeToFile");
        }
        try {
            // checks to see if file already exists
            pw = new PrintWriter(new FileOutputStream("UserDB.txt", true)); 
        } catch (FileNotFoundException e) {
            System.out.println("Error: cannot access database.");
            System.exit(0);
        }
        pw.printf("%20s ", userID);
        for (int i = 0; i < pin.length; i++) 
            pw.printf("%d", pin[i]);
        pw.println();
        pw.close();
    }
    
    /**
     * Method that opens up database file gather input.
     */
    private void readFromFile() {
        if (DEBUG) {
            System.out.println("inside readFromFile()");
        }
        try {
            fileInput = new Scanner(new FileInputStream("UserDB.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Error: cannot access database");
            System.exit(1);
        }
    }
    
    /**
     * Method that matches user to record in database file.
     * @return the encoded pin associated with the record if user match found
     */
    private int[] userMatch(String id) {
        if (DEBUG) {
            System.out.println("\ninside userMatch");
        }
        while (fileInput.hasNextLine()) {
            st = new StringTokenizer(fileInput.nextLine());
            if (st.nextToken().equals(id)) {
                System.out.println("Matched userIDs\n");
                return encodePin(Integer.valueOf(st.nextToken()));
            }
        }
        return null;
    }
    
    /**
     * Method that attempts to match 5 digit pin arrays after userID is matched.
     * @return true if pins match
     */
    private boolean pinMatch(int[] temp, int[] x) {
        if (DEBUG) {
            System.out.println("\ninside pinMatch()");
        }
        if (x == null)
            return false;
        for (int i = 0; i < pin.length; i++) {
            if (DEBUG) {
                System.out.println("Test match: temp[" + i + "]: " + temp[i] +
                        " and x[" + i +"]: " + x[i]);
            }
            if (temp[i] != x[i])
                return false;
        }
        if (DEBUG) {
            System.out.println("return true");
        }
        return true;
    }
    
    /**
     * Method to translate pin code. Returns an array giving code for
     * user's pin.
     */
    private int[] encodePin(int xPin) {
        if (DEBUG) {
            System.out.println("inside encodePin()");   
        }
        int[] x = getPinArray(xPin);        
        int[] pincode = new int[pin.length];
        for (int i = 0; i < pin.length; i++) 
            pincode[i] = code[x[i]];
        if (DEBUG) {
            System.out.println("printing return value:");
            for (int i = 0; i < pincode.length; i++) 
                System.out.print("index[" + i + "]: " + pincode[i] + " ");
            System.out.println("");
        }
        return pincode;
    }
    
    /** 
     * Method to display the pin code so that user can login with code.
     */
    private void displayCode() {
        System.out.println("\nDisplaying code:");
        for (int i = 0; i < DECIMAL; i++) 
            System.out.print(i + " ");
        System.out.println("");
        for (int j = 0; j < DECIMAL; j++) 
            System.out.print(code[j] + " ");
        System.out.println("");
    }
    
        /**
     * Method prompting user to login with pin using code displayed on screen.
     * @return the encoded pin contained in an array.
     */
    private int[] getPin() {
        if (DEBUG) {
           System.out.println("\ninside getPin()");
        }
        displayCode();
        System.out.println("\nEnter your pin using the code displayed instead"
                + "\nof actual digits.");
        return getPinArray(kbd.nextInt());
    }
    
    /**
     * Method prompting user to login with userID
     * @return the login used
     */
    private String getLoginID() {
        if (DEBUG) {
            System.out.println("\ninside getLoginID()");
        }
        kbd = new Scanner(System.in);
        System.out.println("\nEnter your user ID:");
        return kbd.nextLine();
    }
    
    /** Method that logs a user in, returning true if successful. Method asks
     *  for an id that has been created and for the matching pin. Each time a
     *  user logs in the code is changed. Program checks that code entered
     *  corresponds to the correct pin.
     *  @return true if login is successful
     */
    public boolean logIn() {   
        if (DEBUG) {
            System.out.println("\ninside login()");
        }
        // generate a new code at each login.
        code = generateCode();  
        readFromFile();
        
        int[] xPin = userMatch(getLoginID());

        if (xPin != null) 
            return pinMatch(getPin(), xPin);
        else
            System.out.println("UserID does not exist.");
        return false;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean login = false;
        
        System.out.println("Welcome to the xo file system.");
        
        Authentication auth = new Authentication();
        
        System.out.println("\nNow let's test your login.");
        
        while (!login) {
           login = auth.logIn();
        } 
        
        System.out.println("Login successful.");
    }
    
}
