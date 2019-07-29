package fr.alex.main;

import java.util.List;
import java.util.Random;

/**
 * La classe Ordinateur permet de créér un joueur de type ordinateur
 * @author alex
 *
 */
public class Ordinateur extends Joueur {

	Random random = new Random();
	byte valeurMaxEtMin[][] = new byte[2][Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON)];

	public Ordinateur(String pNom) {
		super(pNom);
	}
	
	/**
	 * 
	 * fonction permettant de générer aléatoirement une combinaison mystère
	 * 
	 * @return Combinaison mystère du joueur Ordinateur	
	 */
	public Combinaison DonnerCombinaisonMystere() {

		byte[] combinaisonByte = new byte[Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON)];
		String combinaisonString = "";
		int chiffreInt = 0;
		byte chiffreByte;

		System.out.println("Il a établi une combinaison mystère de "
				+ Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON) + " chiffres");
		for (int i = 0; i < Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON); i++) {
			chiffreInt = random.nextInt(10);
			chiffreByte = (byte) chiffreInt;
			combinaisonByte[i] = chiffreByte;
			combinaisonString = combinaisonString + String.valueOf(chiffreInt);
		}

		Combinaison combinaison = new Combinaison(combinaisonByte);
		return combinaison;

	}
	
	/**
	 * 
	 * fonction permettant que l'ordinateur propose une combinaison en fonction des indices. 
	 * La méthode dichotomique est utilisée pour l'algorithme
	 * addition de la valeur mini et maxi divisé par deux
	 * 
	 * @return Combinaison proposée par l'Ordinateur en fonction des indices donnés par le joueur humain
	 */
	public Combinaison ProposerCombinaison(List<Combinaison> listeDesPropositionDeCombinaison, List<String> indices) {
		byte[] combinaisonPropose = new byte[Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON)];

		for (int i = 0; i < Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON); i++) {
			if (listeDesPropositionDeCombinaison.size() == 0) {
				valeurMaxEtMin[0][i] = 9;
				valeurMaxEtMin[1][i] = 0;
				combinaisonPropose[i] = (byte) ((valeurMaxEtMin[0][i] + valeurMaxEtMin[1][i]) / 2);
			} else {
				Combinaison combinaisonPrecedente = listeDesPropositionDeCombinaison
						.get(listeDesPropositionDeCombinaison.size() - 1);
				String indicesPrecedent = indices.get(indices.size() - 1);
				byte chiffreCombinaisonPrecedente = convertirCombinaisonsEnChiffre(combinaisonPrecedente, i);

				if (indicesPrecedent.charAt(i) == '+') {
					valeurMaxEtMin[1][i] = chiffreCombinaisonPrecedente;
					combinaisonPropose[i] = (byte) Math.ceil(((valeurMaxEtMin[0][i] + valeurMaxEtMin[1][i] + 1) / 2));
				} else if (indicesPrecedent.charAt(i) == '-') {
					valeurMaxEtMin[0][i] = chiffreCombinaisonPrecedente;
					combinaisonPropose[i] = (byte) Math.round(((valeurMaxEtMin[0][i] + valeurMaxEtMin[1][i]) / 2));
				} else {
					combinaisonPropose[i] = chiffreCombinaisonPrecedente;
				}
			}
		}
		Combinaison combinaison = new Combinaison(combinaisonPropose);
		return combinaison;
	}

	/**
	 * cette fonction permet à partir d'une combinaison de convertir le chiffre désiré en byte
	 * @param combinaison
	 * @param i
	 * @return une variable de type byte 
	 */
	public byte convertirCombinaisonsEnChiffre(Combinaison combinaison, int i) {
		byte chiffre;
		char ancienChiffreChar = combinaison.toString().charAt(i);
		chiffre = (byte) Character.getNumericValue(ancienChiffreChar);
		return chiffre;
	}

	@Override
	public String DonnerLesIndices() {
		
		return null;
	}
	
}
