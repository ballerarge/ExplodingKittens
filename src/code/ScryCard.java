
package code;

import java.util.ArrayList;
import java.util.List;

public class ScryCard extends Card implements Cloneable {

	public List<Card> cardsToReveal = new ArrayList<>();// for testing purposes,
	                                                    // might remove after
	                                                    // GUI integration

	public ScryCard() {
		this.cardID = 7;
	}

	public ScryCard(String path) {
		this();
		this.imagePath = path;
	}

	@Override
	public void cardAction(Player p1, Player p2) {
		int numberOfCardsToScry = 3;
		cardsToReveal = new ArrayList<>();// top card of deck is at
		                                  // index 0.
		MainDeck mainDeck = MainDeck.getInstance();
		if (mainDeck.getCardCount() < numberOfCardsToScry) {
			numberOfCardsToScry = mainDeck.getCardCount();
		}
		for (int i = 0; i < numberOfCardsToScry; i++) {
			cardsToReveal.add(mainDeck.getCards().get(i));
		}
		// do something with cardsToReveal later, once GUI has been integrated.
	}

	@Override
	public ScryCard clone() {
		return new ScryCard();
	}
}
