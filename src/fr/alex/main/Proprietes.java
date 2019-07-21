package fr.alex.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Proprietes {
	private String modeDeveloppeur;
	private String nbDeCoupMax;
	private String getNbDeChiffreCombinaison;

	public Proprietes() {
		try {
			Properties prop = Proprietes.load("recherchePlusMoins/ressources/config.properties");

			this.modeDeveloppeur = prop.getProperty("recherche.modeDeveloppeur");
			this.nbDeCoupMax = prop.getProperty("recherche.nbDeCoupMax");
			this.getNbDeChiffreCombinaison = prop.getProperty("recherche.nbDeChiffreCombinaison");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Charge la liste des propriétés contenu dans le fichier spécifié
	 * 
	 * @param filenam
	 *            le fichier contenant les propriétés
	 * @return un objet Properties contenant les propriétés du fichier
	 */
	public static Properties load(String filename) throws IOException {
		Properties properties = new Properties();

		FileInputStream input = new FileInputStream(filename);
		try {

			properties.load(input);
			return properties;

		}

		finally {

			input.close();

		}
	}

	public String getNbDeCoupMax() {
		return nbDeCoupMax;
	}

	public String getModeDeveloppeur() {
		return modeDeveloppeur;
	}

	public String getNbDeChiffreCombinaison() {
		return getNbDeChiffreCombinaison;
	}

}
