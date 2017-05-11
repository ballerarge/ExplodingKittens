package gui;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import code.Player;

@SuppressWarnings("serial")
public class EKPlayerSelectionWindow extends JOptionPane {
	
	private Player currentPlayer;
	private List<Player> listOfPlayers;
	private String message;
	
	public EKPlayerSelectionWindow(Player currentPlayer, List<Player> players, String message) {
		this.currentPlayer = currentPlayer;
		this.listOfPlayers = players;
		this.message = message;
		this.listOfPlayers.remove(this.currentPlayer);
	}
	
	public String display() {
		Object[] options = playerNames();
		ImageIcon icon = new ImageIcon("jetpack-kitten.png");
		
		return (String) showInputDialog(
				null, message, "Select a player to target", QUESTION_MESSAGE, 
				icon, options, currentPlayer);
	}
	
	private String[] playerNames() {
		String[] names = new String[listOfPlayers.size()];
		
		for (int i = 0; i < listOfPlayers.size(); i++) {
			names[i] = listOfPlayers.get(i).getName();
		}
		
		return names;
	}
	
}
