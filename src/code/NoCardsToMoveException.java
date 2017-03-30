package code;

public class NoCardsToMoveException extends Exception {
	
	public NoCardsToMoveException() {
		super();
	}
	
	public NoCardsToMoveException(String message) {
		super(message);
	}
}
