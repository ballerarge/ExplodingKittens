
package code;

public abstract class Card {
	protected int cardID;

	public int getID() {
		return this.cardID;
	}

	abstract public void cardAction(Player p1, Player p2);

}
