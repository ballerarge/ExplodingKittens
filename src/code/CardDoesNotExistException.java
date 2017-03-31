package code;

public class CardDoesNotExistException extends Exception {

	public CardDoesNotExistException() {
		super();
	}
	
	public CardDoesNotExistException(String message) {
		super(message);
	}
	
}
