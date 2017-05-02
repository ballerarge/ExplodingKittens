
package code;

public class SkipCard extends Card {
	public SkipCard() {
		this.cardID = 4;
	}

	@Override
	public void cardAction(Player p1, Player p2) {
		TurnManager.getInstance().endTurnWithoutDraw();
	}

	@Override
	public SkipCard clone() {
		return new SkipCard();
	}
}
