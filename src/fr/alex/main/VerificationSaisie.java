package fr.alex.main;

import java.util.Scanner;

public class VerificationSaisie {
	static boolean SiEntrerClavierEstVrai = false;	
	Scanner sc = new Scanner(System.in);
	
	

	public String erreurDeSaisieModeDeJeux(String entrerClavier) {
		SiEntrerClavierEstVrai = false;
		String reponseDonner = "";
		
			
			if(entrerClavier.length() != 1 || entrerClavier.isEmpty()) {
				SiEntrerClavierEstVrai = true;
				reponseDonner = "il faut rentrer un seul chiffre entre 1 et 4";
			}
			
			for ( int i = 0; i < entrerClavier.length(); i++) {
				char chiffre = entrerClavier.charAt(i);
				if((byte)chiffre < 49 || (byte)chiffre > 52 ) {
					SiEntrerClavierEstVrai = true;
					reponseDonner = "il faut entrer un chiffre compris entre 1 et 4";
				}
			}
		
		
		return reponseDonner;
	}
	
	public String erreurDeSaisieFinDePartie(String entrerClavier) {
		SiEntrerClavierEstVrai = false;
		String reponseDonner = "";
		
			
			if(entrerClavier.length() != 1 || entrerClavier.isEmpty()) {
				SiEntrerClavierEstVrai = true;
				reponseDonner = "il faut entrer un caractère";
			}
			
			for ( int i = 0; i < entrerClavier.length(); i++) {
				char chiffre = entrerClavier.charAt(i);
				if((byte)chiffre != 77 && (byte)chiffre != 79 && (byte)chiffre != 81) {
					SiEntrerClavierEstVrai = true;
					reponseDonner = "il faut rentrer seulement les lettres 'O' , 'M' ou 'Q'";
				}
			}
		
			
		return reponseDonner;
	}
	
	//verification de la saisie pour la saisie des chiffres
	public String erreurDeSaisieCombinaison(String entrerClavier) {
		SiEntrerClavierEstVrai = false;
		String reponseDonner = "";
		
		if(entrerClavier.length() != 4 || entrerClavier.isEmpty()) {
			SiEntrerClavierEstVrai = true;
			reponseDonner = "il faut rentrer une combinaison contenant : " + 4 + " chiffres et uniquement des chiffres";
		}
		
		for ( int i = 0; i < entrerClavier.length(); i++) {
			char chiffre = entrerClavier.charAt(i);
			if((byte)chiffre < 48 || (byte)chiffre > 57 ) {
				SiEntrerClavierEstVrai = true;
				reponseDonner = "il faut entrer un chiffre entre 1 et 9";
			}
		}
		
		return reponseDonner;
	}
	
	public String erreurDeSaisieIndice(String entrerClavier) {
		SiEntrerClavierEstVrai = false;
		String reponseDonner = "";
		
		if(entrerClavier.length() != 4 || entrerClavier.isEmpty()) {
			SiEntrerClavierEstVrai = true;
			reponseDonner = "il faut rentrer une combinaison contenant : " + 4 + " indices et uniquement des indices";
			return reponseDonner;
		}
		
		for ( int i = 0; i < entrerClavier.length(); i++) {
			char chiffre = entrerClavier.charAt(i);
			if((byte)chiffre != 43 && (byte)chiffre != 45 && (byte)chiffre != 61)  {
				SiEntrerClavierEstVrai = true;
				reponseDonner = "il faut entrer uniquement les signes suivant \"+\" , \"-\" , \"=\"";
			}
		}
		
		return reponseDonner;
	}	
}
