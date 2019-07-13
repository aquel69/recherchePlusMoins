package fr.alex.main;

import java.util.List;

public abstract class Joueur {
	protected String nom;
	protected Combinaison propositionCombinaison;
	protected Combinaison combinaisonMystere;
	protected boolean verificationEntrerClavier = false;
	VerificationSaisie verificationSaisie = new VerificationSaisie();
	
	
	//constructeur qui a pour parametre le nom du joueur
	public Joueur(String pNom) {
		nom = pNom;
	}
	
	public abstract Combinaison DonnerCombinaisonMystere();
	
	public abstract Combinaison ProposerCombinaison(List<Combinaison> propositionsCombinaison, List<String> indices);
	
	public abstract String DonnerLesIndices();
	 
}
