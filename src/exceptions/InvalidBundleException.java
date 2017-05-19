
package exceptions;

public class InvalidBundleException extends Exception {
	private static final long serialVersionUID = 1839944776289369467L;

	public InvalidBundleException() {
		super();
	}

	public InvalidBundleException(String message) {
		super(message);
	}
}
