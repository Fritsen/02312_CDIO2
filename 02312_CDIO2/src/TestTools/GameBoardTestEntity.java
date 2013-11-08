package TestTools;

import Entity.Field;

public class GameBoardTestEntity {
	Field[] fields;

	public GameBoardTestEntity() {
		fields = new Field[13];

		// Create the fields
		fields[2] = new Field(-3001);
		fields[3] = new Field(-3000);
		fields[4] = new Field(-2999);
		fields[5] = new Field(-4000);
		fields[6] = new Field(-5500);
		fields[7] = new Field(-7000);
		fields[8] = new Field(-700000);
		fields[9] = new Field(-1000000);
		fields[10] = new Field(-8000, true);
		fields[11] = new Field(-9000);
		fields[12] = new Field(-6500);
	}

	public Field getField(int fieldNumber) {
		return fields[fieldNumber];
	}

	public String toString() {
		String output = "";
		int i;

		for (i = 0; i < fields.length; i++) {
			if (fields[i] != null) {
				output = output + fields[i] + "\n";
			}
		}

		return output;
	}
}
