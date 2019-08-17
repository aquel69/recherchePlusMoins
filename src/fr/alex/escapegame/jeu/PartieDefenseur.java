package fr.alex.escapegame.jeu;

import java.util.ArrayList;

/**
 * Class partie Defenseur permettant la mise en place et le déroulement du mode "Défenseur".
 * 
 * @author alex
 *
 */
public class PartieDefenseur extends Parties {
	
	/**
	 * Constructeur de la Partie Défenseur contenant en paramètre les deux joueurs de Type Joueur.
	 * Les Lists contiennent la propositions jouée par le Joueur,
	 * ainsi que les indices donnant les indications pour trouver la solution.
	 * 
	 * @param jDefenseur joueur défenseur qui donne la combinaison mystère
	 * @param jAttaquant joueur attaquant qui doit trouver la combinaison mystère
	 */
	public PartieDefenseur(Joueur jDefenseur, Joueur jAttaquant) {
		super(jDefenseur, jAttaquant);
		joueurAttaquant = jAttaquant;
		joueurDefenseur = jDefenseur;
		propositionsCombinaisonAttaquant = new ArrayList<Combinaison>();
		indicesAttaquant = new ArrayList<String>();
	}
	
	/**
	 * La fonction jouer est le coeur du déroulement de la partie.
	 * Elle gère les demandes succesives des joueurs et compare les combinaisons
	 * grace la boucle principale, tant que la combinaison n'est pas trouvée
	 * ou que la limite de nombre de coups est atteinte.
	 */
	public void Jouer() {
		auJoueurDeJouer();
		combinaisonMystere = joueurDefenseur.DonnerCombinaisonMystere();
		nombreIndiceEgaleOrdinateur = 0;
		
		//boucle principale
		do {
			aLOrdinateurDeJouer();
			Combinaison combinaisonProposee = joueurAttaquant.ProposerCombinaison(propositionsCombinaisonAttaquant,
					indicesAttaquant);
			propositionsCombinaisonAttaquant.add(combinaisonProposee);
			affichageJeuEnCours();
			auJoueurDeJouer();
			String demandeIndice = joueurDefenseur.DonnerLesIndices();
			indicesAttaquant.add(demandeIndice);
			nbDeCoupJoue++;
		} while (nombreIndiceEgaleOrdinateur != Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON)
				&& nbDeCoupJoue != Integer.parseInt(NB_DE_COUP_MAX));

		System.out.println("\n----------------------------------------------");
		System.out.println(afficherResultat());
	}
	
	/**
	 * La fonction sert à afficher la combinaison proposée par l'ordinateur et la combinaison mystère afin de comparer les deux combinaisons.
	 */
	public void affichageJeuEnCours() {
		//System.out.println("----------------------------------------------");
		System.out.println("Proposition combinaison de l'ordinateur : "
				+ propositionsCombinaisonAttaquant.get(indicesAttaquant.size()));
		System.out.println("------------------- Combinaison mystère : " + combinaisonMystere.toString());
	}
	
	/**
	 * La fonction affiche le résultat final de la partie :
	 * perdu pour le joueur si l'ordinateur a trouvé la combinaison mystère 
	 * gagnant pour le joueur si l'ordinateur n'a pas trouvé la combinaison dans le nombre de coup imparti.
	 * 
	 * @return le message du résultat final sur la console
	 */
	public String afficherResultat() {
		String messageFinal = "";

		if (nombreIndiceEgaleOrdinateur == Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON))
			messageFinal = "\nVous avez perdu !! L'ordinateur a gagné en " + nbDeCoupJoue + " coups !!!";
		else
			messageFinal = "\nVous avez gagné!!!";

		return messageFinal;
	}
	
	/**
	 * La fonction affiche que c'est au joueur de jouer.
	 */
	public void auJoueurDeJouer() {
		System.out.println("\n-------------------A VOUS DE JOUER-----------------\n");
	}
	
	/**
	 * La fonction indique que c'est à l'ordinateur de jouer.
	 */
	public void aLOrdinateurDeJouer() {
		System.out.println("\n---------------A L'ORDINATEUR DE JOUER-------------\n");
	}

}
