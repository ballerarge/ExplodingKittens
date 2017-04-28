
package code;

public class ScryCard extends Card {
	public ScryCard() {
		this.cardID = 7;
	}

	@Override
	public void cardAction(Player p1, Player p2) {

	}

	@Override
	public ScryCard clone() {
		return new ScryCard();
	}
}
