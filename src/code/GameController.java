
package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import gui.EKPlayerSelectionWindow;
import gui.MainWindow;
import exceptions.InvalidNumberofPlayersException;

public class GameController {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Game game = new Game();
		
		Player player1 = new Player("One");
		Player player2 = new Player("Two");
		Player player3 = new Player("Three");
		Player player4 = new Player("Four");
		
		List<Player> test = new ArrayList<Player>();
		test.add(player1);
		test.add(player2);
		test.add(player3);
		test.add(player4);
		
		EKPlayerSelectionWindow playerSelect = new EKPlayerSelectionWindow(player1, test, "Player to act upon");
		playerSelect.display();

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

		for (Player playa : playerHands.keySet()) {
			System.out.printf("Player %s's hand:\n\t%s\n", playa.getName(), playerHands.get(playa).toString());
		}

	}

}
