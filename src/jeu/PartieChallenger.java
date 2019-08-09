package jeu;

import java.util.ArrayList;

/**
 * class partie Challenger permettant la mise en place et le déroulement du mode "Challenger"
 * 
 * @author alex
 *
 */
public class PartieChallenger extends Parties {
	
	/**
	 * Constructeur de la Partie Challenger contenant en paramètre les deux joueurs de Type Joueur.
	 * Les Lists contiennent la propositions jouée par le Joueur
	 * ainsi que les indices donnant les indications pour trouver la solution
	 * 
	 * @param jDefenseur joueur défenseur qui donne la combinaison mystère
	 * @param jAttaquant joueur attaquant qui doit trouver la combinaison mystère
	 */
	public PartieChallenger(Joueur jDefenseur, Joueur jAttaquant) {
		super(jDefenseur, jAttaquant);
		joueurAttaquant = jAttaquant;
		joueurDefenseur = jDefenseur;
		propositionsCombinaisonAttaquant = new ArrayList<Combinaison>();
		indicesAttaquant = new ArrayList<String>();
	}
	
	/**
	 * La fonction jouer est le coeur du déroulement de la partie.
	 * elle gère les demandes succesives des joueurs et compare les combinaisons
	 * grace la boucle principale, tant que la combinaison n'est pas trouvée
	 * ou que la limite de nombre de coups est atteinte
	 */
	public void Jouer() {
		aLOrdinateurDeJouer();
		combinaisonMystere = joueurDefenseur.DonnerCombinaisonMystere();
		if (Integer.parseInt(MODE_DEVELOPPEUR) == 1)
			System.out.println("La combinaison mystère est : " + combinaisonMystere);
		nombreIndiceEgaleHumain = 0;
		
		//boucle principale
		do {
			if(nbDeCoupJoue == 0) {
				auJoueurDeJouer();
			}
			Combinaison combinaisonProposee = joueurAttaquant.ProposerCombinaison(propositionsCombinaisonAttaquant,	indicesAttaquant);
			String affichageIndice = combinaisonMystere.Comparer(combinaisonProposee);
			propositionsCombinaisonAttaquant.add(combinaisonProposee);
			indicesAttaquant.add(affichageIndice);
			affichageJeuEnCours();
			nbDeCoupJoue++;
		} while (nombreIndiceEgaleHumain != Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON)
				&& nbDeCoupJoue != Integer.parseInt(NB_DE_COUP_MAX));
		
		System.out.println(afficherResultat());
	}

	/**
	 * la fonction sert à afficher les combinaisons et indices jouées précedemment par le joueur
	 */
	public void affichageJeuEnCours() {
		for (int i = 0; i < propositionsCombinaisonAttaquant.size(); i++) {
			System.out.print("\n#" + (i+1) + " Combinaison " + propositionsCombinaisonAttaquant.get(i));
			System.out.print(" / Indices correspondant " + indicesAttaquant.get(i));
		}
		System.out.println("\n\n---------------------------------------------------\n");
	}
	
	/**
	 * la fonction affiche le résultat final de la partie
	 * gagnant si le joueur à trouvé la combinaison mystère 
	 * perdant si le joueur n'a pas trouvé la combinaison dans le nombre de coup imparti
	 * 
	 * @return le message du résultat final sur la console
	 */
	public String afficherResultat() {
		String messageFinal = "";

		if (nombreIndiceEgaleHumain == Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON))
			messageFinal = "\n" + "Vous avez gagné en : " + nbDeCoupJoue + " coups !!!\n";
		else
			messageFinal = "\nVous avez perdu la solution était : " + combinaisonMystere +"\n";

		return messageFinal;
	}
	
	/**
	 * la fonction affiche que c'est au joueur de jouer
	 */
	public void auJoueurDeJouer() {
		System.out.println("\n-------------------A VOUS DE JOUER-----------------\n");
	}
	
	/**
	 * la fonction indique que c'est à l'ordinateur de jouer
	 */
	public void aLOrdinateurDeJouer() {
		System.out.println("\n---------------A L'ORDINATEUR DE JOUER-------------\n");
	}
	
}
