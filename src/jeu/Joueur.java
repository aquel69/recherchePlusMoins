package jeu;

import java.util.List;

import utils.Proprietes;
import utils.VerificationSaisie;

/**
 * la class Joueur est la classe mère permettant de définir les joueurs du jeu
 * @author alex
 *
 */
public abstract class Joueur {
	Proprietes propriete = new Proprietes();
	protected final String NB_DE_CHIFFRE_COMBINAISON = propriete.getNbDeChiffreCombinaison();

	protected String nom;
	protected Combinaison propositionCombinaison;
	protected Combinaison combinaisonMystere;
	protected boolean verificationEntrerClavier = false;
	VerificationSaisie verificationSaisie = new VerificationSaisie();

	// constructeur qui a pour parametre le nom du joueur
	/**
	 * constructeur permettant de créér un joueur en lui donnant un nom
	 * @param pNom de type String permet de donner un nom au Joueur
	 */
	public Joueur(String pNom) {
		nom = pNom;
	}

	public abstract Combinaison DonnerCombinaisonMystere();

	public abstract Combinaison ProposerCombinaison(List<Combinaison> propositionsCombinaison, List<String> indices);

	public abstract String DonnerLesIndices();
	
	public abstract byte convertirCombinaisonsEnChiffre(Combinaison combinaison, int emplacementDansLeTableau);

}