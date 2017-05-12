
package gui;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LanguageMenu {

	public String language = "English";
	public Locale locale = Locale.ENGLISH;

	public LanguageMenu() {
	}

	public Locale selectLanguage() {
		JPanel panel = new JPanel();
		JComboBox languageSelector = new JComboBox();
		languageSelector.addItem("English");
		languageSelector.addItem("Deutsche");
		panel.add(languageSelector);
		JOptionPane.showConfirmDialog(null, panel, "Language/sprache", JOptionPane.DEFAULT_OPTION);
		language = (String) languageSelector.getSelectedItem();
		if (language.equals("Deutsche"))
			locale = locale.GERMAN;
		else
			locale = locale.ENGLISH;
		return locale;
	}

	

}
