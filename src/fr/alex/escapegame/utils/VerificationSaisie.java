package fr.alex.escapegame.utils;

import java.util.Scanner;

/**
 * classe permettant de vérifier les différentes saisies faite par le joueur
 * @author alex
 *
 */
public class VerificationSaisie {
		
	protected final String NB_DE_CHIFFRE_COMBINAISON = Proprietes.getInstance().getNbDeChiffreCombinaison();
	public static boolean SiEntrerClavierEstVrai = false;
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
			reponseDonner = "\nIl faut rentrer un et uniquement\nun chiffre compris entre 1 et 4 : ";
		}

		for (int i = 0; i < entrerClavier.length(); i++) {
			char chiffre = entrerClavier.charAt(i);
			if ((byte) chiffre < 49 || (byte) chiffre > 52) {
				SiEntrerClavierEstVrai = true;
				reponseDonner = "\nIl faut entrer un chiffre compris entre 1 et 4 : ";
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
			return reponseDonner;
		}

		for (int i = 0; i < entrerClavier.length(); i++) {
			char chiffre = entrerClavier.charAt(i);
			if ((byte) chiffre != 77 && (byte) chiffre != 79 && (byte) chiffre != 81) {
				SiEntrerClavierEstVrai = true;
				reponseDonner = "\nIl faut rentrer seulement\n les lettres 'O' , 'M' ou 'Q' : ";
				return reponseDonner;
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
			reponseDonner = "\nIl faut rentrer une combinaison contenant " + Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON) + " chiffres\net contenant uniquement des chiffres : ";
			return reponseDonner;
		}

		for (int i = 0; i < entrerClavier.length(); i++) {
			char chiffre = entrerClavier.charAt(i);
			if ((byte) chiffre < 48 || (byte) chiffre > 57) {
				SiEntrerClavierEstVrai = true;
				reponseDonner = "\nIl faut entrer un chiffre entre 0 et 9 : ";
				return reponseDonner;
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
			reponseDonner = "\nIl faut rentrer une combinaison contenant : " + Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON)
					+ " indices\net uniquement des indices : ";
		}

		for (int i = 0; i < entrerClavier.length(); i++) {
			char chiffre = entrerClavier.charAt(i);
			if ((byte) chiffre != 43 && (byte) chiffre != 45 && (byte) chiffre != 61) {
				SiEntrerClavierEstVrai = true;
				reponseDonner = "\nIl faut entrer uniquement\nles signes suivant \"+\" , \"-\" , \"=\" : ";
			}
		}
		
		return reponseDonner;
	}
}
