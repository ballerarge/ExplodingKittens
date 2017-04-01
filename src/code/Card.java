
package code;

public abstract class Card {
	protected int cardID;

	public int getID() {
		return this.cardID;
	}

	public String toString() {
		return this.getClass().getName();
	}

	abstract public void cardAction(Player p1, Player p2);

}
