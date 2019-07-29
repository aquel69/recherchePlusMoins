package fr.alex.main;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * classe permettant de vérifier les différentes saisies faite par le joueur
 * @author alex
 *
 */
public class VerificationSaisie {
	static Logger logger = LogManager.getLogger(Main.class);
	Proprietes propriete = new Proprietes();
	protected final String NB_DE_CHIFFRE_COMBINAISON = propriete.getNbDeChiffreCombinaison();

	static boolean SiEntrerClavierEstVrai = false;
	Scanner sc = new Scanner(System.in);

	
	/**
	 * verification de la saisie pour la selection du mode de jeux
	 * @param entrerClavier par le joueur de type String
	 * @return une variable de type String donnant le type de l'erreur rencontré à la saisie
	 */
	public String erreurDeSaisieModeDeJeux(String entrerClavier) {
		SiEntrerClavierEstVrai = false;
		String reponseDonner = "";

		if (entrerClavier.length() != 1 || entrerClavier.isEmpty()) {
			SiEntrerClavierEstVrai = true;
			reponseDonner = "Il faut rentrer un et uniquement un chiffre compris entre 1 et 4 : ";
			logger.info("erreur saisie du mode de jeu, le joueur a rentré : " + entrerClavier);
		}

		for (int i = 0; i < entrerClavier.length(); i++) {
			char chiffre = entrerClavier.charAt(i);
			if ((byte) chiffre < 49 || (byte) chiffre > 52) {
				SiEntrerClavierEstVrai = true;
				reponseDonner = "Il faut entrer un chiffre compris entre 1 et 4 : ";
				logger.info("erreur saisie du mode de jeu, le joueur a rentré : " + entrerClavier);
			}
		}

		return reponseDonner;
	}

	
	/**
	 * verification de la saisie pour le menu fin de partie
	 * @param entrerClavier par le joueur de type String
	 * @return une variable de type String donnant le type de l'erreur rencontré à la saisie
	 */
	public String erreurDeSaisieFinDePartie(String entrerClavier) {
		SiEntrerClavierEstVrai = false;
		String reponseDonner = "";

		if (entrerClavier.length() != 1 || entrerClavier.isEmpty()) {
			SiEntrerClavierEstVrai = true;
			reponseDonner = "Il faut entrer un caractère : ";
			logger.info("erreur saisie du choix en fin de partie, le joueur a rentré : " + entrerClavier);
		}

		for (int i = 0; i < entrerClavier.length(); i++) {
			char chiffre = entrerClavier.charAt(i);
			if ((byte) chiffre != 77 && (byte) chiffre != 79 && (byte) chiffre != 81) {
				SiEntrerClavierEstVrai = true;
				reponseDonner = "Il faut rentrer seulement les lettres 'O' , 'M' ou 'Q' : ";
				logger.info("erreur saisie du choix en fin de partie, le joueur a rentré : " + entrerClavier);
			}
		}
		return reponseDonner;
	}

	/**
	 * verification de la saisie pour la saisie des chiffres
	 * @param entrerClavier par le joueur de type String
	 * @return une variable de type String donnant le type de l'erreur rencontré à la saisie
	 */
	public String erreurDeSaisieCombinaison(String entrerClavier) {
		SiEntrerClavierEstVrai = false;
		String reponseDonner = "";

		if (entrerClavier.length() != Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON) || entrerClavier.isEmpty()) {
			SiEntrerClavierEstVrai = true;
			reponseDonner = "Il faut rentrer une combinaison contenant à " + Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON) + " chiffres et contenant uniquement des chiffres : ";
			logger.info("erreur saisie de la combinaison, le joueur a rentré : " + entrerClavier);
		}

		for (int i = 0; i < entrerClavier.length(); i++) {
			char chiffre = entrerClavier.charAt(i);
			if ((byte) chiffre < 48 || (byte) chiffre > 57) {
				SiEntrerClavierEstVrai = true;
				reponseDonner = "Il faut entrer un chiffre entre 0 et 9 : ";
				logger.info("erreur saisie de la combinaison, le joueur a rentré : " + entrerClavier);
			}
		}

		return reponseDonner;
	}

	/**
	 * verification de la saisie  pour les indices
	 * @param entrerClavier par le joueur de type String
	 * @return une variable de type String donnant le type de l'erreur rencontré à la saisie
	 */
	public String erreurDeSaisieIndice(String entrerClavier) {
		SiEntrerClavierEstVrai = false;
		String reponseDonner = "";

		if (entrerClavier.length() != Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON) || entrerClavier.isEmpty()) {
			SiEntrerClavierEstVrai = true;
			reponseDonner = "Il faut rentrer une combinaison contenant : " + Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON)
					+ " indices et uniquement des indices : ";
			logger.info("erreur saisie des indices, le joueur a rentré : " + entrerClavier);
			return reponseDonner;
		}

		for (int i = 0; i < entrerClavier.length(); i++) {
			char chiffre = entrerClavier.charAt(i);
			if ((byte) chiffre != 43 && (byte) chiffre != 45 && (byte) chiffre != 61) {
				SiEntrerClavierEstVrai = true;
				reponseDonner = "Il faut entrer uniquement les signes suivant \"+\" , \"-\" , \"=\" : ";
				logger.info("erreur saisie des indices, le joueur a rentré : " + entrerClavier);
			}
		}

		return reponseDonner;
	}
}
