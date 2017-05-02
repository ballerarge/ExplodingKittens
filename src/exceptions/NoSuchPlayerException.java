
package exceptions;

@SuppressWarnings("serial")
public class NoSuchPlayerException extends Exception {

	public NoSuchPlayerException() {
		super();
	}

	public NoSuchPlayerException(String message) {
		super(message);
	}
}
