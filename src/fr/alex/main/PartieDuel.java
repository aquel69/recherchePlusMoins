package fr.alex.main;

import java.util.ArrayList;

/**
 * 
 * @author alex
 *
 */
public class PartieDuel extends Parties {
	
	/**
	 * 
	 * @param jDefenseur 
	 * @param jAttaquant
	 */
	public PartieDuel(Joueur jDefenseur, Joueur jAttaquant) {
		super(jDefenseur, jAttaquant);
		joueurAttaquant = jAttaquant;
		joueurDefenseur = jDefenseur;
		propositionsCombinaisonAttaquant = new ArrayList<Combinaison>();
		propositionsCombinaisonDefenseur = new ArrayList<Combinaison>();
		indicesAttaquant = new ArrayList<String>();
		indicesDefenseur = new ArrayList<String>();
	}
	
	/**
	 * 
	 */
	public void Jouer() {
		combinaisonMystereAttaquant = joueurAttaquant.DonnerCombinaisonMystere();
		combinaisonMystere = joueurDefenseur.DonnerCombinaisonMystere();

		if (Integer.parseInt(MODE_DEVELOPPEUR) == 1)
			System.out.println("La combinaison mystère est : " + combinaisonMystere);

		// remise à zéro en cas de nouvelle partie
		nombreIndiceEgaleHumain = 0;
		nombreIndiceEgaleOrdinateur = 0;

		// boucle principale qui permet de jouer
		do {
			// ordinateur qui joue
			Combinaison combinaisonProposee = joueurDefenseur.ProposerCombinaison(propositionsCombinaisonDefenseur,
					indicesDefenseur);
			propositionsCombinaisonDefenseur.add(combinaisonProposee);
			affichageJeuEnCoursIndice();
			String demandeIndice = joueurAttaquant.DonnerLesIndices();
			indicesDefenseur.add(demandeIndice);

			// humain qui joue
			affichageJeuEnCours();
			Combinaison combinaisonProposeeAttaquant = joueurAttaquant
					.ProposerCombinaison(propositionsCombinaisonAttaquant, indicesAttaquant);
			String affichageIndice = combinaisonMystere.Comparer(combinaisonProposeeAttaquant);
			propositionsCombinaisonAttaquant.add(combinaisonProposeeAttaquant);
			indicesAttaquant.add(affichageIndice);

			nbDeCoupJoue++;
		} while (nombreIndiceEgaleHumain != Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON)
				&& nombreIndiceEgaleOrdinateur != Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON)
				&& nbDeCoupJoue != Integer.parseInt(NB_DE_COUP_MAX));

		System.out.println(afficherResultat());
	}

	public void affichageJeuEnCoursIndice() {
		System.out.println("\n----------------------------------------------");
		System.out.println("Proposition combinaison de l'ordinateur : "
				+ propositionsCombinaisonDefenseur.get(indicesDefenseur.size()));
		System.out.println("------------------- Combinaison mystère : " + combinaisonMystereAttaquant.toString());
	}

	public void affichageJeuEnCours() {

		for (int i = 0; i < propositionsCombinaisonAttaquant.size(); i++) {
			if (propositionsCombinaisonAttaquant.size() >= 1 && i == 0) {
				System.out.println("\n----------------------------------------------");
				System.out.println("recapitulatif des anciennes propositions : ");
			}

			System.out.print("Combinaison " + propositionsCombinaisonAttaquant.get(i));
			if (i == propositionsCombinaisonAttaquant.size() - 1)
				System.out.print(" / Indices correspondant " + indicesAttaquant.get(i));
			else
				System.out.println(" / Indices correspondant " + indicesAttaquant.get(i));
		}
	}
	
	/**
	 * 
	 * @return  
	 */
	public String afficherResultat() {
		String messageFinal = "";
		System.out.println("\n----------------------------------------------");
		if (nombreIndiceEgaleHumain == nombreIndiceEgaleOrdinateur)
			messageFinal = joueurDefenseur.nom + " et " + joueurAttaquant.nom + " vous êtes à égalité!!!";
		else if (nombreIndiceEgaleHumain == Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON))
			messageFinal = joueurAttaquant.nom + " tu as gagné en : " + nbDeCoupJoue + " coups !!!";
		else if (nombreIndiceEgaleOrdinateur == Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON))
			messageFinal = joueurDefenseur.nom + " tu as gagné en : " + nbDeCoupJoue + " coups !!!";

		return messageFinal;
	}

}