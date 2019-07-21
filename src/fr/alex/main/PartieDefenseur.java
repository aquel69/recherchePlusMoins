package fr.alex.main;

import java.util.ArrayList;

public class PartieDefenseur extends Parties {

	public PartieDefenseur(Joueur jDefenseur, Joueur jAttaquant) {
		super(jDefenseur, jAttaquant);
		joueurAttaquant = jAttaquant;
		joueurDefenseur = jDefenseur;
		propositionsCombinaisonAttaquant = new ArrayList<Combinaison>();
		indicesAttaquant = new ArrayList<String>();
	}

	public void Jouer() {
		combinaisonMystere = joueurDefenseur.DonnerCombinaisonMystere();

		do {
			Combinaison combinaisonProposee = joueurAttaquant.ProposerCombinaison(propositionsCombinaisonAttaquant,
					indicesAttaquant);
			propositionsCombinaisonAttaquant.add(combinaisonProposee);
			affichageJeuEnCours();
			String demandeIndice = joueurDefenseur.DonnerLesIndices();
			indicesAttaquant.add(demandeIndice);
			nbDeCoupJoue++;
		} while (nombreIndiceEgaleHumain != Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON)
				&& nbDeCoupJoue != Integer.parseInt(NB_DE_COUP_MAX));

		System.out.println(AfficherResultat());
	}

	public void affichageJeuEnCours() {
		System.out.println("\n----------------------------------------------");
		System.out.println("Proposition combinaison de l'ordinateur : "
				+ propositionsCombinaisonAttaquant.get(indicesAttaquant.size()));
		System.out.println("------------------- Combinaison mystère : " + combinaisonMystere.toString());
	}

	public String AfficherResultat() {
		String messageFinal = "";

		if (nombreIndiceEgaleHumain == Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON))
			messageFinal = joueurAttaquant.nom + " Tu as gagné en : " + nbDeCoupJoue + " coups !!!";
		else
			messageFinal = joueurDefenseur.nom + " Tu as gagné!!!";

		return messageFinal;
	}

}
