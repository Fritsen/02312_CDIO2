package Entity;

public class Player {
    private String name;
    private int account;
    private boolean hitSixLast;
    
    /**
     * Constructor that initiates all the values to emty/zero.
     */
    public Player() {
        name = "";
        account = 0;
        hitSixLast = false;
    }
    
    /**
     * Saves the given name.
     * 
     * @param input The name to save.
     */
    public void setName(String input) {
        name = input;
    }
    
    /**
     * Gets the name of the player
     * 
     * @return The name of this player.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Set the account value to the number given.
     * 
     * @param input The amaount to set the account to.
     */
    public void setAccount(int input) {
        account = input;
    }
    
    /**
     * Gets the current account value.
     * 
     * @return The amount currently in the players account.
     */
    public int getAccount() {
        return account;
    }
    
    /**
     * Takes the current account value and adds the given number.
     * 
     * @param input The amount to add.
     */
    public void addToAccount(int input) {
        account = account + input;
    }
    
    /**
     * Saves a true/false value for whether or not the player hit double six in the last turn.
     * 
     * @param input True/false for hit double six or not.
     */
    public void setHitSixLast(boolean input) {
        hitSixLast = input;
    }
    
    /**
     * Gets a true/false value for whether or not the player hit double six in the last turn.
     * 
     * @return True/false for hit double six or not.
     */
    public boolean getHitSixLast() {
        return hitSixLast;
    }
    
    /**
     * Method that makes a text with the most important values in the class, and some description.
     *
     * @return A coherent string with values of name, account and hitSixLast.
     */
    public String toString() {
        return "Name = " + name + ", account = " + account + ", hitSixLast = " + hitSixLast;
    }
} 