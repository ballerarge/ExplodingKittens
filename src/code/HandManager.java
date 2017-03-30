package code;

import java.util.ArrayList;
import java.util.List;

public class HandManager {

	private List<Card> hand = new ArrayList<Card>();
	private MainDeck mainDeck = new MainDeck();
	
	public HandManager() {
		
	}

	public void draw() {
		hand.add(mainDeck.getTopCard());
	}

	public List<Card> getHand() {
		return hand;
	}

	
}
