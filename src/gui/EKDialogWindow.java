package gui;

import javax.swing.JOptionPane;

public class EKDialogWindow {

	/**
	 * Hey, that's my SSN!!!
	 */
	private static final long serialVersionUID = 2765632499215077387L;
	
	private static void displayMessage(int messageType, String title, String toDisplay, Object... args) {
		
		String formattedText = String.format(toDisplay, args);
		JOptionPane.showMessageDialog(null, formattedText, title, messageType );
	}
	
	public static void displayMessage(String title, String toDisplay, Object... args) {
		displayMessage(JOptionPane.PLAIN_MESSAGE, title, toDisplay, args);
	}

	public static void displayInfoMessage(String title, String toDisplay, Object... args) {
		displayMessage(JOptionPane.INFORMATION_MESSAGE, title, toDisplay, args);
	}
	
	public static void displayQuestionMessage(String title, String toDisplay, Object... args) {
		displayMessage(JOptionPane.QUESTION_MESSAGE, title, toDisplay, args);
	}
	
	public static void displayErrorMessage(String title, String toDisplay, Object... args) {
		displayMessage(JOptionPane.ERROR_MESSAGE, title, toDisplay, args);
	}
	
	public static void displayWarningMessage(String title, String toDisplay, Object... args) {
		displayMessage(JOptionPane.WARNING_MESSAGE, title, toDisplay, args);
	}
	
	/**
	 * This is the main method that builds the dialogs of the different types.
	 * 
	 * @param messageType
	 * 			the type of the message dialog.
	 * @param title
	 * 			title of the dialog window
	 * @param toDisplay
	 * 			text to display on the dialog
	 * @param args
	 * 			arguments to build string toDisplay
	 * @return true
	 * 			if and only if the user selected 'yes' as an answer.
	 */
	private static boolean displayYesNoDialog(int messageType, String title, String toDisplay, Object... args) {
		
		String formattedText = String.format(toDisplay, args);
		int result = JOptionPane.showConfirmDialog(null, formattedText, title, JOptionPane.YES_NO_OPTION, messageType);
		return result == JOptionPane.YES_OPTION;
	}
	
	/**
	 * A normal plain yes/no dialog.
	 * 
	 * @param title
	 * 			of the dialog
	 * @param toDisplay
	 * 			text to display
	 * @param args
	 * 			that are optional for string formatting
	 * @return true
	 * 			the user hit yes as an answer
	 */
	public static boolean displayYesNo(String title, String toDisplay, Object... args) {
		return displayYesNoDialog(JOptionPane.PLAIN_MESSAGE, title, toDisplay, args);
	}
	
	public static boolean displayYesNoQuestion(String title, String toDisplay, Object... args) {
		return displayYesNoDialog(JOptionPane.QUESTION_MESSAGE, title, toDisplay, args);
	}
	
	public static boolean displayYesNoError(String title, String toDisplay, Object... args) {
		return displayYesNoDialog(JOptionPane.ERROR_MESSAGE, title, toDisplay, args);
	}
	
	public static boolean displayYesNoInfo(String title, String toDisplay, Object... args) {
		return displayYesNoDialog(JOptionPane.INFORMATION_MESSAGE, title, toDisplay, args);
	}

	public static boolean displayYesNoWarning(String title, String toDisplay, Object... args) {
		return displayYesNoDialog(JOptionPane.WARNING_MESSAGE, title, toDisplay, args);
	}
	
	public static Object displayInputDialog(int messageType, String title, String text, Object[] options, int intialChoice) {

		return JOptionPane.showInputDialog(null, title, text, messageType, null, options, intialChoice);
	}
}
