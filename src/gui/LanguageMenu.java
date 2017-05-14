
package gui;

import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;

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
		JComboBox<String> languageSelector = new JComboBox<String>();
		ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/resources", locale);

		Set<ResourceBundle> bundles = getResourceBundles("resources/resources");

		for (ResourceBundle bundle : bundles) {
			languageSelector.addItem(bundle.getString("LANGUAGE_NAME"));
		}

		panel.add(languageSelector);
		JOptionPane.showConfirmDialog(null, panel, resourceBundle.getString("LANGUAGE_SELECT_TITLE"),
		        JOptionPane.DEFAULT_OPTION);

		language = (String) languageSelector.getSelectedItem();

		for (ResourceBundle bundle : bundles) {
			if (bundle.getString("LANGUAGE_NAME").equals(language)) {
				locale = bundle.getLocale();
				break;
			}
		}

		return locale;
	}

	private static Set<ResourceBundle> getResourceBundles(String baseName) {
		Set<ResourceBundle> resourceBundles = new HashSet<>();

		for (Locale locale : Locale.getAvailableLocales()) {
			try {
				resourceBundles.add(ResourceBundle.getBundle(baseName, locale));
			} catch (MissingResourceException ex) {
				// ...
			}
		}

		return Collections.unmodifiableSet(resourceBundles);
	}

}
