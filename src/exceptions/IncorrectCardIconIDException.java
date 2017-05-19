
package exceptions;

public class IncorrectCardIconIDException extends Exception {

	private static final long serialVersionUID = -7614125436538363754L;

	public IncorrectCardIconIDException() {
		super();
	}

	public IncorrectCardIconIDException(String message) {
		super(message);
	}
}
