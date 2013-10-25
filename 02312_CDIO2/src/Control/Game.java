package Control;

import java.util.Scanner;

import Boundary.TUI;
import Entity.DieCup;
import Entity.Player;
import boundaryToMatador.GUI;

/**
 * This is controller class in the dice game.
 *
 * @author DTU 02312 Gruppe 19
 *
 */
public class Game {
    private final int POINTS_TO_WIN = 40;
    
    private Player player1, player2;
    private Player currentPlayer;
    private DieCup dieCup;
    private Scanner scanner;

    /**
     * Game constructor. Creates new instances of the required classes.
     */
    public Game() {
        player1 = new Player();
        player2 = new Player();
        dieCup = new DieCup();
        scanner = new Scanner(System.in);
    }
    
    /**
     * Start the game.
     */
    public void startGame() {
        int activePlayer;
        String userInput;
        
        //Write something to the GUI, to make it start
        GUI.setDice(6, 6);
        
        TUI.printRules();
        
        //Ask for player names and save them in the player objects
        TUI.printNameRequest(1);
        player1.setName(TUI.getUserInput(scanner));
        TUI.printNameRequest(2);
        player2.setName(TUI.getUserInput(scanner));
        
        //Player 1 always starts. However this would work with Player 2, or even random.
        activePlayer = 1;
        
        //Start of the actual game. Infinite loop is broken only when someone wins or inputs "q"
        while(true) {
            //Get data for the active player
            currentPlayer = getPlayer(activePlayer);
            
            //Write whos turn it is and wait for input
            TUI.printTurn(currentPlayer.getName());
            userInput = TUI.getUserInput(scanner);
            
            //Exit game if user inputs "q"
            if("q".equals(userInput)) {
                cleanUp();
            }
            
            //Shake, and add the sum of the dice to the current players score
            dieCup.shakeDieCup();
            currentPlayer.addToAccount(dieCup.getSum());
            
            //Check if player hit double 1's and set score to 0 if he did
            if(dieCup.getDoubleOne()) {
                currentPlayer.setAccount(0);
            }
            
            //Check if player hit double 6's and save to player object
            if(dieCup.getDoubleSix()) {
                //Check if current player has won by having double 6's two times in a row
                if(currentPlayer.getHitSixLast()) {
                    statusTasks();
                    winTasks();
                }
                
                //Save double six status AFTER the win-check
                currentPlayer.setHitSixLast(true);
            }
            else {
                currentPlayer.setHitSixLast(false);
            }
            
            //Write status/score to both TUI and GUI
            statusTasks();
            
            //Check if player have won by having enough points and hitting a pair
            if (currentPlayer.getAccount() >= POINTS_TO_WIN && dieCup.getEns()) {
                winTasks();
            }
            
            //Switch turn to the other player, unless the current player hit a pair
            if(!dieCup.getEns()) {
                activePlayer = getInactivePlayer(activePlayer);
            } 
        }
    }
    
    /**
     * Simple method to get a player object from an integer. Eg. "getPlayer(1)" will get player1 object.
     * 
     * @param playerNo The number of the player to get.
     * @return The player object that corresponds to the number given.
     */
    private Player getPlayer(int playerNo) {
        if(playerNo == 1) {
            return player1;
        }
        else if(playerNo == 2) {
            return player2;
        }
        
        return null;
    }
    
    /**
     * Simple method to toggle between 1 and 2.
     * 
     * @param input The number to toggle away from.
     * @return 1 if 2 is given, 2 if 1 is given.
     */
    private int getInactivePlayer(int input) {
        if(input == 1) {
            return 2;
        }
        else if(input == 2) {
            return 1;
        }
        
        return 0;
    }
    
    /**
     * Writes score and dice values to both GUI and TUI
     */
    private void statusTasks() {
        TUI.printStatus(player1.getName(), player2.getName(), player1.getAccount(), player2.getAccount(), dieCup.getValueDie1(), dieCup.getValueDie2());
        GUI.setDice(dieCup.getValueDie1(), dieCup.getValueDie2());
        GUI.addPlayer(player1.getName(), player1.getAccount(), 1);
        GUI.addPlayer(player2.getName(), player2.getAccount(), 2);
    }
    
    /**
     * Prints the name of the current player, along with a message telling that he has won the game.,
     * then waits for input, to make sure the message stays on the screen.
     * Ends the program when any input is given.
     */
    private void winTasks() {
        TUI.printWinner(currentPlayer.getName(), currentPlayer.getAccount());
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
} 