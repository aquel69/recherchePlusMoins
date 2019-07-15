package fr.alex.main;

import java.util.ArrayList;

public class PartieDefenseur extends Parties  {
	
	public PartieDefenseur(Joueur jDefenseur, Joueur jAttaquant) {
		super(jDefenseur, jAttaquant);
		joueurAttaquant = jAttaquant;
		joueurDefenseur = jDefenseur;
		propositionsCombinaison = new ArrayList<Combinaison>();
		indices = new ArrayList<String>();
	}
	
	public void Jouer() {
		combinaisonMystere = joueurDefenseur.DonnerCombinaisonMystere();
		
		do {
			Combinaison combinaisonProposee = joueurAttaquant.ProposerCombinaison(propositionsCombinaison, indices);
			propositionsCombinaison.add(combinaisonProposee);
			affichageJeuEnCours();
			String demandeIndice = joueurDefenseur.DonnerLesIndices();
			indices.add(demandeIndice);
			nbDeCoupJoue++;
		}while(nombreIndiceEgale != Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON) && nbDeCoupJoue != Integer.parseInt(NB_DE_COUP_MAX));
		
		System.out.println(AfficherResultat());
	}
	
	public void affichageJeuEnCours() {
		System.out.println("\n----------------------------------------------");
		System.out.println("------------------- Combinaison mystère : " + combinaisonMystere.toString());
		System.out.println("Proposition combinaison de l'ordinateur : " + propositionsCombinaison.get(indices.size()));
	}

	public String AfficherResultat() {
		String messageFinal = "";
			
			if(nombreIndiceEgale == Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON))
				messageFinal = joueurAttaquant.nom + " Tu as gagné en : " + nbDeCoupJoue + " coups !!!";
			else messageFinal = joueurDefenseur.nom + " Tu as gagné!!!";
				
		return messageFinal;
	}

}

