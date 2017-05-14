
package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import code.Card;
import code.Game;
import code.Player;

public class MainWindow {
	// Main Window Frame
	private JFrame mainFrame;

	// Main Panel
	private JPanel mainPanel;

	// Button Panel
	private JPanel buttonPanel;

	// Start Page components
	private JButton setLanguageButton;
	private JButton playGameButton;

	private JLabel imageLabel;

	// Main Page components
	private JButton nextTurnButton;
	private JButton playSelectedCardButton;

	public Locale locale;
	ResourceBundle resourceBundle;

	public MainWindow() {
		init();

		playGameButton = new JButton(resourceBundle.getString("PLAY_GAME_BUTTON_LABEL"));
		setLanguageButton = new JButton(resourceBundle.getString("SELECT_LANGUAGE_BUTTON_LABEL"));

		nextTurnButton = new JButton(resourceBundle.getString("NEXT_TURN_BUTTON_LABEL"));
		playSelectedCardButton = new JButton(resourceBundle.getString("PLAY_SELECTED_CARD_BUTTON_LABEL"));
	}

	private void init() {
		locale = Locale.ENGLISH;
		resourceBundle = ResourceBundle.getBundle("resources/resources", locale);

		mainFrame = new JFrame(resourceBundle.getString("EXPLODING_KITTENS"));

		mainPanel = new JPanel();

		mainPanel.setLayout(new GridBagLayout());

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0, 1, 10, 10));

		ImageIcon image = new ImageIcon(getClass().getResource("logo.png"));
		imageLabel = new JLabel(image);
	}

	public void setLocale(Locale locale) {
		this.locale = locale;

		resourceBundle = ResourceBundle.getBundle("resources/resources", locale);

		mainFrame.setTitle(resourceBundle.getString("EXPLODING_KITTENS"));

		playGameButton.setText(resourceBundle.getString("PLAY_GAME_BUTTON_LABEL"));
		setLanguageButton.setText(resourceBundle.getString("SELECT_LANGUAGE_BUTTON_LABEL"));
	}

	private void open() {
		GridBagConstraints gbc = new GridBagConstraints();

		mainFrame = new JFrame("Exploding Kittens");
		mainFrame.setSize(1200, 1000);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Image
		gbc.gridx = 0;
		gbc.gridy = 0;
		mainPanel.add(imageLabel, gbc);

		// Buttons
		gbc.gridx = 0;
		gbc.gridy = 1;
		buttonPanel.add(playGameButton);
		buttonPanel.add(setLanguageButton);

		mainPanel.add(buttonPanel, gbc);

		mainFrame.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		mainPanel.setMaximumSize(new Dimension(100, 100));

		mainFrame.setVisible(true);
	}

	public void openStartWindow() {
		open();
	}

	public void openGameWindow() {
		mainFrame.setVisible(false);

		init();

		GridBagConstraints gbc = new GridBagConstraints();

		mainFrame = new JFrame("Exploding Kittens");
		mainFrame.setSize(1200, 1000);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Buttons
		gbc.gridx = 0;
		gbc.gridy = 1;
		buttonPanel.add(playSelectedCardButton);
		buttonPanel.add(nextTurnButton);

		mainPanel.add(buttonPanel, gbc);

		mainFrame.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		mainPanel.setMaximumSize(new Dimension(100, 100));

		mainFrame.setVisible(true);
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

	public void setNextTurnListener(ActionListener listener) {
		for (ActionListener lstnr : nextTurnButton.getListeners(ActionListener.class)) {
			nextTurnButton.removeActionListener(lstnr);
		}

		nextTurnButton.addActionListener(listener);
	}

	public void setPlaySelectedCardListener(ActionListener listener) {
		for (ActionListener lstnr : playSelectedCardButton.getListeners(ActionListener.class)) {
			playSelectedCardButton.removeActionListener(lstnr);
		}

		playSelectedCardButton.addActionListener(listener);
	}

	public void exitGame() {
		mainFrame.setVisible(false);
		mainFrame.dispose();
	}

	public void displayGameState(Game game) {
		System.out.printf("%s's turn.\n\t", game.getCurrentPlayer().getName());

		System.out.println(game.getCurrentPlayer().getHand().toString());
	}
}
