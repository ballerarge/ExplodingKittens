
package code;

public class AttackCard extends Card {
	public AttackCard() {
		this.cardID = 3;
	}

	@Override
	public void cardAction(Player p1, Player p2) {
		TurnManager.getInstance().endTurnWithoutDrawForAttacks();
		TurnManager.getInstance().addTurnForCurrentPlayer();
	}

	@Override
	public Card clone() {
		return new AttackCard();
	}
}
