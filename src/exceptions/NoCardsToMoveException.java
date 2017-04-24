
package exceptions;

public class NoCardsToMoveException extends RuntimeException {

	public NoCardsToMoveException() {
		super();
	}

	public NoCardsToMoveException(String message) {
		super(message);
	}
}
