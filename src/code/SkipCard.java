
package code;

public class SkipCard extends Card {
	public SkipCard() {
		this.cardID = 4;
	}

	@Override
	public void cardAction(Player p1, Player p2) {
		if (p1 == null) {
			// May need to be refactored to not have null check. Only way is
			// to rewrite tests for Card Factory.
			return;
		}
		PriorityManager.getInstance().nextPlayer();
		TurnManager.getInstance().endTurnWithoutDraw();
	}

	@Override
	public SkipCard clone() {
		return new SkipCard();
	}
}
