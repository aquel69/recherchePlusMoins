package fr.alex.main;

import java.util.ArrayList;
import java.util.List;

public abstract class Parties {
	Joueur joueurAttaquant;
	Joueur joueurDefenseur;
	protected Combinaison combinaisonMystere;
	

	static int nombreIndiceEgale = 0;
	protected int nbDeCoupJoue = 0;
		
	protected List<Combinaison> propositionsCombinaison;
	protected List<String> indices;
	
	public Parties(Joueur jDefenseur,Joueur jAttaquant){
		joueurAttaquant = jAttaquant;
		joueurDefenseur = jDefenseur;
		propositionsCombinaison = new ArrayList<Combinaison>();
		indices = new ArrayList<String>();
	}
	
	public abstract void Jouer();
	
	public abstract void affichageJeuEnCours();
	
	public abstract String AfficherResultat();
		
}
