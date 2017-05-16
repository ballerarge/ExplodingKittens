
package code;

public abstract class Card implements Cloneable {
	protected int cardID;
	protected String imagePath;

	public int getID() {
		return this.cardID;
	}

	public String toString() {
		return this.getClass().getName();
	}

	abstract public void cardAction(Player p1, Player p2);

	abstract public Card clone();

	public String getImagePath() {
		return this.imagePath;
	}

}
