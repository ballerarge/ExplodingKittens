
package code;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import gui.MainWindow;
import exceptions.InvalidNumberofPlayersException;
import gui.StartingMenu;

public class GameController {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Game game = new Game();

		// Opens the gui
		MainWindow window = new MainWindow();
		window.open();

		// Gets the player names
		List<Player> players = window.getPlayers();

		
		StartingMenu menu = new StartingMenu();
		menu.selectLanguage();
		menu.selectNumberofPlayers();
		try {
			game.start(menu.numberOfPlayers);
		} catch (InvalidNumberofPlayersException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		printPlayerHands(game);

	}

	private static void printPlayerHands(Game game) {
		Map<Player, List<Card>> playerHands = game.getPlayerHands();

		for (Player playa : playerHands.keySet()) {
			System.out.printf("Player %s's hand:\n\t%s\n", playa.getName(), playerHands.get(playa).toString());
		}

	}

}
