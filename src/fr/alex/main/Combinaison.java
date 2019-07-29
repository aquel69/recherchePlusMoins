package fr.alex.main;

public class Combinaison {
	
	Proprietes propriete;
	private final String NB_DE_CHIFFRE_COMBINAISON;

	private byte[] chiffres = null;

	/**
	 * constructeur de la classe Combinaison 
	 * permet de creer les objets combinaison
	 * 
	 * @param chiffres tableau de byte contenant dans chaque emplacement un chiffre de la combinaison
	 * la longueur du tableau dépend du nombre de chiffre entrer dans le fichier config.properties
	 */
	public Combinaison(byte[] chiffres) {
		this.chiffres = chiffres;
		propriete = new Proprietes();
		NB_DE_CHIFFRE_COMBINAISON = propriete.getNbDeChiffreCombinaison();
	}
	
	/**
	 * la fonction permet de connaitre les indices correspondant à la proposition
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
	 * la fonction convertit le tableau byte en un String
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
