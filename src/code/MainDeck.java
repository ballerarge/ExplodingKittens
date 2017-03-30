
package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainDeck {

	Deck deck;
	CardFactory factory;

	public MainDeck() {
		this.deck = new Deck(new ArrayList<Card>());
		this.factory = new CardFactory();
	}

	public MainDeck(List<Card> cards) {
		this.deck = new Deck(cards);
		this.factory = new CardFactory();
	}

	public List<Card> getCards() {
		return this.deck.getCards();
	}

	public int getCardCount() {
		return deck.getCards().size();
	}

	public boolean insertCard(Card card, int position) {
		return deck.addCard(card, position);
	}

	public Card draw() {
		Card drawCard = deck.getCards().get(0);
		deck.removeCard(drawCard);
		return drawCard;
	}

	public void shuffleDeck() {
		Collections.shuffle(deck.getCards());
	}

	public void initStartingDeck() {
		initFavorCards();
		initShuffleCards();
		initSkipCards();
		initAttackCards();
		initNormalCards();
		initNopeCards();
		initScryCards();
	}

	private void initFavorCards() {
		for (int i = 0; i < 4; i++) {
			deck.addCard(factory.createCard(CardFactory.FAVOR_CARD), 0);
		}
	}

	private void initShuffleCards() {
		for (int i = 0; i < 4; i++) {
			deck.addCard(factory.createCard(CardFactory.SHUFFLE_CARD), 0);
		}
	}

	private void initSkipCards() {
		for (int i = 0; i < 4; i++) {
			deck.addCard(factory.createCard(CardFactory.SKIP_CARD), 0);
		}
	}

	private void initAttackCards() {
		for (int i = 0; i < 4; i++) {
			deck.addCard(factory.createCard(CardFactory.ATTACK_CARD), 0);
		}
	}

	private void initNormalCards() {
		for (int i = 0; i < 20; i++) {
			deck.addCard(factory.createCard(CardFactory.NORMAL_CARD), 0);
		}
	}

	private void initNopeCards() {
		for (int i = 0; i < 5; i++) {
			deck.addCard(factory.createCard(CardFactory.NOPE_CARD), 0);
		}
	}

	private void initScryCards() {
		for (int i = 0; i < 5; i++) {
			deck.addCard(factory.createCard(CardFactory.SCRY_CARD), 0);
		}
	}

	public void populateDeck(int numPlayers) {
		initExplodingKittenCards(numPlayers);
		initDefuseCards(numPlayers);
	}

	private void initExplodingKittenCards(int numPlayers) {
		for (int i = 0; i < numPlayers - 1; i++) {
			deck.addCard(factory.createCard(CardFactory.EXPLODING_KITTEN_CARD), 0);
		}
	}

	private void initDefuseCards(int numPlayers) {
		for (int i = 0; i < 6 - numPlayers; i++) {
			deck.addCard(factory.createCard(CardFactory.DEFUSE_CARD), 0);
		}
	}

	
	public MainDeck(){
		
	}
	
	public Card getTopCard() {
		return new Card();
	}
	
}