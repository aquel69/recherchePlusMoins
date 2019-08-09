package jeu;

import java.util.ArrayList;
import java.util.List;

import utils.Proprietes;

/**
 * class mère partie permettant la mise en place et le déroulement des différentes parties
 * 
 * @author alex
 *
 */
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
	
	/**
	 * constructeur des parties contenant en paramètre les deux joueurs de Type Joueur.
	 * Les Lists contiennent les propositions jouées par les Joueurs
	 * ainsi que les indices donnant les indications pour trouver la solution
	 * 
	 * @param jDefenseur joueur défenseur qui donne la combinaison mystère
	 * @param jAttaquant joueur attaquant qui doit trouver la combinaison mystère
	 */
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

	public abstract String afficherResultat();

}
