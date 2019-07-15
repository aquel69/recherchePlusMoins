package fr.alex.main;

import java.util.ArrayList;

public class PartieChallenger extends Parties {
	
	
	public PartieChallenger(Joueur jDefenseur,Joueur jAttaquant) {
		super(jDefenseur, jAttaquant);
		joueurAttaquant = jAttaquant;
		joueurDefenseur = jDefenseur;
		propositionsCombinaison = new ArrayList<Combinaison>();
		indices = new ArrayList<String>();
	}
	
	public void Jouer() {
		combinaisonMystere = joueurDefenseur.DonnerCombinaisonMystere();
		if(Integer.parseInt(MODE_DEVELOPPEUR) == 1)
			System.out.println("La combinaison mystère est : " + combinaisonMystere);
		nombreIndiceEgale = 0;
		
		do {
			Combinaison combinaisonProposee = joueurAttaquant.ProposerCombinaison(propositionsCombinaison, indices);
			String affichageIndice = combinaisonMystere.Comparer(combinaisonProposee);
			propositionsCombinaison.add(combinaisonProposee);
			indices.add(affichageIndice);
			affichageJeuEnCours();
			nbDeCoupJoue++;
		}while(nombreIndiceEgale != Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON) && nbDeCoupJoue != Integer.parseInt(NB_DE_COUP_MAX));
		
		System.out.println(AfficherResultat());
	}
	
	public void affichageJeuEnCours() {
		 for(int i = 0; i < propositionsCombinaison.size(); i++) {
			System.out.print("\nCombinaison " + propositionsCombinaison.get(i));
			System.out.print(" / Indices correspondant " + indices.get(i) );
		 }
	}

	public String AfficherResultat() {
		String messageFinal = "";
			
			if(nombreIndiceEgale == Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON))
				messageFinal = "\n" + joueurAttaquant.nom + " Tu as gagné en : " + nbDeCoupJoue + " coups !!!";
			else messageFinal = "\n" + joueurDefenseur.nom + " Tu as gagné!!!";
				
		return messageFinal;
	}

}
