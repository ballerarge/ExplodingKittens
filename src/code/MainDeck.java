
package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainDeck {

	private static MainDeck mainDeck;

	Deck deck;
	public CardFactory factory;

	public static MainDeck getInstance() {
		if (mainDeck == null) {
			mainDeck = new MainDeck();
		}
		return mainDeck;
	}

	public static void tearDown() {
		mainDeck = null;
	}

	private MainDeck() {
		deck = new Deck(new ArrayList<Card>());
		factory = new CardFactory();
	}

	public int getCardCount() {
		return mainDeck.getCards().size();
	}

	public List<Card> getCards() {
		return mainDeck.deck.getCards();
	}

	public void setCards(List<Card> cards) {
		mainDeck.deck = new Deck(cards);
	}

	public boolean insertCard(Card card, int position) {
		return mainDeck.deck.addCard(card, position);
	}

	public Card draw() {
		Card drawCard = getTopCard();
		mainDeck.deck.removeCard(drawCard);
		return drawCard;
	}

	private Card getTopCard() {
		return mainDeck.getCards().get(0);
	}

	public void shuffleDeck() {
		List<Card> toShuffle = mainDeck.deck.getCards();
		Collections.shuffle(toShuffle);
		mainDeck.deck.setCards(toShuffle);
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
		}
		shuffleDeck();
	}

	private void initFavorCards() {
		for (int i = 0; i < 4; i++) {
			mainDeck.insertCard(factory.createCard(CardFactory.FAVOR_CARD), 0);
		}
	}

	private void initShuffleCards() {
		for (int i = 0; i < 4; i++) {
			mainDeck.insertCard(factory.createCard(CardFactory.SHUFFLE_CARD), 0);
		}
	}

	private void initSkipCards() {
		for (int i = 0; i < 4; i++) {
			mainDeck.insertCard(factory.createCard(CardFactory.SKIP_CARD), 0);
		}
	}

	private void initAttackCards() {
		for (int i = 0; i < 4; i++) {
			mainDeck.insertCard(factory.createCard(CardFactory.ATTACK_CARD), 0);
		}
	}

	private void initNormalCards() {
		for (int i = 0; i < 20; i++) {
			NormalCard card = (NormalCard) factory.createCard(CardFactory.NORMAL_CARD);
			card.setIcon(i % 4);
			mainDeck.insertCard(card, 0);
		}
	}

	private void initNopeCards() {
		for (int i = 0; i < 5; i++) {
			mainDeck.insertCard(factory.createCard(CardFactory.NOPE_CARD), 0);
		}
	}

	private void initScryCards() {
		for (int i = 0; i < 5; i++) {
			mainDeck.insertCard(factory.createCard(CardFactory.SCRY_CARD), 0);
		}
	}

	public void populateDeck(int numPlayers) {
		initExplodingKittenCards(numPlayers);
		initDefuseCards(numPlayers);
		shuffleDeck();
	}

	private void initExplodingKittenCards(int numPlayers) {
		for (int i = 0; i < numPlayers - 1; i++) {
			mainDeck.insertCard(factory.createCard(CardFactory.EXPLODING_KITTEN_CARD), 0);
		}
	}

	private void initDefuseCards(int numPlayers) {
		for (int i = 0; i < 6 - numPlayers; i++) {
			mainDeck.insertCard(factory.createCard(CardFactory.DEFUSE_CARD), 0);
		}
	}

}
