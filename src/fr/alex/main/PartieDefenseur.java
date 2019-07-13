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
		}while(nombreIndiceEgale != 4 && nbDeCoupJoue != 5);
		
		System.out.println(AfficherResultat());
	}
	
	public void affichageJeuEnCours() {
		System.out.println("\n----------------------------------------------");
		System.out.println("------------------- combinaison mystère : " + combinaisonMystere.toString());
		System.out.println("proposition combinaison de l'ordinateur : " + propositionsCombinaison.get(indices.size()));
	}

	public String AfficherResultat() {
		String messageFinal = "";
			
			if(nombreIndiceEgale == 4)
				messageFinal = joueurAttaquant.nom + " tu as gagné en : " + nbDeCoupJoue + " coups !!!";
			else messageFinal = joueurDefenseur.nom + " tu as gagné!!!";
				
		return messageFinal;
	}

	/*public Combinaison getCombinaisonMystere() {
		return combinaisonMystere;
	}	*/
}

