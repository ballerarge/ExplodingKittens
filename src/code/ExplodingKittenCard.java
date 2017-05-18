
package code;

public class ExplodingKittenCard extends Card implements Cloneable {

	PlayerManager playerManager;
	TurnManager turnManager;

	public ExplodingKittenCard() {
		this.cardID = 5;
		turnManager = TurnManager.getInstance();
		playerManager = turnManager.getPlayerManager();
	}

	@Override
	public void cardAction(Player p1, Player p2) {
		turnManager.makeCurrentPlayerLose();
	}

	@Override
	public Card clone() {
		return new ExplodingKittenCard();
	}
}
