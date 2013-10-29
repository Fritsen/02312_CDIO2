package Control;

import java.util.Scanner;

import Boundary.TUI;
import Entity.DieCup;
import Entity.Field;
import Entity.Player;
import boundaryToMatador.GUI;

/**
 * This is controller class in the dice game.
 *
 * @author DTU 02312 Gruppe 19
 *
 */
public class Game {
	private final int POINTS_TO_START_WITH = 1000;
    private final int POINTS_TO_WIN = 3000;
    private final int NUMBER_OF_PLAYERS = 2;
    
    private DieCup dieCup;
    private Scanner scanner;
    private Player[] players;
    private Field[] fields;

    /**
     * Game constructor. Creates new instances of the required classes.
     */
    public Game() {
    	int i;
    	
        dieCup = new DieCup();
        scanner = new Scanner(System.in);
        players = new Player[NUMBER_OF_PLAYERS];
        fields = new Field[13];
        
    	//Make all player-objekts in loop
    	for(i=0; i<NUMBER_OF_PLAYERS; i++) {
    		players[i] = new Player(POINTS_TO_START_WITH);
    	}
    	
    	//TODO: Consider creating these in a seperate class like a board or something...?
    	//Create the fields
    	createField(2, 250, false);
    	createField(3, -200, false);
    	createField(4, -100, false);
    	createField(5, -20, false);
    	createField(6, +180, false);
    	createField(7, 0, false);
    	createField(8, -70, false);
    	createField(9, -60, false);
    	createField(10, -80, true);
    	createField(11, -90, false);
    	createField(12, +650, false);
    }
    
    /**
     * Start the game.
     */
    public void startGame() {
        int activePlayer, i;
        String userInput;
        
        TUI.printRules();
        
        //Ask for all player names and save them in the player objects
        for(i=0; i<NUMBER_OF_PLAYERS; i++) {
        	TUI.printNameRequest(i);
        	players[i].setName(TUI.getUserInput(scanner));
        }
        
        //Player 1 always starts. However this would work with Player 2, or even random.
        activePlayer = 0;
        
        //Start of the actual game. Infinite loop is broken only when someone wins or inputs "q"
        while(true) {
            //Write whos turn it is and wait for input
            TUI.printTurn(players[activePlayer].getName());
            userInput = TUI.getUserInput(scanner);
            
            //Exit game if user inputs "q"
            if("q".equals(userInput)) {
                cleanUp();
            }
            
            //Shake, and add the sum of the dice to the current players score
            dieCup.shakeDieCup();
            
            //TODO: Add points from field
            
            //Write status/score to both TUI and GUI
            statusTasks();
            
            //Check if player have won
            if (players[activePlayer].getAccount() >= POINTS_TO_WIN) {
                winTasks(activePlayer);
            }
            
            //Switch turn to the next player, unless the current player gets an extra turn
            if(!fields[dieCup.getSum()].givesExtraTurn()) {
                activePlayer = getNextPlayer(activePlayer);
            } 
        }
    }
    
    /**
     * Simple method to get the number of the next player.
     * 
     * @param input The number to toggle away from.
     * @return 1 if 2 is given, 2 if 1 is given.
     */
    private int getNextPlayer(int input) {
        if(input+1 >= NUMBER_OF_PLAYERS) {
        	return 0;
        }
        
        return input+1;
    }
    
    /**
     * Writes score and dice values to both GUI and TUI
     */
    private void statusTasks() {
    	//TODO: Update fields as well
        TUI.printStatus(players[0].getName(), players[1].getName(), players[0].getAccount(), players[1].getAccount(), dieCup.getValueDie1(), dieCup.getValueDie2());
        GUI.setDice(dieCup.getValueDie1(), dieCup.getValueDie2());
        GUI.addPlayer(players[0].getName(), players[1].getAccount(), 1);
        GUI.addPlayer(players[0].getName(), players[1].getAccount(), 2);
    }
    
    /**
     * Prints the name of the current player, along with a message telling that he has won the game.,
     * then waits for input, to make sure the message stays on the screen.
     * Ends the program when any input is given.
     */
    private void winTasks(int activePlayer) {
        TUI.printWinner(players[activePlayer-1].getName(), players[activePlayer-1].getAccount());
        TUI.getUserInput(scanner);
        cleanUp();
    }
    
    /**
     * Closes the program and cleans up properly. 
     */
    private void cleanUp() {
        GUI.close();
        scanner.close();
        System.exit(0);
    }
    
    private void createField(int fieldNumber, int fieldScore, boolean givesExtraTurn) {
    	//TODO: Add field on GUI
    	fields[fieldNumber] = new Field(fieldScore, givesExtraTurn);
    }
} 