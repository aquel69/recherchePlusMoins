package fr.alex.escapegame;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.alex.escapegame.jeu.Humain;
import fr.alex.escapegame.jeu.Joueur;
import fr.alex.escapegame.jeu.Ordinateur;
import fr.alex.escapegame.jeu.PartieChallenger;
import fr.alex.escapegame.jeu.PartieDefenseur;
import fr.alex.escapegame.jeu.PartieDuel;
import fr.alex.escapegame.jeu.Parties;
import fr.alex.escapegame.utils.Proprietes;
import fr.alex.escapegame.utils.VerificationSaisie;

/**
 * class main déroulement du fr.alex.escapegame.jeu
 * 
 * @author alex
 *
 */
public class EscapeGame {
	
	//static Logger logger = LogManager.getLogger(EscapeGame.class);
	
	public static void main(String[] args) {
		Logger logger = LogManager.getLogger(EscapeGame.class);
		
		logger.info("le main est lancé");
				
		VerificationSaisie verificationSaisie = new VerificationSaisie();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		String choixDuMenu;
		Joueur joueurDefenseur;
		Joueur joueurAttaquant;
		Parties partie;
		char caracChoixMenu = ' ';
		
		// boucle principale du déroulement du fr.alex.escapegame.jeu
		do {
			presentation();
			if (Integer.parseInt(Proprietes.getInstance().getModeDeveloppeur()) == 1) {
				
				System.out.println("--------------Mode développeur activé--------------\n"
						+ "-nbre coup max : "+ Proprietes.getInstance().getNbDeCoupMax() + " / nbre chiffre combinaison : " + Proprietes.getInstance().getNbDeChiffreCombinaison() +"-");
				
		 }else 
				System.out.println("---------------------------------------------------");
				System.out.println("---------------------------------------------------\n");
			System.out.print("Selectionnez un mode de fr.alex.escapegame.jeu : ");
			
			do {
				choixDuMenu = sc.nextLine();
				verificationSaisie.erreurDeSaisieModeDeJeux(choixDuMenu);
				System.out.print(verificationSaisie.erreurDeSaisieModeDeJeux(choixDuMenu));
				if(VerificationSaisie.SiEntrerClavierEstVrai)
					logger.info("erreur saisie du mode de fr.alex.escapegame.jeu, le joueur a rentré : " + choixDuMenu);
			} while (VerificationSaisie.SiEntrerClavierEstVrai);
						
			switch (choixDuMenu) {
			case "1":
				
				EscapeGame.presentationModeChallenger(Proprietes.getInstance().getNbDeCoupMax(), Proprietes.getInstance().getNbDeChiffreCombinaison());
				
				do {
					joueurDefenseur = new Ordinateur("Defenseur");
					joueurAttaquant = new Humain("Attaquant");

					partie = new PartieChallenger(joueurDefenseur, joueurAttaquant);
					partie.Jouer();

					propositionMenuFinDePartie();
					do {
						choixDuMenu = sc.nextLine();
						verificationSaisie.erreurDeSaisieFinDePartie(choixDuMenu);
						System.out.print(verificationSaisie.erreurDeSaisieFinDePartie(choixDuMenu));
						if(VerificationSaisie.SiEntrerClavierEstVrai)
							logger.info("erreur saisie du choix en fin de partie, le joueur a rentré : " + choixDuMenu);
						if (choixDuMenu.isEmpty() == false)
							caracChoixMenu = choixDuMenu.charAt(0);
					} while (caracChoixMenu != 'O' && caracChoixMenu != 'M' && caracChoixMenu != 'Q');

				} while (caracChoixMenu == 'O');
				if (caracChoixMenu == 'M' || caracChoixMenu == 'Q')
					break;

			case "2":
				
				EscapeGame.presentationModeDefenseur(Proprietes.getInstance().getNbDeCoupMax(), Proprietes.getInstance().getNbDeChiffreCombinaison());
				
				do {
					joueurDefenseur = new Humain("Defenseur");
					joueurAttaquant = new Ordinateur("Attaquant");

					partie = new PartieDefenseur(joueurDefenseur, joueurAttaquant);
					partie.Jouer();

					propositionMenuFinDePartie();
					do {
						choixDuMenu = sc.nextLine();
						verificationSaisie.erreurDeSaisieFinDePartie(choixDuMenu);
						System.out.print(verificationSaisie.erreurDeSaisieFinDePartie(choixDuMenu));
						if(VerificationSaisie.SiEntrerClavierEstVrai)
							logger.info("erreur saisie du choix en fin de partie, le joueur a rentré : " + choixDuMenu);
						if (choixDuMenu.isEmpty() == false)
							caracChoixMenu = choixDuMenu.charAt(0);
					} while (caracChoixMenu != 'O' && caracChoixMenu != 'M' && caracChoixMenu != 'Q');

				} while (caracChoixMenu == 'O');
				if (caracChoixMenu == 'M' || caracChoixMenu == 'Q')
					break;

			case "3":
				
				EscapeGame.presentationModeDuel(Proprietes.getInstance().getNbDeCoupMax(), Proprietes.getInstance().getNbDeChiffreCombinaison());
				
				do {
					joueurDefenseur = new Ordinateur("Ordinateur");
					joueurAttaquant = new Humain("Humain");

					partie = new PartieDuel(joueurDefenseur, joueurAttaquant);
					partie.Jouer();

					propositionMenuFinDePartie();
					do {
						choixDuMenu = sc.nextLine();
						verificationSaisie.erreurDeSaisieFinDePartie(choixDuMenu);
						System.out.print(verificationSaisie.erreurDeSaisieFinDePartie(choixDuMenu));
						if(VerificationSaisie.SiEntrerClavierEstVrai)
							logger.info("erreur saisie du choix en fin de partie, le joueur a rentré : " + choixDuMenu);
						if (choixDuMenu.isEmpty() == false)
							caracChoixMenu = choixDuMenu.charAt(0);
					} while (caracChoixMenu != 'O' && caracChoixMenu != 'M' && caracChoixMenu != 'Q');
				} while (caracChoixMenu == 'O');
				if (caracChoixMenu == 'M' || caracChoixMenu == 'Q')
					break;

			default:
				break;
			}

		} while (caracChoixMenu == 'M');

		System.out.println("Merci d'avoir joué avec nous!!!");

	}

	/**
	 * affichage du menu général
	 */
	public static void presentation() {

		System.out.println("---------------------------------------------------\n"
				+ "--------------- Jeu de Recherche +/----------------\n"
				+ "---------------------------------------------------\n" + "1 - Mode Challenger\n"
				+ "2 - Mode Defenseur\n" + "3 - Mode Duel\n" + "4 - Quitter le fr.alex.escapegame.jeu\n"
				+ "---------------------------------------------------");

	}
	
	/**
	 * affichage du menu "challenger"
	 */
	public static void presentationModeChallenger(String nbDeCoup, String nbChiffreCombinaison) {
		System.out.println("\n---------------------------------------------------");
		System.out.println("------------------MODE CHALLENGER------------------");
		System.out.println("---------------------------------------------------");
		System.out.println("trouver la combinaison à " + nbChiffreCombinaison + " chiffres en " + nbDeCoup + " coups max");
		System.out.println("---------------------------------------------------\n");
	}
	
	/**
	 * affichage du menu "defenseur"
	 */
	public static void presentationModeDefenseur(String nbDeCoup, String nbChiffreCombinaison) {
		System.out.println("\n---------------------------------------------------");
		System.out.println("-------------------MODE DEFENSEUR------------------");
		System.out.println("---------------------------------------------------");
		System.out.println("----donner une combinaison mystère à " + nbChiffreCombinaison + " chiffres----");
		System.out.println("--l'ordinateur dispose de " + nbDeCoup + " coups pour la trouver--");
		System.out.println("---------------------------------------------------\n");
	}
	
	/**
	 * affichage du menu "Duel"
	 */
	public static void presentationModeDuel(String nbDeCoup, String nbChiffreCombinaison) {
		System.out.println("\n---------------------------------------------------");
		System.out.println("---------------------MODE DUEL---------------------");
		System.out.println("---------------------------------------------------");
		System.out.println("----------------ORDINATEUR VS VOUS-----------------");
		System.out.println("---------------------------------------------------");
		System.out.println("-soyez le premier à trouver la combinaison mystère-");
		System.out.println("-------------à " + nbChiffreCombinaison + " chiffres en " + nbDeCoup + " coups max----------");
		System.out.println("---------------------------------------------------\n\n");
	}

	/**
	 * affichage du menu de la fin de la partie
	 */
	public static void propositionMenuFinDePartie() {
		System.out.println("\nSouhaitez vous relancer une partie ? O pour oui");
		System.out.println("Ou retourner au menu ? M pour menu");
		System.out.println("Ou quitter le fr.alex.escapegame.jeu ? Q pour Quitter");
	}

}
