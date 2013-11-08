package Entity;

public class Account {
	private int accountValue;
	
	public Account() {
		accountValue = 0;
	}
	
	public Account(int initialAccountValue) {
		accountValue = initialAccountValue;
	}
	
	public boolean setAccountValue(int input) {
		if(input > 0) {
			accountValue = input;
			return true;
		}
		
		return false;
	}
	
	public int getAccountValue() {
		return accountValue;
	}
	
	public boolean addToAccount(int input) {
		if(accountValue + input > 0) {
			accountValue = accountValue + input;
			return true;
		}
		
		return false;
	}
	
	public String toString() {
		return Integer.toString(accountValue);
	}
}
