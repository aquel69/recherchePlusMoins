package fr.alex.main;

import java.util.ArrayList;
import java.util.List;

public class PartieClassique {
	Joueur joueurAttaquant;
	Joueur joueurDefenseur;
	private Combinaison combinaisonMystere;
	

	static int nombreIndiceEgale = 0;
	private int nbDeCoupJoue = 0;
		
	private List<Combinaison> propositionsCombinaison;
	private List<String> indices;
	
	public PartieClassique() {
		super();
	}
	
	public PartieClassique(Joueur jAttaquant, Joueur jDefenseur) {
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
	
	private void affichageJeuEnCours() {
		 for(int i = 0; i < propositionsCombinaison.size(); i++) {
			System.out.print("combinaison " + propositionsCombinaison.get(i));
			System.out.println(" / indices correspondant " + indices.get(i) + "\n");
		 }
	}

	public String AfficherResultat() {
		String messageFinal = "";
			
			if(nombreIndiceEgale == 4)
				messageFinal = joueurAttaquant.nom + " tu as gagné!!!";
			else messageFinal = joueurDefenseur.nom + " tu as gagné!!!";
				
		return messageFinal;
	}

	public Combinaison getCombinaisonMystere() {
		return combinaisonMystere;
	}	
}
