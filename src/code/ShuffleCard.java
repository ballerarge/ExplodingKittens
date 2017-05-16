
package code;

public class ShuffleCard extends Card implements Cloneable {
	public ShuffleCard() {
		this.cardID = 6;
	}

	@Override
	public void cardAction(Player p1, Player p2) {
		MainDeck mainDeck=MainDeck.getInstance();
		mainDeck.shuffleDeck();
	}

	@Override
	public ShuffleCard clone() {
		return new ShuffleCard();
	}

}
