package gui;

import javax.swing.JOptionPane;

public class EKDialogWindow extends JOptionPane {

	private static void displayMessage(int messageType, String title, String toDisplay, Object... args) {
		
		String formattedText = String.format(toDisplay, args);
		showMessageDialog(null, formattedText, title, messageType );
	}
	
	public static void displayMessage(String title, String toDisplay, Object... args) {
		displayMessage(PLAIN_MESSAGE, title, toDisplay, args);
	}

	public static void displayInfoMessage(String title, String toDisplay, Object... args) {
		displayMessage(INFORMATION_MESSAGE, title, toDisplay, args);
	}
	
	public static void displayQuestionMessage(String title, String toDisplay, Object... args) {
		displayMessage(QUESTION_MESSAGE, title, toDisplay, args);
	}
	
	public static void displayErrorMessage(String title, String toDisplay, Object... args) {
		displayMessage(ERROR_MESSAGE, title, toDisplay, args);
	}
	
	public static void displayWarningMessage(String title, String toDisplay, Object... args) {
		displayMessage(WARNING_MESSAGE, title, toDisplay, args);
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
		int result = showConfirmDialog(null, formattedText, title, YES_NO_OPTION, messageType);
		return result == YES_OPTION;
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
		return displayYesNoDialog(PLAIN_MESSAGE, title, toDisplay, args);
	}
	
	public static boolean displayYesNoQuestion(String title, String toDisplay, Object... args) {
		return displayYesNoDialog(QUESTION_MESSAGE, title, toDisplay, args);
	}
	
	public static boolean displayYesNoError(String title, String toDisplay, Object... args) {
		return displayYesNoDialog(ERROR_MESSAGE, title, toDisplay, args);
	}
	
	public static boolean displayYesNoInfo(String title, String toDisplay, Object... args) {
		return displayYesNoDialog(INFORMATION_MESSAGE, title, toDisplay, args);
	}

	public static boolean displayYesNoWarning(String title, String toDisplay, Object... args) {
		return displayYesNoDialog(WARNING_MESSAGE, title, toDisplay, args);
	}
}
