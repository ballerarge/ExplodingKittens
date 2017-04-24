
package exceptions;

public class IncorrectNumberOfCardsException extends RuntimeException {

	public IncorrectNumberOfCardsException() {
		super();
	}

	public IncorrectNumberOfCardsException(String message) {
		super(message);
	}

}
