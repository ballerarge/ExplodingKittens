package code;

import java.util.ArrayList;
import java.util.List;

public class MainDeck {
	
	Deck deck;
	
	public MainDeck() {
		this.deck = new Deck(new ArrayList<Card>());
	}

	public MainDeck(List<Card> cards) {
		this.deck = new Deck(cards);
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

	public void initStartingDeck() {
		for (int i = 0; i < 4; i++) {
			deck.addCard(new FavorCard(), 0);
			deck.addCard(new ShuffleCard(), 0);
			deck.addCard(new SkipCard(), 0);
			deck.addCard(new AttackCard(), 0);
		}
		
		// Fix this part in particular, doesn't account
		// for types of normal cards.
		for (int i = 0; i < 20; i++) {
			deck.addCard(new NormalCard(), 0);
		}
		
		for (int i = 0; i < 5; i++) {
			deck.addCard(new SeeTheFutureCard(), 0);
			deck.addCard(new NopeCard(), 0);
		}
	}

}
