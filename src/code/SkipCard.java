
package code;

public class SkipCard extends Card implements Cloneable {
	public SkipCard() {
		this.cardID = 4;
	}

	public SkipCard(String path) {
		this();
		this.imagePath = path;
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
