package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.wb.swt.SWTResourceManager;

import code.Player;

public class MainWindow {

	protected Shell shlExplodingKittens;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlExplodingKittens.open();
		shlExplodingKittens.layout();
		while (!shlExplodingKittens.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlExplodingKittens = new Shell();
		shlExplodingKittens.setSize(900, 800);
		shlExplodingKittens.setText("Exploding Kittens");
		shlExplodingKittens.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		CLabel lblNewLabel = new CLabel(shlExplodingKittens, SWT.NONE);
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setImage(SWTResourceManager.getImage(MainWindow.class, "/gui/logo.png"));
		lblNewLabel.setText("");

	}

	public List<Player> getPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

}
