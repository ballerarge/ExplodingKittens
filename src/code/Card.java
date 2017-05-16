
package code;

public abstract class Card implements Cloneable {
	protected int cardID;
	protected String imagePath = "AttackCard1.png";

	public int getID() {
		return this.cardID;
	}

	public String toString() {
		return this.getClass().getName();
	}

	abstract public void cardAction(Player p1, Player p2);

	abstract public Card clone();

	public CharSequence getImagePath() {
		return this.imagePath;
	}

}
