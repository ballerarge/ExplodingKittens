
package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import exceptions.InvalidNumberofPlayersException;
import exceptions.NoSuchPlayerException;
import gui.CardComponent;
import gui.EKPlayerSelectionWindow;
import gui.LanguageMenu;
import gui.MainWindow;
import gui.NumberofPlayersMenu;
import gui.PlayerNameEntryMenu;

public class GameController {

	public static void main(String[] args) {

		Game game = new GameLogger(new Game());

		Player player1 = new Player("One");
		Player player2 = new Player("Two");
		Player player3 = new Player("Three");
		Player player4 = new Player("Four");

		List<Player> test = new ArrayList<Player>();
		test.add(player1);
		test.add(player2);
		test.add(player3);
		test.add(player4);

		// EKPlayerSelectionWindow playerSelect = new
		// EKPlayerSelectionWindow(player1, test, "Player to act upon");
		// playerSelect.display();
		NumberofPlayersMenu menu = new NumberofPlayersMenu();

		LanguageMenu languageMenu = new LanguageMenu();

		// Opens the gui
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
						addCardListeners(game, window, window.getDisplayedCards());
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
				try {
					game.nextTurn();
					window.displayGameState(game);
					addCardListeners(game, window, window.getDisplayedCards());
				} catch (Exception e) {
					window.endGame();
				}
			}

		});

		window.setPlaySelectedCardListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<CardComponent> components = window.getSelectedCards();
				List<Card> selectedCards = new ArrayList<Card>();
				for (CardComponent component : components) {
					selectedCards.add(component.getCard());
				}

				if (selectedCards.size() == 1) { // Resolve one card

					CardStack.getInstance().addCard(selectedCards.get(0));

					if (cardNeedsNoTargets(selectedCards.get(0))) {
						CardStack.getInstance().resolveTopCard();
					} else if (cardNeedsPlayerTarget(selectedCards.get(0))) {
						List<Player> otherPlayers = new ArrayList<Player>();
						for (Player player : game.getPlayers()) {
							if (player != game.getActivePlayer()) {
								otherPlayers.add(player);
							}
						}
						window.hideHand();
						EKPlayerSelectionWindow playerSelectWindow = new EKPlayerSelectionWindow(game.getActivePlayer(),
						        otherPlayers, window.locale, "");
						Player targetedPlayer = playerSelectWindow.display();

						// Check for nope from targeted player
						// EKDialogWindow.displayInfoMessage(title, toDisplay,
						// args);

						window.unhideHand();

						if (selectedCards.get(0).getID() == CardFactory.FAVOR_CARD) {
							System.out.println("");
						}

						CardStack.getInstance().resolveTopCard(game.getActivePlayer(), targetedPlayer);
					}
					window.clearSelected();
					DiscardDeck.getInstance().addAll(selectedCards);
					window.displayGameState(game);
					addCardListeners(game, window, window.getDisplayedCards());
				} else { // Resolve bundle
					System.out.println("Bundle logic goes here.");
				}
			}

		});

		window.openStartWindow();
	}

	protected static boolean cardNeedsPlayerTarget(Card card) {
		return (card.getID() == CardFactory.ATTACK_CARD || card.getID() == CardFactory.FAVOR_CARD);
	}

	protected static boolean cardNeedsNoTargets(Card card) {
		return (card.getID() == CardFactory.EXPLODING_KITTEN_CARD || card.getID() == CardFactory.NOPE_CARD
		        || card.getID() == CardFactory.SHUFFLE_CARD || card.getID() == CardFactory.SKIP_CARD);
	}

	protected static void addCardListeners(Game game, MainWindow window, List<CardComponent> displayedCards) {
		for (CardComponent component : displayedCards) {
			component.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					window.toggleSelected(component);
					if (game.getCurrentPlayer().getHand().contains(component.getCard())) {
						game.getCurrentPlayer().getHandManager()
						        .selectCard(game.getCurrentPlayer().getHand().indexOf(component.getCard()));
					} else {
						game.getCurrentPlayer().getHandManager()
						        .addCards(game.getCurrentPlayer().getHandManager().getSelectedCards());
						game.getCurrentPlayer().getHandManager().clearSelectedCards();
					}
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// Do nothing
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// Do nothing

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// Do nothing
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// Do nothing
				}

			});
		}
	}

	private static void printPlayerHands(Game game) {
		Map<Player, List<Card>> playerHands = game.getPlayerHands();

		for (Player playa : playerHands.keySet()) {
			System.out.printf("Player %s's hand:\n\t%s\n", playa.getName(), playerHands.get(playa).toString());
		}
	}
}
