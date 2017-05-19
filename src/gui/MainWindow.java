
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.text.DefaultCaret;

import code.Card;
import code.CardFactory;
import code.DiscardDeck;
import code.Entry;
import code.Game;
import code.Log;
import code.MainDeck;
import code.NormalCard;
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

	// Game Page components
	private JButton nextTurnButton;
	private JButton playSelectedCardButton;

	private JScrollPane handScrollerPane;
	private JPanel handDisplayPanel;
	private JPanel playerDisplayPanel;
	private JPanel deckDisplayPanel;
	private JScrollPane logScrollerPane;
	private JPanel logDisplayPanel;

	private List<CardComponent> cardComponentList;

	public Locale locale;
	ResourceBundle resourceBundle;

	private List<CardComponent> selectedCards;

	public MainWindow() {
		playMeow(); // You're welcome, Mark :^)

		init(Locale.ENGLISH);

		playGameButton = new JButton(getStringFromBundle(("PLAY_GAME_BUTTON_LABEL")));
		setLanguageButton = new JButton(getStringFromBundle(("SELECT_LANGUAGE_BUTTON_LABEL")));

		nextTurnButton = new JButton(getStringFromBundle(("NEXT_TURN_BUTTON_LABEL")));
		playSelectedCardButton = new JButton(getStringFromBundle(("PLAY_SELECTED_CARD_BUTTON_LABEL")));
	}

	private void init(Locale newLocale) {
		locale = newLocale;
		resourceBundle = ResourceBundle.getBundle("resources/resources", locale);

		mainFrame = new JFrame(getStringFromBundle(("EXPLODING_KITTENS")));

		mainPanel = new JPanel();

		mainPanel.setLayout(new GridBagLayout());

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0, 1, 10, 10));

		ImageIcon image = new ImageIcon(getClass().getResource("logo.png"));
		imageLabel = new JLabel(image);

		playerDisplayPanel = new JPanel();
		playerDisplayPanel.setLayout(new GridBagLayout());

		deckDisplayPanel = new JPanel();
		deckDisplayPanel.setLayout(new GridBagLayout());

		cardComponentList = new ArrayList<CardComponent>();

		handDisplayPanel = new JPanel();
		handDisplayPanel.setLayout(new GridBagLayout());

		handScrollerPane = new JScrollPane(handDisplayPanel);
		handScrollerPane.setPreferredSize(new Dimension(170 * 5, 220));
		handDisplayPanel.setAutoscrolls(true);

		logDisplayPanel = new JPanel();
		logDisplayPanel.setLayout(new GridBagLayout());

		logScrollerPane = new JScrollPane(logDisplayPanel);
		logScrollerPane.setPreferredSize(new Dimension(170 * 5, 220));
		logDisplayPanel.setBackground(Color.WHITE);
		logDisplayPanel.setAutoscrolls(true);
	}

	public void setLocale(Locale locale) {
		this.locale = locale;

		Log.getInstance().locale = locale;

		resourceBundle = ResourceBundle.getBundle("resources/resources", locale);

		mainFrame.setTitle(getStringFromBundle(("EXPLODING_KITTENS")));

		playGameButton.setText(getStringFromBundle(("PLAY_GAME_BUTTON_LABEL")));
		setLanguageButton.setText(getStringFromBundle(("SELECT_LANGUAGE_BUTTON_LABEL")));

		nextTurnButton.setText(getStringFromBundle(("NEXT_TURN_BUTTON_LABEL")));
		playSelectedCardButton.setText(getStringFromBundle(("PLAY_SELECTED_CARD_BUTTON_LABEL")));
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
		System.out.println(locale.toString());
		init(locale);
		System.out.println(locale.toString());

		GridBagConstraints gbc = new GridBagConstraints();

		mainFrame = new JFrame(getStringFromBundle("EXPLODING_KITTENS"));
		mainFrame.setSize(1200, 1000);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Other Players
		gbc.gridx = 0;
		gbc.gridy = 0;
		mainPanel.add(playerDisplayPanel, gbc);

		// Decks
		gbc.gridx = 0;
		gbc.gridy = 1;
		mainPanel.add(deckDisplayPanel, gbc);

		// Hand
		gbc.gridx = 0;
		gbc.gridy = 2;
		mainPanel.add(handScrollerPane, gbc);

		// Buttons
		gbc.gridx = 1;
		gbc.gridy = 2;
		buttonPanel.add(playSelectedCardButton);
		buttonPanel.add(nextTurnButton);

		mainPanel.add(buttonPanel, gbc);

		// Log
		gbc.gridx = 0;
		gbc.gridy = 3;
		mainPanel.add(logScrollerPane, gbc);

		mainFrame.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		mainPanel.setMaximumSize(new Dimension(100, 100));

		mainFrame.setVisible(true);
	}

	private String getStringFromBundle(String key) {
		return ResourceBundle.getBundle("resources/resources", locale).getString(key);
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

		selectedCards = new ArrayList<CardComponent>();

		displayOtherPlayers(game.getPlayers().size() - 1, game.getPlayers(), game.getCurrentPlayer());
		displayMainDeck(MainDeck.getInstance());
		displayDiscardDeck(DiscardDeck.getInstance());
		displayHand(game.getCurrentPlayer().getHand());
		displayLog(Log.getInstance().getEntries());

		System.out.println(game.getCurrentPlayer().getHand().toString());
	}

	private void displayDiscardDeck(DiscardDeck discardDeck) {
		GridBagConstraints gbc = new GridBagConstraints();

		deckDisplayPanel.add(new JLabel("  "));
		gbc.gridx = 1;
		gbc.gridy = 0;

		ImageIcon image;

		if (discardDeck.getCardCount() > 0) {
			image = new ImageIcon(
			        getClass().getResource(discardDeck.getCards().get(discardDeck.getCardCount() - 1).getImagePath()));
		} else {
			image = new ImageIcon(getClass().getResource("EmptyDiscardDeck.png"));
		}
		Image firstImage = image.getImage();
		Image newimg = firstImage.getScaledInstance(110, 150, java.awt.Image.SCALE_SMOOTH);
		JLabel imageLabel = new JLabel(new ImageIcon(newimg));

		gbc.gridx = 2;
		gbc.gridy = 0;
		deckDisplayPanel.add(imageLabel, gbc);
		imageLabel.setVisible(true);

		deckDisplayPanel.revalidate();
		deckDisplayPanel.repaint();
		deckDisplayPanel.setVisible(true);
	}

	private void displayMainDeck(MainDeck mainDeck) {
		for (Component component : deckDisplayPanel.getComponents()) {
			if (!component.equals(deckDisplayPanel)) {
				deckDisplayPanel.remove(component);
			}
		}

		GridBagConstraints gbc = new GridBagConstraints();

		ImageIcon image;

		switch (mainDeck.getCardCount()) {
			case 1:
				image = new ImageIcon(getClass().getResource("main_deck_1.png"));
				break;
			case 2:
				image = new ImageIcon(getClass().getResource("main_deck_2.png"));
				break;
			default:
				image = new ImageIcon(getClass().getResource("main_deck_3.png"));
				break;
		}
		JLabel imageLabel = new JLabel(image);

		gbc.gridx = 0;
		gbc.gridy = 0;
		imageLabel.setVisible(true);
		deckDisplayPanel.add(imageLabel, gbc);
		deckDisplayPanel.revalidate();
		deckDisplayPanel.repaint();
	}

	private void displayOtherPlayers(int numOtherPlayers, List<Player> players, Player currentPlayer) {
		for (Component component : playerDisplayPanel.getComponents()) {
			if (!component.equals(playerDisplayPanel)) {
				playerDisplayPanel.remove(component);
			}
		}

		List<Player> otherPlayers = new ArrayList<Player>();
		for (Player player : players) {
			if (!player.equals(currentPlayer)) {
				otherPlayers.add(player);
			}
		}

		GridBagConstraints gbc = new GridBagConstraints();

		for (int i = 0; i < numOtherPlayers; i++) {

			ImageIcon image = new ImageIcon(getClass().getResource("player.png"));
			JLabel imageLabel = new JLabel(image);

			JPanel indivPanel = new JPanel();
			indivPanel.setLayout(new GridBagLayout());

			gbc.gridx = 0;
			gbc.gridy = 0;

			indivPanel.add(imageLabel, gbc);

			gbc.gridy++;

			JTextArea nameLabel = new JTextArea();
			nameLabel.setText(otherPlayers.get(i).getName());
			nameLabel.setEditable(false);

			indivPanel.add(nameLabel, gbc);

			gbc.gridx = i;
			gbc.gridy = 0;

			playerDisplayPanel.add(indivPanel, gbc);
			imageLabel.setVisible(true);
		}

		playerDisplayPanel.revalidate();
		playerDisplayPanel.repaint();
		playerDisplayPanel.setVisible(true);

		if (numOtherPlayers == 0) {
			endGame();
		}
	}

	public void endGame() {
		System.out.println("You win!");
		exitGame();
	}

	private void displayHand(List<Card> list) {
		for (Component component : handDisplayPanel.getComponents()) {
			if (!component.equals(handDisplayPanel)) {
				component.setVisible(false);
				handDisplayPanel.remove(component);
			}
		}

		for (Component component : cardComponentList) {
			handDisplayPanel.remove(component);
		}

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;

		for (Card card : list) {
			CardComponent comp = new CardComponent(card);

			gbc.gridx++;

			comp.setMaximumSize(new Dimension(40, 80));
			handDisplayPanel.add(comp, gbc);
			cardComponentList.add(comp);
			comp.setVisible(true);
		}
		handDisplayPanel.setVisible(true);
	}

	private void displayLog(ArrayList<Entry> entries) {
		for (Component component : logDisplayPanel.getComponents()) {
			if (!component.equals(logDisplayPanel)) {
				component.setVisible(false);
				logDisplayPanel.remove(component);
			}
		}

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;

		for (Entry entry : entries) {
			JTextPane entryArea = new JTextPane();
			DefaultCaret caret = (DefaultCaret) entryArea.getCaret();
			caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
			entryArea.setText(entry.getMessage());
			logDisplayPanel.add(entryArea, gbc);
			entryArea.setEditable(false);
			entryArea.setVisible(true);
			gbc.gridy++;
		}
		logDisplayPanel.setVisible(true);
		// logDisplayPanel.
	}

	public void hideHand() {
		handDisplayPanel.setVisible(false);
	}

	public void unhideHand() {
		handDisplayPanel.setVisible(true);
	}

	public List<CardComponent> getDisplayedCards() {
		return cardComponentList;
	}

	public void toggleSelected(CardComponent component) {
		if (selectedCards.contains(component)) {
			selectedCards.remove(component);
			component.toggleSelected();
		} else if (component.getCard().getID() == CardFactory.NORMAL_CARD && onlyNormalCardsSelected()) {
			selectedCards.add(component);
			component.toggleSelected();
		} else if (selectedCards.size() == 0 && !(component.getCard().getID() == CardFactory.DEFUSE_CARD
		        || component.getCard().getID() == CardFactory.NOPE_CARD)) {
			selectedCards.add(component);
			component.toggleSelected();
		}
	}

	private boolean onlyNormalCardsSelected() {
		if (selectedCards.size() == 0) {
			return true;
		}

		for (CardComponent component : selectedCards) {
			if (!(component.getCard() instanceof NormalCard)) {
				return false;
			}
		}

		return true;
	}

	public List<CardComponent> getSelectedCards() {
		return selectedCards;
	}

	private void playMeow() {
		try {
			File file = new File(System.getProperty("user.dir") + "/src/gui/wav/" + "cat.wav");
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			Clip audioClip = (Clip) AudioSystem.getLine(info);

			audioClip.open(audioStream);
			audioClip.start();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());;
		}
	}

	public void clearSelected() {
		for (CardComponent component : selectedCards) {
			component.toggleSelected();
		}
		selectedCards = new ArrayList<CardComponent>();
	}
}
