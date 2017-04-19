
package code;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import gui.MainWindow;

public class GameController {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Game game = new Game();

		// Opens the gui
		MainWindow window = new MainWindow();
		window.open();
		
		// Gets the player names
		List<Player> players = window.getPlayers();
		
		while (true) {
			System.out.print("Insert number of players: ");
			int numOfPlayers = scanner.nextInt();

			try {
				game.start(numOfPlayers);
				break;
			} catch (InvalidNumberofPlayersException e) {
				System.out.println("Invalid number of player!");
			}
		}

		printPlayerHands(game);

	}

	private static void printPlayerHands(Game game) {
		Map<Player, List<Card>> playerHands = game.getPlayerHands();

		System.out.println(game.mainDeck.getCards());

		for (Player playa : playerHands.keySet()) {
			System.out.printf("Player %s's hand:\n\t%s\n", playa.getName(), playerHands.get(playa).toString());
		}

	}

}
