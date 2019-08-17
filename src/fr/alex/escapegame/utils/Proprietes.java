package fr.alex.escapegame.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.alex.escapegame.EscapeGame;

/**
 * classe permettant de lire et de gérer le fichier config.properties
 * @author alex
 *
 */
public class Proprietes {
	static Logger logger = LogManager.getLogger(EscapeGame.class);
	
	private static Proprietes INSTANCE = null;
	
	private String modeDeveloppeur;
	private String nbDeCoupMax;
	private String nbDeChiffreCombinaison;
	

	/**
	 * constructeur permettant d'indiquer l'emplacement du fichier "config.properties" et d'enregistrer les données du fichier, dans des variables
	 */
	private Proprietes() {
		try {
			Properties prop = Proprietes.load("ressources/config.properties");
			
			this.modeDeveloppeur = prop.getProperty("recherche.modeDeveloppeur");
			this.nbDeCoupMax = prop.getProperty("recherche.nbDeCoupMax");
			this.nbDeChiffreCombinaison = prop.getProperty("recherche.nbDeChiffreCombinaison");

		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Charge la liste des propriétés contenu dans le fichier spécifié
	 * fonction permettant de Charger la liste des propriétés contenu dans le fichier spécifié
	 * 
	 * @param filename le fichier contenant les propriétés
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
	
	/**
	 * design pattern singleton permettant d'instancier une seul fois la classe Proprietes
	 * @return l'instance de la classe Proprietes
	 */
	public static synchronized Proprietes getInstance() {
		if(INSTANCE == null)
		{INSTANCE = new Proprietes();
		}
		
		return INSTANCE;
	}
	
	
	/**
	 * fonction permettant de savoir si le Character compris dans une chaine est une lettre ou pas
	 * @param val de type String chaîne entrée pour la vérification
	 * @return un booleen 
	 */
	private static boolean isLetter(String val) {
		char[] proposition = val.toCharArray();
		for (int i = 0; i < proposition.length; i++) {
			if (Character.isLetter(proposition[i])) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * la fonction permet de retourner le nombre de coup maximum en vérifiant si la valeur entrée dans le fichier "config.properties" est correcte 
	 * @return une variable de type String donnant le nombre de coup maximum
	 */
	public String getNbDeCoupMax() {

		if (nbDeCoupMax.isEmpty() || isLetter(nbDeCoupMax) || Integer.parseInt(nbDeCoupMax) < 1) {
			logger.warn("la valeur du nbDeCoupMax du fichier config était manquante ou incorrect est à été remplacée par 10, l'utilisateur a rentré : " + nbDeCoupMax);
			nbDeCoupMax = "10";
		}
		
		return nbDeCoupMax;
	}
	
	/**
	 * la fonction permet de retourner le nombre du mode développeur en vérifiant si la valeur entrée dans le fichier "config.properties" est correcte 
	 * @return une variable de type String donnant le nombre du mode développeur
	 */
	public String getModeDeveloppeur() {
		if (modeDeveloppeur.isEmpty() || isLetter(modeDeveloppeur) || Integer.parseInt(modeDeveloppeur) >= 2 || Integer.parseInt(modeDeveloppeur) < 0) {
			logger.warn("la valeur du modeDeveloppeur du fichier config était manquante ou incorrect est à été remplacée par 0, l'utilisateur a rentré : " + modeDeveloppeur);
			modeDeveloppeur = "0";
		}
		
		return modeDeveloppeur;
	}
	
	/**
	 * la fonction permet de retourner le nombre de chiffre compris dans la combinaison, en vérifiant si la valeur entrée dans le fichier "config.properties" est correcte 
	 * @return une variable de type String donnant le nombre de chiffre compris dans la combinaison
	 */
	public String getNbDeChiffreCombinaison() {
		if (nbDeChiffreCombinaison.isEmpty() || isLetter(nbDeChiffreCombinaison) || Integer.parseInt(nbDeChiffreCombinaison) < 1) {
			logger.warn("la valeur du nbDeChiffreCombinaison du fichier config était manquante ou incorrect est à été remplacée par 4, l'utilisateur a rentré : " + nbDeChiffreCombinaison);
			nbDeChiffreCombinaison = "4";
		}
		
		return nbDeChiffreCombinaison;
	}

}
