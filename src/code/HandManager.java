package code;

import java.util.ArrayList;
import java.util.List;

public class HandManager {

	private List<Card> hand = new ArrayList<Card>();
	
	public HandManager() {
		
	}

	public void draw() {
		hand.add(new Card());
	}

	public List<Card> getHand() {
		return hand;
	}

	
	
}
