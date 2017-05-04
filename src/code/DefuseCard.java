
package code;

import java.util.Stack;

public class DefuseCard extends Card {
	public DefuseCard() {
		this.cardID = 2;
	}

	@Override
	public void cardAction(Player p1, Player p2) {
		CardStack.getInstance().setStack(new Stack<Card>());
	}

	@Override
	public DefuseCard clone() {
		return new DefuseCard();
	}
}
