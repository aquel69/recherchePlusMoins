package fr.alex.main;

import java.util.List;
import java.util.Random;

public class Ordinateur extends Joueur {

	Random random = new Random();
	byte valeurMaxEtMin[][] = new byte[2][Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON)];

	public Ordinateur(String pNom) {
		super(pNom);

	}

	// fonction qui demande la combinaison mystere à l'ordinateur
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

	public String DonnerLesIndices() {
		return null;
	}

	public byte convertirCombinaisonsEnChiffre(Combinaison combinaison, int i) {
		byte chiffre;
		char ancienChiffreChar = combinaison.toString().charAt(i);
		chiffre = (byte) Character.getNumericValue(ancienChiffreChar);
		return chiffre;
	}

	// fonction qui demande une proposition de combinaison � l'ordinateur
	/**
	 * public Combinaison ProposerCombinaison() {
	 * 
	 * byte [] combinaisonByte = new byte[4]; //byte [] combMyst = new byte[4];
	 * 
	 * String combinaisonString = ""; int chiffreInt = 0; byte chiffreByte;
	 * 
	 * for(int i = 0; i < 4; i++) { if(PartieClassique.nbDeCoupJoue == 0) chiffreInt
	 * = 5;
	 * 
	 * else if(PartieClassique.nbDeCoupJoue >= 1){ Combinaison ancienneCombinaison =
	 * PartieClassique.propositionsCombinaison.get(PartieClassique.nbDeCoupJoue -
	 * 1); boolean chiffreIdentique = false; int chiffreAncienneCombinaisonPropose =
	 * convertirCombinaisonsEnChiffre(ancienneCombinaison, i); int
	 * chiffreCombinaisonMystere =
	 * convertirCombinaisonsEnChiffre(PartieClassique.combinaisonMystere, i);
	 * 
	 * if (PartieClassique.nbDeCoupJoue == 1) { if(chiffreCombinaisonMystere == 5)
	 * chiffreInt = 5; else if(chiffreCombinaisonMystere < 5) chiffreInt = 3; else
	 * chiffreInt = 7; }else if(chiffreAncienneCombinaisonPropose ==
	 * chiffreCombinaisonMystere) chiffreInt = chiffreAncienneCombinaisonPropose;
	 * else do {
	 * 
	 * chiffreIdentique = false; if (chiffreCombinaisonMystere > 5 &&
	 * chiffreAncienneCombinaisonPropose < chiffreCombinaisonMystere) chiffreInt =
	 * random.nextInt(9 - chiffreAncienneCombinaisonPropose + 1) +
	 * chiffreAncienneCombinaisonPropose; else if (chiffreCombinaisonMystere > 5 &&
	 * chiffreAncienneCombinaisonPropose > chiffreCombinaisonMystere) chiffreInt =
	 * random.nextInt(chiffreAncienneCombinaisonPropose - 6 + 1) + 6; else if
	 * (chiffreCombinaisonMystere < 5 && chiffreAncienneCombinaisonPropose <
	 * chiffreCombinaisonMystere) chiffreInt = random.nextInt(4 -
	 * chiffreAncienneCombinaisonPropose + 1) + chiffreAncienneCombinaisonPropose;
	 * else if (chiffreCombinaisonMystere < 5 && chiffreAncienneCombinaisonPropose >
	 * chiffreCombinaisonMystere) chiffreInt =
	 * random.nextInt(chiffreAncienneCombinaisonPropose);
	 * 
	 * for(int k = 0; k < PartieClassique.propositionsCombinaison.size(); k++) {
	 * Combinaison anciennesCombinaison =
	 * PartieClassique.propositionsCombinaison.get(k); int
	 * chiffreAncienneCombinaisonProposeListeEntiere =
	 * convertirCombinaisonsEnChiffre(anciennesCombinaison, i);
	 * 
	 * if(chiffreAncienneCombinaisonProposeListeEntiere == chiffreInt)
	 * chiffreIdentique = true; }
	 * 
	 * }while(chiffreIdentique);
	 * 
	 * } chiffreByte = (byte) chiffreInt; combinaisonByte[i] = chiffreByte;
	 * combinaisonString = combinaisonString + String.valueOf(chiffreInt);
	 * System.out.println(chiffreByte); } System.out.println("l'ordinateur propose
	 * la combinaison : " + combinaisonString);
	 * 
	 * Combinaison combinaison = new Combinaison(combinaisonByte); return
	 * combinaison; }
	 */

}
