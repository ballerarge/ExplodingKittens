
package code;

public class NormalCard extends Card implements Cloneable {
	private int cardIcon;

	public NormalCard() {
		this.cardID = 0;
	}

	@Override
	public void cardAction(Player p1, Player p2) {

	}

	@Override
	public NormalCard clone() {
		// TODO As of now, the only field held by all sub Cards is cardID.
		// If other fields were added that can be edited, consider
		// copy constructor.
		return new NormalCard();
	}

	public int getIcon() {
		// TODO Auto-generated method stub
		return this.cardIcon;
	}

	public void setIcon(int i) {
		this.cardIcon = i;
	}
}
