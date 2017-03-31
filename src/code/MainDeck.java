
package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainDeck {

	private static MainDeck mainDeck;

	Deck deck;
	CardFactory factory;

	public static MainDeck getInstance() {
		if (mainDeck == null) {
			mainDeck = new MainDeck();
		}
		return mainDeck;
	}

	// Use carefully.
	public static void tearDown() {
		mainDeck = null;
	}

	private MainDeck() {
		deck = new Deck(new ArrayList<Card>());
		factory = new CardFactory();
	}

	private MainDeck(List<Card> cards) {
		mainDeck.deck = new Deck(cards);
		mainDeck.factory = new CardFactory();
	}

	public List<Card> getCards() {
		return mainDeck.deck.getCards();
	}

	public int getCardCount() {
		return mainDeck.deck.getCards().size();
	}

	public boolean insertCard(Card card, int position) {
		return mainDeck.deck.addCard(card, position);
	}

	public Card draw() {
		Card drawCard = mainDeck.deck.getCards().get(0);
		mainDeck.deck.removeCard(drawCard);
		return drawCard;
	}

	public void shuffleDeck() {
		Collections.shuffle(mainDeck.deck.getCards());
	}

	public void initStartingDeck() {
		if (mainDeck.deck.getCards().size() == 0) {
			initFavorCards();
			initShuffleCards();
			initSkipCards();
			initAttackCards();
			initNormalCards();
			initNopeCards();
			initScryCards();
			shuffleDeck();
		}
	}

	private void initFavorCards() {
		for (int i = 0; i < 4; i++) {
			mainDeck.deck.addCard(factory.createCard(CardFactory.FAVOR_CARD), 0);
		}
	}

	private void initShuffleCards() {
		for (int i = 0; i < 4; i++) {
			mainDeck.deck.addCard(factory.createCard(CardFactory.SHUFFLE_CARD), 0);
		}
	}

	private void initSkipCards() {
		for (int i = 0; i < 4; i++) {
			mainDeck.deck.addCard(factory.createCard(CardFactory.SKIP_CARD), 0);
		}
	}

	private void initAttackCards() {
		for (int i = 0; i < 4; i++) {
			mainDeck.deck.addCard(factory.createCard(CardFactory.ATTACK_CARD), 0);
		}
	}

	private void initNormalCards() {
		for (int i = 0; i < 20; i++) {
			mainDeck.deck.addCard(factory.createCard(CardFactory.NORMAL_CARD), 0);
		}
	}

	private void initNopeCards() {
		for (int i = 0; i < 5; i++) {
			mainDeck.deck.addCard(factory.createCard(CardFactory.NOPE_CARD), 0);
		}
	}

	private void initScryCards() {
		for (int i = 0; i < 5; i++) {
			mainDeck.deck.addCard(factory.createCard(CardFactory.SCRY_CARD), 0);
		}
	}

	public void populateDeck(int numPlayers) {
		initExplodingKittenCards(numPlayers);
		initDefuseCards(numPlayers);
		shuffleDeck();
	}

	private void initExplodingKittenCards(int numPlayers) {
		for (int i = 0; i < numPlayers - 1; i++) {
			mainDeck.deck.addCard(factory.createCard(CardFactory.EXPLODING_KITTEN_CARD), 0);
		}
	}

	private void initDefuseCards(int numPlayers) {
		for (int i = 0; i < 6 - numPlayers; i++) {
			mainDeck.deck.addCard(factory.createCard(CardFactory.DEFUSE_CARD), 0);
		}
	}

	public Card getTopCard() {
		return mainDeck.deck.getCards().get(0);
	}

}
