package gui;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class StartingMenu {
	
	public String language="English";
	public Locale locale=Locale.ENGLISH;
	public int numberOfPlayers=2;
	
	
	public StartingMenu(){}
	
	public void selectLanguage(){
		JPanel panel = new JPanel();
		JComboBox languageSelector = new JComboBox();
		languageSelector.addItem("English");
		languageSelector.addItem("Deutsche");
		panel.add(languageSelector);
		JOptionPane.showConfirmDialog(null, panel,"Language/sprache",JOptionPane.DEFAULT_OPTION);
		language =(String) languageSelector.getSelectedItem();
		if (language.equals("English"))
			locale=locale.ENGLISH;
		else
			locale=locale.GERMAN;
	}
	
	public void selectNumberofPlayers(){
		JPanel panel = new JPanel();
		JComboBox numberSelector = new JComboBox();
		numberSelector.addItem(2);
		numberSelector.addItem(3);
		numberSelector.addItem(4);
		numberSelector.addItem(5);
		panel.add(numberSelector);
		String option="";
		ResourceBundle bundle = ResourceBundle.getBundle("resources/resources",locale);
		option = bundle.getString("NUMBER_OF_PLAYERS");
		JOptionPane.showConfirmDialog(null, panel,option,JOptionPane.DEFAULT_OPTION);
		numberOfPlayers = (int) numberSelector.getSelectedItem();
		
		
	}
	
	
}
