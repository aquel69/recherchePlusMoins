package fr.alex.main;

import java.util.ArrayList;

public class PartieChallenger extends Parties {

	public PartieChallenger(Joueur jDefenseur, Joueur jAttaquant) {
		super(jDefenseur, jAttaquant);
		joueurAttaquant = jAttaquant;
		joueurDefenseur = jDefenseur;
		propositionsCombinaisonAttaquant = new ArrayList<Combinaison>();
		indicesAttaquant = new ArrayList<String>();
	}

	public void Jouer() {
		aLOrdinateurDeJouer();
		combinaisonMystere = joueurDefenseur.DonnerCombinaisonMystere();
		if (Integer.parseInt(MODE_DEVELOPPEUR) == 1)
			System.out.println("La combinaison mystère est : " + combinaisonMystere);
		nombreIndiceEgaleHumain = 0;
		
		
		do {
			if(nbDeCoupJoue == 0) {
				auJoueurDeJouer();
			}
			Combinaison combinaisonProposee = joueurAttaquant.ProposerCombinaison(propositionsCombinaisonAttaquant,	indicesAttaquant);
			String affichageIndice = combinaisonMystere.Comparer(combinaisonProposee);
			propositionsCombinaisonAttaquant.add(combinaisonProposee);
			indicesAttaquant.add(affichageIndice);
			affichageJeuEnCours();
			nbDeCoupJoue++;
		} while (nombreIndiceEgaleHumain != Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON)
				&& nbDeCoupJoue != Integer.parseInt(NB_DE_COUP_MAX));

		System.out.println(afficherResultat());
	}

	public void affichageJeuEnCours() {
		for (int i = 0; i < propositionsCombinaisonAttaquant.size(); i++) {
			System.out.print("\nCombinaison " + propositionsCombinaisonAttaquant.get(i));
			System.out.print(" / Indices correspondant " + indicesAttaquant.get(i));
		}
		System.out.println("\n\n---------------------------------------------------\n");
	}

	public String afficherResultat() {
		String messageFinal = "";

		if (nombreIndiceEgaleHumain == Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON))
			messageFinal = "\n" + joueurAttaquant.nom + " vous avez gagné en : " + nbDeCoupJoue + " coups !!!\n";
		else
			messageFinal = "\n" + joueurAttaquant.nom + " vous avez perdu la solution était : " + combinaisonMystere +"\n";

		return messageFinal;
	}
	
	public void auJoueurDeJouer() {
		System.out.println("\n-------------------A VOUS DE JOUER-----------------\n");
	}
	
	public void aLOrdinateurDeJouer() {
		System.out.println("\n---------------A L'ORDINATEUR DE JOUER-------------\n");
	}
	
}
