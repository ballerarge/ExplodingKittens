package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import gui.EKDialogWindow;

public class EKDialogWindowTest {

	@Test
	public void testDialogWindowCreation() {
		
		String test = "This is a test";
		
		EKDialogWindow.displayMessage("test", "Hello");
		EKDialogWindow.displayMessage("title test", "test %s", test);
		EKDialogWindow.displayInfoMessage("information!", "have some knowledge!");
		EKDialogWindow.displayQuestionMessage("what?", "why?");
		EKDialogWindow.displayErrorMessage("this is an error", "error!");
		EKDialogWindow.displayWarningMessage("warning!", "you have been warned!");
	}

	@Test
	public void testYesNoWindowCreation() {
		
		EKDialogWindow.displayYesNo("test", "Hello");
		EKDialogWindow.displayYesNoQuestion("title test", "tests");
		EKDialogWindow.displayYesNoInfo("information!", "have some knowledge!");
		EKDialogWindow.displayYesNoQuestion("what?", "why?");
		EKDialogWindow.displayYesNoError("this is an error", "error!");
		EKDialogWindow.displayYesNoWarning("warning!", "you have been warned!");
	}
	
	
}
