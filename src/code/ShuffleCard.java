
package code;

public class ShuffleCard extends Card {
	public ShuffleCard() {
		this.cardID = 6;
	}

	@Override
	public void cardAction(Player p1, Player p2) {
		MainDeck mainDeck=MainDeck.getInstance();
		mainDeck.shuffleDeck();
	}
}
