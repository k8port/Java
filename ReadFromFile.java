/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package readfromfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author k8port
 */
public class ReadFromFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner jane = null;
        
        // gather input from file
        try {
            jane = new Scanner(new FileInputStream("chg.txt"));
            String fileTxt = jane.nextLine();
            // change string from file
            int pos2 = fileTxt.indexOf("hate");
            String fileEnd = fileTxt.substring(pos2 + "hate".length());
            String chgFileTxt = fileTxt.substring(0, pos2) + "love" + fileEnd;
            // output result
            System.out.println("From file: ");
            System.out.println("The line of text to be changed is: ");
            System.out.println(fileTxt);
            System.out.println("I have rephrased the line to read: ");
            System.out.println(chgFileTxt);
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }
    }
}
