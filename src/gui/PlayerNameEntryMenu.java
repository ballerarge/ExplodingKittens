
package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayerNameEntryMenu {
	public static List<String> getPlayerNames(Locale locale, int numPlayers) {
		List<String> playerNames = new ArrayList<String>();

		ResourceBundle rb = ResourceBundle.getBundle("resources/resources", locale);

		ArrayList<JTextField> nameFields = new ArrayList<JTextField>();

		JPanel myPanel = new JPanel();
		myPanel.setLayout(new GridLayout(0, 1, numPlayers, numPlayers));

		for (int i = 0; i < numPlayers; i++) {
			JTextField nameField = new JTextField(20);
			nameFields.add(nameField);
			myPanel.add(new JLabel(getString(rb, "PLAYER_LABEL") + " " + (i + 1) + " " + getString(rb, "NAME_LABEL")));
			myPanel.add(nameField);
		}

		if (JOptionPane.showConfirmDialog(null, myPanel, getString(rb, "PLAYER_NAME_PANEL_MESSAGE"),
		        JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_CANCEL_OPTION) {
			return null;
		}

		for (JTextField textField : nameFields) {
			if (textField.getText().isEmpty()) {
				playerNames.add("Default");
			} else {
				playerNames.add(textField.getText());
			}
		}

		return playerNames;
	}

	private static String getString(ResourceBundle bundle, String key) {
		return bundle.getString(key);
	}
}
