package Entity;

public class Player {
    private String name;
    private Account account;
    
    /**
     * Constructor that initiates name to empty and account to an initial score.
     */
    public Player(int initialScore) {
        name = "";
        account = new Account(initialScore);
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
        account.setAccountValue(input);
    }
    
    /**
     * Gets the current account value.
     * 
     * @return The amount currently in the players account.
     */
    public int getAccount() {
        return account.getAccountValue();
    }
    
    /**
     * Takes the current account value and adds the given number.
     * 
     * @param input The amount to add.
     */
    public void addToAccount(int input) {
        account.addToAccount(input);
    }
    
    /**
     * Method that makes a text with the most important values in the class, and some description.
     *
     * @return A coherent string with values of name, account and hitSixLast.
     */
    public String toString() {
        return "Name = " + name + ", Account = " + account;
    }
} 