package jeu;

import java.util.ArrayList;

/**
 * class partie Duel permettant la mise en place et le déroulement du mode "Duel"
 * 
 * @author alex
 *
 */
public class PartieDuel extends Parties {
	
	/**
	 * 
	 * @param jDefenseur 
	 * @param jAttaquant
	 */
	public PartieDuel(Joueur jDefenseur, Joueur jAttaquant) {
		super(jDefenseur, jAttaquant);
		joueurAttaquant = jAttaquant;
		joueurDefenseur = jDefenseur;
		propositionsCombinaisonAttaquant = new ArrayList<Combinaison>();
		propositionsCombinaisonDefenseur = new ArrayList<Combinaison>();
		indicesAttaquant = new ArrayList<String>();
		indicesDefenseur = new ArrayList<String>();
	}
	
	/**
	 * 
	 * La fonction jouer est le coeur du déroulement de la partie.
	 * elle gère les demandes succesives des joueurs et compare les combinaisons
	 * grace la boucle principale, tant que la combinaison n'est pas trouvée
	 * ou que la limite de nombre de coups est atteinte
	 */
	 
	public void Jouer() {
		auJoueurDeJouer();
		combinaisonMystereAttaquant = joueurAttaquant.DonnerCombinaisonMystere();
		aLOrdinateurDeJouer();
		combinaisonMystere = joueurDefenseur.DonnerCombinaisonMystere();

		if (Integer.parseInt(MODE_DEVELOPPEUR) == 1)
			System.out.println("La combinaison mystère est : " + combinaisonMystere);

		// remise à zéro en cas de nouvelle partie
		nombreIndiceEgaleHumain = 0;
		nombreIndiceEgaleOrdinateur = 0;

		// boucle principale qui permet de jouer
		do {
			
			// humain qui joue
			auJoueurDeJouer();
			affichageJeuEnCours();
			Combinaison combinaisonProposeeAttaquant = joueurAttaquant.ProposerCombinaison(propositionsCombinaisonAttaquant, indicesAttaquant);
			String affichageIndice = combinaisonMystere.Comparer(combinaisonProposeeAttaquant);
			propositionsCombinaisonAttaquant.add(combinaisonProposeeAttaquant);
			indicesAttaquant.add(affichageIndice);
			affichageDeLaProposition();

			// ordinateur qui joue
			aLOrdinateurDeJouer();
			Combinaison combinaisonProposee = joueurDefenseur.ProposerCombinaison(propositionsCombinaisonDefenseur,	indicesDefenseur);
			propositionsCombinaisonDefenseur.add(combinaisonProposee);
			affichageJeuEnCoursIndice();
			String demandeIndice = joueurAttaquant.DonnerLesIndices();
			indicesDefenseur.add(demandeIndice);

			
			nbDeCoupJoue++;
		} while (nombreIndiceEgaleHumain != Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON)
				&& nombreIndiceEgaleOrdinateur != Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON)
				&& nbDeCoupJoue != Integer.parseInt(NB_DE_COUP_MAX));
		
		
		System.out.println(afficherResultat());
	}
	
	/**
	 * la fonction sert à afficher la combinaison proposée par l'ordinateur et la combinaison mystère afin de comparer les deux combinaisons
	 */
	public void affichageJeuEnCoursIndice() {
		//System.out.println("----------------------------------------------");
		System.out.println("Proposition combinaison de l'ordinateur : "
				+ propositionsCombinaisonDefenseur.get(indicesDefenseur.size()));
		System.out.println("------------------- Combinaison mystère : " + combinaisonMystereAttaquant.toString());
	}
	
	/**
	 * la fonction sert à afficher les indices correspondant à la combinaison proposée
	 */
	public void affichageDeLaProposition() {
		System.out.print("Combinaison " + propositionsCombinaisonAttaquant.get(nbDeCoupJoue));
		System.out.println(" / Indices correspondant " + indicesAttaquant.get(nbDeCoupJoue));
	}
	
	
	/**
	 * la fonction sert à afficher les combinaisons et indices jouées précedemment par le joueur
	 */
	public void affichageJeuEnCours() {

		for (int i = 0; i < propositionsCombinaisonAttaquant.size(); i++) {
			if (propositionsCombinaisonAttaquant.size() >= 1 && i == 0) {
				//System.out.println("\n----------------------------------------------");
				System.out.println("recapitulatif des anciennes propositions : ");
			}

			System.out.print("#" + (i+1) + " Combinaison " + propositionsCombinaisonAttaquant.get(i));
			
			if ( i == propositionsCombinaisonAttaquant.size() - 1)
				System.out.println(" / Indices correspondant " + indicesAttaquant.get(i)+"\n");
			else
				System.out.println(" / Indices correspondant " + indicesAttaquant.get(i));
		}
	}
	
	/**
	 * la fonction retourne le résultat final de la partie 
	 * gagnant si le joueur à trouvé la combinaison mystère avant l'ordinateur
	 * perdant si l'ordinateur à trouvé la combinaison mystère avant le joueur
	 * égalité si les deux joueurs finissent en même temps
	 * perdu pour les deux joueurs si le nombre de coups est dépassé sans avoir trouvé la combinaison mystère
	 * 
	 * @return le message du résultat final sur la console
	 */
	public String afficherResultat() {
		String messageFinal = "";
		
		if (nbDeCoupJoue == Integer.parseInt(NB_DE_COUP_MAX))
			messageFinal = "\nVous avez tous les deux perdu!!";
		else if (nombreIndiceEgaleHumain == nombreIndiceEgaleOrdinateur )
			messageFinal = "\nVous êtes à égalité!!!";
		else if (nombreIndiceEgaleHumain == Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON))
			messageFinal = "\nVous avez gagné en : " + nbDeCoupJoue + " coups !!!";
		else if (nombreIndiceEgaleOrdinateur == Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON))
			messageFinal = "\nVous avez perdu la solution était : " + combinaisonMystere;
		
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