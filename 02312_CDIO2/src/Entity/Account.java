package Entity;

public class Account {
	private int accountValue;
	
	public Account() {
		accountValue = 0;
	}
	
	public Account(int initialAccountValue) {
		accountValue = initialAccountValue;
	}
	
	public void setAccountValue(int input) {
		accountValue = input;
	}
	
	public int getAccountValue() {
		return accountValue;
	}
	
	public void addToAccount(int input) {
		accountValue = accountValue + input;
	}
}
