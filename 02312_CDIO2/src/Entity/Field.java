package Entity;

public class Field {
	int fieldScore;
	boolean givesExtraTurn;
	
	public Field(int fieldScore, boolean givesExtraTurn) {
		this.fieldScore = fieldScore;
		this.givesExtraTurn = givesExtraTurn;
	}
	
	public int fieldScore() {
		return fieldScore;
	}
	
	public boolean givesExtraTurn() {
		return givesExtraTurn;
	}
}
