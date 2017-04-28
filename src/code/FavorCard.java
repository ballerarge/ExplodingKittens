
package code;

public class FavorCard extends Card {

	public FavorCard() {
		this.cardID = 8;
	}

	@Override
	public void cardAction(Player p1, Player p2) {

	}

	@Override
	public Card clone() {
		return new FavorCard();
	}

}
