package Boundary;

import java.util.Scanner;

/**
 * Class to handle input/output to/from the console.
 *
 * @author DTU 02312 Gruppe 19
 *
 */
public class TUI {    
    /**
     * Prints game rules.
     */
    public static void printRules() {
        System.out.println("");
        System.out.println("-----------------------------------------------");
        System.out.println("| Spilleregler:                               |");
        System.out.println("| Man vinder på 2 seksere 2 gange i træk (6). |");
        System.out.println("| Man taber alle point på to enere (1).       |");
        System.out.println("| Får et ekstra slag med 2 ens terninger.     |");
        System.out.println("| Tryk Enter for at slå.                      |");
        System.out.println("| Tryk q for at afslutte spillet              |");
        System.out.println("-----------------------------------------------");
        System.out.println("");
    }
    
    /**
     * Prints a short text, asking the specified player to type his name.
     * 
     * @param playerNo The player number to print as part of the message.
     */
    public static void printNameRequest(int playerNo) {
        System.out.println("Indtast navn for spiller " + playerNo + ".");
    }
    
    /**
     * Prints a shot text, telling the player whos turn it is, and asking him to roll.
     * 
     * @param name The name to print as part of the message.
     */
    public static void printTurn(String name) {
        System.out.print("\nDet er " + name + "'s tur. Tryk enter for at slå.");
    }
    
    /**
     * Prints the current status of the game. Thats both players score and the facevalue of the dice.
     * 
     * @param player1Name The name of the first player, to print as part of the message
     * @param player2Name The name of the second player, to print as part of the message
     * @param player1Score The score for the first player, to print as part of the message
     * @param player2Score The score for the second player, to print as part of the message   
     * @param die1 The facevalue of die1
     * @param die2 The facebalue of die2
     */
    public static void printStatus(String player1Name, String player2Name, int player1Score, int player2Score, int die1, int die2) {
        System.out.println("Der blev slået " + die1 + " - " + die2 + ".");
        System.out.println("Scoren er nu:");
        System.out.println(player1Name + " = " + player1Score);
        System.out.println(player2Name + " = " + player2Score);
    }
    
    /**
     * Prints the results of the dice test, along woth a nice little chart.
     * 
     * @param rolls The number of rolls that have been completed for this test.
     * @param pairs The number of pairs hit in this test.
     * @param values An array containing the number of times each sum has been hit. Eg. if the sum 2 was hit 10 times, values[2] should be = 10.
     */
    public static void printTestResult(int rolls, int pairs, int[] values) {
        int i, chars, divider;
        
        System.out.println("\nDer blev slået " + rolls + " gange. Resultatet blev:");
        System.out.println("Antal ens = " + pairs);
        for(i=2; i<13; i++) {
            System.out.println("Antal slag med sum " + i + " = " + values[i]);
        }
        
        System.out.println("\nGraf for resultater:");
        divider = rolls / 100;
        for (i = 2; i < 13; i++) {
            chars = values[i] / divider;
            while(chars > 0) {
                System.out.print("-");
                chars--;
            }
            
            System.out.println("");
        }
    }
    
    /**
     * Prints the name and score of the winning player.
     * 
     * @param name The name of the player who should be declared the winner.
     * @param score The score for the winning player.
     */
    public static void printWinner(String name, int score) {
        System.out.println("Tillykke! " + name + " har vundet med " + score + " point!\nTryk Enter for at afslutte.");
    }
    
    /**
     * Reads a line from the console.
     * 
     * @param scanner The scanner to read from
     * @return Whatever the user inputs.
     */
    public static String getUserInput(Scanner scanner) {
        return scanner.nextLine();
    }
} 