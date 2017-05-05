
package exceptions;

@SuppressWarnings("serial")
public class InvalidNopeTargetException extends RuntimeException {
	public InvalidNopeTargetException() {
		super();
	}

	public InvalidNopeTargetException(String message) {
		super(message);
	}
}
