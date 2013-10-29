//TODO: Translate to english

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
    	//TODO: Print rules for the new game
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
    
    public static String getFieldName(int fieldNumber) {
    	switch(fieldNumber) {
	    	case 2:
	    		return "Tower";
	    	case 3:
	    		return "Crater";
	    	case 4:
	    		return "Palace gates";
	    	case 5:
	    		return "Cold Desert";
	    	case 6:
	    		return "Walled city";
	    	case 7:
	    		return "Monastery";
	    	case 8:
	    		return "Black cave";
	    	case 9:
	    		return "Huts in the mountain";
	    	case 10:
	    		return "The Wearwall";
	    	case 11:
	    		return "The pit";
	    	case 12:
	    		return "Goldmine";
    	}
    	
    	return null;
    }
    
    /**
     * Prints a short text, asking the specified player to type his name.
     * 
     * @param playerNo The player number to print as part of the message.
     */
    public static void printNameRequest(int playerNumber) {
        System.out.println("Indtast navn for spiller " + (playerNumber+1) + ".");
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
        //TODO: Add description of field
    	System.out.println("Der blev slået " + die1 + " - " + die2 + ".");
        System.out.println("Scoren er nu:");
        System.out.println(player1Name + " = " + player1Score);
        System.out.println(player2Name + " = " + player2Score);
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