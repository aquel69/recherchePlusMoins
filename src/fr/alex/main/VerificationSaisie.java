package fr.alex.main;

import java.util.Scanner;

public class VerificationSaisie {
	Proprietes propriete = new Proprietes();
	protected final String NB_DE_CHIFFRE_COMBINAISON = propriete.getNbDeChiffreCombinaison();

	static boolean SiEntrerClavierEstVrai = false;
	Scanner sc = new Scanner(System.in);

	// verification de la saisie pour la selection du mode de jeux
	public String erreurDeSaisieModeDeJeux(String entrerClavier) {
		SiEntrerClavierEstVrai = false;
		String reponseDonner = "";

		if (entrerClavier.length() != 1 || entrerClavier.isEmpty()) {
			SiEntrerClavierEstVrai = true;
			reponseDonner = "Il faut rentrer un et uniquement un chiffre compris entre 1 et 4 : ";
		}

		for (int i = 0; i < entrerClavier.length(); i++) {
			char chiffre = entrerClavier.charAt(i);
			if ((byte) chiffre < 49 || (byte) chiffre > 52) {
				SiEntrerClavierEstVrai = true;
				reponseDonner = "Il faut entrer un chiffre compris entre 1 et 4 : ";
			}
		}

		return reponseDonner;
	}

	// verificaton de la saisie pour le menu fin de partie
	public String erreurDeSaisieFinDePartie(String entrerClavier) {
		SiEntrerClavierEstVrai = false;
		String reponseDonner = "";

		if (entrerClavier.length() != 1 || entrerClavier.isEmpty()) {
			SiEntrerClavierEstVrai = true;
			reponseDonner = "Il faut entrer un caractère : ";
		}

		for (int i = 0; i < entrerClavier.length(); i++) {
			char chiffre = entrerClavier.charAt(i);
			if ((byte) chiffre != 77 && (byte) chiffre != 79 && (byte) chiffre != 81) {
				SiEntrerClavierEstVrai = true;
				reponseDonner = "Il faut rentrer seulement les lettres 'O' , 'M' ou 'Q' : ";
			}
		}
		return reponseDonner;
	}

	// verification de la saisie pour la saisie des chiffres
	public String erreurDeSaisieCombinaison(String entrerClavier) {
		SiEntrerClavierEstVrai = false;
		String reponseDonner = "";

		if (entrerClavier.length() != Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON) || entrerClavier.isEmpty()) {
			SiEntrerClavierEstVrai = true;
			reponseDonner = "Il faut rentrer une combinaison contenant à " + Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON)
					+ " chiffres et contenant uniquement des chiffres : ";
		}

		for (int i = 0; i < entrerClavier.length(); i++) {
			char chiffre = entrerClavier.charAt(i);
			if ((byte) chiffre < 48 || (byte) chiffre > 57) {
				SiEntrerClavierEstVrai = true;
				reponseDonner = "Il faut entrer un chiffre entre 0 et 9 : ";
			}
		}

		return reponseDonner;
	}

	// verification de la saisie pour les indices
	public String erreurDeSaisieIndice(String entrerClavier) {
		SiEntrerClavierEstVrai = false;
		String reponseDonner = "";

		if (entrerClavier.length() != Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON) || entrerClavier.isEmpty()) {
			SiEntrerClavierEstVrai = true;
			reponseDonner = "Il faut rentrer une combinaison contenant : " + Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON)
					+ " indices et uniquement des indices : ";
			return reponseDonner;
		}

		for (int i = 0; i < entrerClavier.length(); i++) {
			char chiffre = entrerClavier.charAt(i);
			if ((byte) chiffre != 43 && (byte) chiffre != 45 && (byte) chiffre != 61) {
				SiEntrerClavierEstVrai = true;
				reponseDonner = "Il faut entrer uniquement les signes suivant \"+\" , \"-\" , \"=\" : ";
			}
		}

		return reponseDonner;
	}
}
