package fr.alex.main;

import java.util.ArrayList;
import java.util.List;

public abstract class Parties {

	Proprietes propriete = new Proprietes();
	protected final String NB_DE_COUP_MAX = propriete.getNbDeCoupMax();
	protected final String NB_DE_CHIFFRE_COMBINAISON = propriete.getNbDeChiffreCombinaison();
	protected final String MODE_DEVELOPPEUR = propriete.getModeDeveloppeur();

	protected Joueur joueurAttaquant;
	protected Joueur joueurDefenseur;
	protected Combinaison combinaisonMystere;
	protected Combinaison combinaisonMystereAttaquant;

	static int nombreIndiceEgaleHumain = 0;
	static int nombreIndiceEgaleOrdinateur = 0;

	protected int nbDeCoupJoue = 0;

	protected List<Combinaison> propositionsCombinaisonAttaquant;
	protected List<Combinaison> propositionsCombinaisonDefenseur;
	protected List<String> indicesAttaquant;
	protected List<String> indicesDefenseur;

	public Parties(Joueur jDefenseur, Joueur jAttaquant) {
		joueurAttaquant = jAttaquant;
		joueurDefenseur = jDefenseur;
		propositionsCombinaisonDefenseur = new ArrayList<Combinaison>();
		propositionsCombinaisonAttaquant = new ArrayList<Combinaison>();

		indicesAttaquant = new ArrayList<String>();
		indicesDefenseur = new ArrayList<String>();
	}

	public abstract void Jouer();

	public abstract void affichageJeuEnCours();

	public abstract String AfficherResultat();

}
