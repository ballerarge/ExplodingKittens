package code;

import java.util.ArrayList;
import java.util.List;

public class HandManager {

	private List<Card> hand = new ArrayList<Card>();
	private List<Card> selectedCards = new ArrayList<Card>();
	private MainDeck mainDeck = new MainDeck();
	
	public HandManager() {
		
	}

	public void draw() {
		hand.add(mainDeck.getTopCard());
	}

	public List<Card> getHand() {
		return hand;
	}

	public void selectCard(int i) throws CardDoesNotExistException {
		
		Card toMove;
		try {
			toMove = this.hand.remove(i);
		} catch (Exception e) {
			throw new CardDoesNotExistException("The card index given is invalid!");
		}
		
		this.selectedCards.add(toMove);
		
	}

	public List<Card> getSelectedCards() {
		return this.selectedCards;
	}

	
}
