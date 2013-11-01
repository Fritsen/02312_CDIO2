package Boundary;

import Entity.Player;
import boundaryToMatador.GUI;

public class Graphic {
	public static void setDice(int die1, int die2) {
		GUI.setDice(die1, die2);
	}
	
	public static void updatePlayers(Player[] players) {
		int i;
		
		for(i = 0; i<players.length; i++) {
			GUI.addPlayer(players[i].getName(), players[i].getAccount().getAccountValue(), i);
		}
	}
	
	public static void close() {
		GUI.close();
	}
	
	public static void setupFields() {
		createField("Tower", "+250", 2);
		createField("Crater", "-200", 3); 
		createField("Palace gates", "-100", 4); 
		createField("Cold Desert", "-20", 5); 
		createField("Walled city", "+180", 6); 
		createField("Monastery", "0", 7); 
		createField("Black cave", "-70", 8); 
		createField("Huts in the mountain", "-60", 9); 
		createField("The Wearwall", "-80", 10); 
		createField("The pit", "-90", 11);
		createField("Goldmine", "+650", 12); 
	}
	
	private static void createField(String title, String subTitle, int fieldNumber) {
		GUI.setTitleText(fieldNumber, title);
		GUI.setSubText(fieldNumber, subTitle);
		GUI.setDescriptionText(fieldNumber, title);
	}
}
