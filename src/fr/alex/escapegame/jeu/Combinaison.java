package fr.alex.escapegame.jeu;

import fr.alex.escapegame.utils.Proprietes;

public class Combinaison {
	
	Proprietes propriete;
	private final String NB_DE_CHIFFRE_COMBINAISON;

	private byte[] chiffres = null;

	/**
	 * Constructeur de la classe Combinaison permettant de gérer les différentes combinaisons.
	 * 
	 * @param chiffres tableau de byte contenant dans chaque emplacement un chiffre de la combinaison
	 * la longueur du tableau dépend du nombre de chiffre entrer dans le fichier config.properties
	 */
	public Combinaison(byte[] chiffres) {
		this.chiffres = chiffres;
		NB_DE_CHIFFRE_COMBINAISON = Proprietes.getInstance().getNbDeChiffreCombinaison();
	}
	
	/**
	 * La fonction permet de connaitre les indices correspondant à la proposition.
	 * @param combinaisonAttaquant de type Combinaison la combinaison du joueur qui attaque pour connaitre les indices correspondant 
	 * @return la variable de type String contenant les indices
	 */
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
	
	/**
	 * La fonction convertit le tableau byte en un String.
	 * @return la variable de type String contenant la combinaison
	 */
	public String toString() {
		String chiffreString = "";

		for (int i = 0; i < chiffres.length; i++) {

			chiffreString += chiffres[i];
		}
		return chiffreString;
	}

}
