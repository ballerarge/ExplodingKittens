
package gui;

import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.sun.glass.events.WindowEvent;

public class MainWindow {
	private JFrame mainFrame;

	private JPanel mainPanel;

	private JPanel buttonPanel;
	private JButton setLanguageButton;
	private JButton playGameButton;

	public Locale locale;
	ResourceBundle resourceBundle;

	public MainWindow() {
		locale = Locale.ENGLISH;
		resourceBundle = ResourceBundle.getBundle("resources/resources", locale);

		mainFrame = new JFrame(resourceBundle.getString("EXPLODING_KITTENS"));

		mainPanel = new JPanel();
		buttonPanel = new JPanel();

		playGameButton = new JButton(resourceBundle.getString("PLAY_GAME_BUTTON_LABEL"));
		setLanguageButton = new JButton(resourceBundle.getString("SELECT_LANGUAGE_BUTTON_LABEL"));
	}

	public void setLocale(Locale locale) {
		this.locale = locale;

		resourceBundle = ResourceBundle.getBundle("resources/resources", locale);

		mainFrame.setTitle(resourceBundle.getString("EXPLODING_KITTENS"));

		playGameButton.setText(resourceBundle.getString("PLAY_GAME_BUTTON_LABEL"));
		setLanguageButton.setText(resourceBundle.getString("SELECT_LANGUAGE_BUTTON_LABEL"));
	}

	private void open() {
		mainFrame = new JFrame("Exploding Kittens");
		mainFrame.setSize(1200, 1000);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		mainFrame.add(mainPanel);

		mainPanel.add(playGameButton);
		mainPanel.add(setLanguageButton);

		mainFrame.setVisible(true);
	}

	public void openStartWindow() {
		open();
	}

	public void setPlayGameListener(ActionListener listener) {
		for (ActionListener lstnr : playGameButton.getListeners(ActionListener.class)) {
			playGameButton.removeActionListener(lstnr);
		}

		playGameButton.addActionListener(listener);
	}

	public void setSelectLanguageListener(ActionListener listener) {
		for (ActionListener lstnr : setLanguageButton.getListeners(ActionListener.class)) {
			setLanguageButton.removeActionListener(lstnr);
		}

		setLanguageButton.addActionListener(listener);
	}

	public void exitGame() {
		mainFrame.setVisible(false);
		mainFrame.dispose();
	}
}
