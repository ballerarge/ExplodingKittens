
package exceptions;

@SuppressWarnings("serial")
public class EmptyDiscardDeckException extends RuntimeException {
	public EmptyDiscardDeckException() {
		super();
	}

	public EmptyDiscardDeckException(String message) {
		super(message);
	}
}
