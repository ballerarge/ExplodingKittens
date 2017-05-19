
package code;

public class NormalCard extends Card implements Cloneable {
	private int cardIcon;

	public NormalCard() {
		this.cardID = 0;
	}

	public NormalCard(String path) {
		this();
		this.imagePath = path;
	}

	@Override
	public void cardAction(Player p1, Player p2) {

	}

	@Override
	public NormalCard clone() {
		return new NormalCard();
	}

	public int getIcon() {
		return this.cardIcon;
	}

	public void setIcon(int i) {
		this.cardIcon = i;
	}
}
