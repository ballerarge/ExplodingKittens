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
			deck.addCard(new FavorCard(), 0);
		}
	}
	
	private void initShuffleCards() {
		for (int i = 0; i < 4; i++) {
			deck.addCard(new ShuffleCard(), 0);
		}
	}
	
	private void initSkipCards() {
		for (int i = 0; i < 4; i++) {
			deck.addCard(new SkipCard(), 0);
		}
	}
	
	private void initAttackCards() {
		for (int i = 0; i < 4; i++) {
			deck.addCard(new AttackCard(), 0);
		}
	}
	
	private void initNormalCards() {
		for (int i = 0; i < 20; i++) {
			deck.addCard(new NormalCard(), 0);
		}
	}
	
	private void initNopeCards() {
		for (int i = 0; i < 5; i++) {
			deck.addCard(new NopeCard(), 0);
		}
	}
	
	private void initScryCards() {
		for (int i = 0; i < 5; i++) {
			deck.addCard(new ScryCard(), 0);
		}
	}
	
	

}
