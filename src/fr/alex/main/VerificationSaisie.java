package fr.alex.main;

public class VerificationSaisie {
	static boolean SiEntrerClavierEstFausse = false;	
	
	public String erreurDeSaisieModeDeJeux(String entrerClavier) {
		SiEntrerClavierEstFausse = false;
		String reponseDonner = "";
		
		if(entrerClavier.length() != 1 || entrerClavier.isEmpty()) {
			SiEntrerClavierEstFausse = true;
			reponseDonner = "il faut rentrer un seul chiffre entre 1 et 4";
		}
		
		for ( int i = 0; i < entrerClavier.length(); i++) {
			char chiffre = entrerClavier.charAt(i);
			if((byte)chiffre < 49 || (byte)chiffre > 52 ) {
				SiEntrerClavierEstFausse = true;
				reponseDonner = "il faut entrer un chiffre compris entre 1 et 4";
			}
		}
		
		return reponseDonner;
	}
	
	//verification de la saisie pour la saisie des chiffres
	public String erreurDeSaisieCombinaison(String entrerClavier) {
		SiEntrerClavierEstFausse = false;
		String reponseDonner = "";
		
		if(entrerClavier.length() != 4 || entrerClavier.isEmpty()) {
			SiEntrerClavierEstFausse = true;
			reponseDonner = "il faut rentrer une combinaison contenant : " + 4 + " chiffres et uniquement des chiffres";
		}
		
		for ( int i = 0; i < entrerClavier.length(); i++) {
			char chiffre = entrerClavier.charAt(i);
			if((byte)chiffre < 48 || (byte)chiffre > 57 ) {
				SiEntrerClavierEstFausse = true;
				reponseDonner = "il faut entrer un chiffre entre 1 et 9";
			}
		}
		
		return reponseDonner;
	}
	
	public String erreurDeSaisieIndice(String entrerClavier) {
		SiEntrerClavierEstFausse = false;
		String reponseDonner = "";
		
		if(entrerClavier.length() != 4 || entrerClavier.isEmpty()) {
			SiEntrerClavierEstFausse = true;
			reponseDonner = "il faut rentrer une combinaison contenant : " + 4 + " indices et uniquement des indices";
			return reponseDonner;
		}
		
		for ( int i = 0; i < entrerClavier.length(); i++) {
			char chiffre = entrerClavier.charAt(i);
			if((byte)chiffre != 43 && (byte)chiffre != 45 && (byte)chiffre != 61)  {
				SiEntrerClavierEstFausse = true;
				reponseDonner = "il faut entrer uniquement les signes suivant \"+\" , \"-\" , \"=\"";
			}
		}
		
		return reponseDonner;
	}	
}
