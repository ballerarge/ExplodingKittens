
package code;

public class CardFactory {
	public final static int NORMAL_CARD = 0;

	public CardFactory() {

	}

	public Card createCard(int cardID) {
		return new NormalCard();
	}
}
