
package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import exceptions.InvalidNumberofPlayersException;
import gui.EKPlayerSelectionWindow;
import gui.LanguageMenu;
import gui.MainWindow;
import gui.NumberofPlayersMenu;
import gui.PlayerNameEntryMenu;

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
		// playerSelect.display();
		NumberofPlayersMenu menu = new NumberofPlayersMenu();

		LanguageMenu languageMenu = new LanguageMenu();

		// Opens the gui
		Locale locale = Locale.ENGLISH;
		MainWindow window = new MainWindow();

		window.setSelectLanguageListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				window.setLocale(languageMenu.selectLanguage());
			}
		});

		window.setPlayGameListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int numPlayers = menu.selectNumberofPlayers(window.locale);

					game.start(numPlayers);

					List<String> playerNames = PlayerNameEntryMenu.getPlayerNames(window.locale, numPlayers);

					if (playerNames == null) {
						window.exitGame();
					} else {
						for (int i = 0; i < numPlayers; i++) {
							game.getPlayers().get(i).setName(playerNames.get(i));
						}

						window.openGameWindow();

						window.displayGameState(game);
					}
				} catch (InvalidNumberofPlayersException e1) {
					try {
						game.start(4);
					} catch (InvalidNumberofPlayersException ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		window.setNextTurnListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.nextTurn();
				window.displayGameState(game);
			}

		});

		window.openStartWindow();
	}

	private static void printPlayerHands(Game game) {
		Map<Player, List<Card>> playerHands = game.getPlayerHands();

		for (Player playa : playerHands.keySet()) {
			System.out.printf("Player %s's hand:\n\t%s\n", playa.getName(), playerHands.get(playa).toString());
		}
	}
}
