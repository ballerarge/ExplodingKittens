
package code;

import java.util.Stack;

public class DefuseCard extends Card {
	
	CardStack stack;
	TurnManager tm;
	
	public DefuseCard() {
		this.cardID = 2;
	}

	@Override
	public void cardAction(Player p1, Player p2) {
		stack = CardStack.getInstance();
		tm = TurnManager.getInstance();
		
		if (stack.getStack().isEmpty()) {
			tm.getCurrentPlayer().addDefuseCardToHand();
			return;
		}
		
		if (stack.getStack().elementAt(0) instanceof ExplodingKittenCard) {
			stack.setStack(new Stack<Card>());
		} else {
			tm.getCurrentPlayer().addDefuseCardToHand();
		}
	}

	@Override
	public DefuseCard clone() {
		return new DefuseCard();
	}
}
