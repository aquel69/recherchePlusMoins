package fr.alex.main;

public class Combinaison {
	
	Proprietes propriete;
	private final String NB_DE_CHIFFRE_COMBINAISON;

	private byte[] chiffres = null;

	/**
	 * constructeur de la classe Combinaison 
	 * 
	 * @param chiffres
	 */
	public Combinaison(byte[] chiffres) {
		this.chiffres = chiffres;
		propriete = new Proprietes();
		NB_DE_CHIFFRE_COMBINAISON = propriete.getNbDeChiffreCombinaison();
	}

	public String Comparer(Combinaison combinaisonAttaquant) {
		String indice = "";
		String indiceTotal = "";

		for (int i = 0; i < Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON); i++) {
			if (this.chiffres[i] == combinaisonAttaquant.chiffres[i]) {
				indice = "=";
				PartieChallenger.nombreIndiceEgaleHumain++;

			} else if (this.chiffres[i] < combinaisonAttaquant.chiffres[i])
				indice = "-";
			else
				indice = "+";

			indiceTotal += indice;
		}

		if (Parties.nombreIndiceEgaleHumain != Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON))
			Parties.nombreIndiceEgaleHumain = 0;

		return indiceTotal;
	}

	public String toString() {
		String chiffreString = "";

		for (int i = 0; i < chiffres.length; i++) {

			chiffreString += chiffres[i];
		}
		return chiffreString;
	}

}
