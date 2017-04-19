
package exceptions;

public class CardDoesNotExistException extends RuntimeException {

	public CardDoesNotExistException() {
		super();
	}

	public CardDoesNotExistException(String message) {
		super(message);
	}

}
