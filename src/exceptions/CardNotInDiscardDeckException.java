
package exceptions;

@SuppressWarnings("serial")
public class CardNotInDiscardDeckException extends RuntimeException {
	public CardNotInDiscardDeckException() {
		super();
	}

	public CardNotInDiscardDeckException(String message) {
		super(message);
	}
}
