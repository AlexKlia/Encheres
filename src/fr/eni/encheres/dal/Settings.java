package fr.eni.encheres.dal;

import java.io.IOException;
import java.util.Properties;

public class Settings {
	private static Properties properties;

	/**
	 * Bloc static s'exécute dès le chargement de la classe
	 */
	static {
		properties = new Properties();
		try {
			/**
			 * class.getResourceAsStream -- permet de déterminer le répertoire de la classe
			 */
			properties.load(Settings.class.getResourceAsStream("jdbc.properties"));
			// properties.loadFromXML(in); -- avec un fichier XML
		} catch (IOException e) {
			new DALException(e.getMessage());
		}
	}

	/**
	 *
	 * @param key
	 * @return la propriété associée à la clef
	 */
	public static String getProperty(String key) {
		return properties.getProperty(key, null);
	}

}
