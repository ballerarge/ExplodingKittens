
package code;

import java.util.List;

public class FavorCard extends Card implements Cloneable {

	public FavorCard() {
		this.cardID = 8;
	}

	public FavorCard(String path) {
		this();
		this.imagePath = path;
	}

	@Override
	public void cardAction(Player p1, Player p2) {
		Hand hand1 = p1.getHandManager();
		Hand hand2 = p2.getHandManager();
		List<Card> cards = hand2.getSelectedCards();
		hand1.addCards(cards);
		hand1.clearSelectedCards();
		hand2.clearSelectedCards();
	}

	@Override
	public Card clone() {
		return new FavorCard();
	}

}
