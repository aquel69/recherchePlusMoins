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
		
		do {
			Combinaison combinaisonProposee = joueurAttaquant.ProposerCombinaison(propositionsCombinaison, indices);
			String affichageIndice = combinaisonMystere.Comparer(combinaisonProposee);
			propositionsCombinaison.add(combinaisonProposee);
			indices.add(affichageIndice);
			affichageJeuEnCours();
			nbDeCoupJoue++;
		}while(nombreIndiceEgale != 4 && nbDeCoupJoue != 5);
		
		System.out.println(AfficherResultat());
	}
	
	public void affichageJeuEnCours() {
		 for(int i = 0; i < propositionsCombinaison.size(); i++) {
			System.out.print("\ncombinaison " + propositionsCombinaison.get(i));
			System.out.print(" / indices correspondant " + indices.get(i) );
		 }
	}

	public String AfficherResultat() {
		String messageFinal = "";
			
			if(nombreIndiceEgale == 4)
				messageFinal = "\n" + joueurAttaquant.nom + " tu as gagné en : " + nbDeCoupJoue + " coups !!!";
			else messageFinal = "\n" + joueurDefenseur.nom + " tu as gagné!!!";
				
		return messageFinal;
	}

	/*public Combinaison getCombinaisonMystere() {
		return combinaisonMystere;
	}*/

}
