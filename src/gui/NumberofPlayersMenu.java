package gui;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NumberofPlayersMenu {
	
	public int numberOfPlayers=2;
	
	public int selectNumberofPlayers(Locale locale) {
		JPanel panel = new JPanel();
		JComboBox numberSelector = new JComboBox();
		numberSelector.addItem(2);
		numberSelector.addItem(3);
		numberSelector.addItem(4);
		numberSelector.addItem(5);
		panel.add(numberSelector);
		String option = "";
		ResourceBundle bundle = ResourceBundle.getBundle("resources/resources", locale);
		option = bundle.getString("NUMBER_OF_PLAYERS");
		JOptionPane.showConfirmDialog(null, panel, option, JOptionPane.DEFAULT_OPTION);
		numberOfPlayers = (int) numberSelector.getSelectedItem();
		return numberOfPlayers;
	}
}
