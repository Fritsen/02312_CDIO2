package Entity;

public class Field {
	private int fieldScore;
	private boolean givesExtraTurn;

	public Field(int fieldScore) {
		this.fieldScore = fieldScore;
		this.givesExtraTurn = false;
	}
	
	public Field(int fieldScore, boolean givesExtraTurn) {
		this.fieldScore = fieldScore;
		this.givesExtraTurn = givesExtraTurn;
	}
	
	public int getFieldScore() {
		return fieldScore;
	}
	
	public boolean getGivesExtraTurn() {
		return givesExtraTurn;
	}
}
