
package gui;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import code.Player;

@SuppressWarnings("serial")
public class EKPlayerSelectionWindow extends JOptionPane {

	private Player currentPlayer;
	private List<Player> listOfPlayers;
	private String message;
	Locale locale;

	public EKPlayerSelectionWindow(Player currentPlayer, List<Player> players, Locale locale, String message) {
		this.currentPlayer = currentPlayer;
		this.listOfPlayers = players;
		this.message = message;
		this.listOfPlayers.remove(this.currentPlayer);
		this.locale = locale;
	}

	public Player display() {
		Object[] options = playerNames();
		Icon icon = new ImageIcon(getClass().getResource("jetpack-kitten.png"));
		System.out.println(icon == null);

		String playerName = (String) showInputDialog(null, message,
		        ResourceBundle.getBundle("resources/resources").getString("PLAYER_SELECT_TITLE"), QUESTION_MESSAGE,
		        icon, options, currentPlayer);

		return getPlayerFromName(playerName);
	}

	private Player getPlayerFromName(String playerName) {
		for (Player player : this.listOfPlayers) {
			if (player.getName().equals(playerName)) {
				return player;
			}
		}

		return null;
	}

	private String[] playerNames() {
		String[] names = new String[listOfPlayers.size()];

		for (int i = 0; i < listOfPlayers.size(); i++) {
			names[i] = listOfPlayers.get(i).getName();
		}

		return names;
	}

}
