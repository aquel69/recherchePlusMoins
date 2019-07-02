package fr.alex.main;

public abstract class Joueur {
	String nom;
	Combinaison propositionCombinaison;
	Combinaison combinaisonMystere;
	
	
	//constructeur qui a pour parametre le nom du joueur
	public Joueur(String pNom) {
		nom = pNom;
	}
	
	public abstract Combinaison DonnerCombinaisonMystere();
	
	public abstract Combinaison ProposerCombinaison();
	
}
