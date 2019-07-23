package fr.alex.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Proprietes {
	private String modeDeveloppeur;
	private String nbDeCoupMax;
	private String nbDeChiffreCombinaison;

	public Proprietes() {
		try {

			Properties prop = Proprietes.load("recherchePlusMoins/ressources/config.properties");

			this.modeDeveloppeur = prop.getProperty("recherche.modeDeveloppeur");
			this.nbDeCoupMax = prop.getProperty("recherche.nbDeCoupMax");
			this.nbDeChiffreCombinaison = prop.getProperty("recherche.nbDeChiffreCombinaison");

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

	private static boolean isLetter(String val) {
		char[] proposition = val.toCharArray();
		for (int i = 0; i < proposition.length; i++) {
			if (Character.isLetter(proposition[i])) {
				return true;
			}
		}
		return false;
	}

	public String getNbDeCoupMax() {

		if (nbDeCoupMax.isEmpty() || isLetter(nbDeCoupMax) || Integer.parseInt(nbDeCoupMax) < 1) {
			nbDeCoupMax = "10";
			System.out.println(
					"la valeur du nbDeCoupMax du fichier config était manquante ou incorrect est à été remplacée par 10");
		}
		return nbDeCoupMax;
	}

	public String getModeDeveloppeur() {
		if (modeDeveloppeur.isEmpty() || isLetter(modeDeveloppeur) || Integer.parseInt(modeDeveloppeur) >= 2
				|| Integer.parseInt(modeDeveloppeur) < 0) {
			modeDeveloppeur = "0";
			System.out.println(
					"la valeur du modeDeveloppeur du fichier config était manquante ou incorrect est à été remplacée par 0");
		}
		return modeDeveloppeur;
	}

	public String getNbDeChiffreCombinaison() {
		if (nbDeChiffreCombinaison.isEmpty() || isLetter(nbDeChiffreCombinaison)
				|| Integer.parseInt(nbDeChiffreCombinaison) < 1) {
			nbDeChiffreCombinaison = "4";
			System.out.println(
					"la valeur du nbDeChiffreCombinaison du fichier config était manquante ou incorrect est à été remplacée par 4");
		}
		return nbDeChiffreCombinaison;
	}

}
