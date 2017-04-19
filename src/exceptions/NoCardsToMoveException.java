
package exceptions;

public class NoCardsToMoveException extends Exception {

	public NoCardsToMoveException() {
		super();
	}

	public NoCardsToMoveException(String message) {
		super(message);
	}
}
