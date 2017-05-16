package exceptions;

@SuppressWarnings("serial")
public class CardNotFoundException extends RuntimeException {

	public CardNotFoundException(String message) {
		super(message);
	}
}
