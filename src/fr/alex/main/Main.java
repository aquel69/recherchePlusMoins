package fr.alex.main;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	
	static Logger logger = LogManager.getLogger(Main.class);
	
	public static void main(String[] args) {
		logger.info("le main est lancé");
			
		
		VerificationSaisie verificationSaisie = new VerificationSaisie();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Proprietes propriete = new Proprietes();
		final String MODE_DEVELOPPEUR = propriete.getModeDeveloppeur();

		String choixDuMenu;
		Joueur joueurDefenseur;
		Joueur joueurAttaquant;
		Parties partie;
		char caracChoixMenu = ' ';

		do {
						
			
					
			presentation();
			if (Integer.parseInt(MODE_DEVELOPPEUR) == 1)
				System.out.println("--------------Mode développeur activé--------------");
			else
				System.out.println("-------------Mode développeur désactivé------------");
				System.out.println("---------------------------------------------------\n");
			System.out.print("Selectionnez un mode de jeu : ");
			
			do {
				choixDuMenu = sc.nextLine();
				verificationSaisie.erreurDeSaisieModeDeJeux(choixDuMenu);
				System.out.print(verificationSaisie.erreurDeSaisieModeDeJeux(choixDuMenu));
			} while (VerificationSaisie.SiEntrerClavierEstVrai);
						
			switch (choixDuMenu) {
			case "1":
				
				Main.presentationModeChallenger(propriete.getNbDeCoupMax(), propriete.getNbDeChiffreCombinaison());
				
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
						if (choixDuMenu.isEmpty() == false)
							caracChoixMenu = choixDuMenu.charAt(0);
					} while (caracChoixMenu != 'O' && caracChoixMenu != 'M' && caracChoixMenu != 'Q');

				} while (caracChoixMenu == 'O');
				if (caracChoixMenu == 'M' || caracChoixMenu == 'Q')
					break;

			case "2":
				
				Main.presentationModeDefenseur(propriete.getNbDeCoupMax(), propriete.getNbDeChiffreCombinaison());
				
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
						if (choixDuMenu.isEmpty() == false)
							caracChoixMenu = choixDuMenu.charAt(0);
					} while (caracChoixMenu != 'O' && caracChoixMenu != 'M' && caracChoixMenu != 'Q');

				} while (caracChoixMenu == 'O');
				if (caracChoixMenu == 'M' || caracChoixMenu == 'Q')
					break;

			case "3":
				
				Main.presentationModeDuel(propriete.getNbDeCoupMax(), propriete.getNbDeChiffreCombinaison());
				
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

	public static void presentation() {

		System.out.println("---------------------------------------------------\n"
				+ "--------------- Jeu de Recherche +/----------------\n"
				+ "---------------------------------------------------\n" + "1 - Mode Challenger\n"
				+ "2 - Mode Defenseur\n" + "3 - Mode Duel\n" + "4 - Quitter le jeu\n"
				+ "---------------------------------------------------");

	}
	
	public static void presentationModeChallenger(String nbDeCoup, String nbChiffreCombinaison) {
		System.out.println("\n---------------------------------------------------");
		System.out.println("------------------MODE CHALLENGER------------------");
		System.out.println("---------------------------------------------------");
		System.out.println("trouver la combinaison à " + nbChiffreCombinaison + " chiffres en " + nbDeCoup + " coups max");
		System.out.println("---------------------------------------------------\n");
	}
	
	public static void presentationModeDefenseur(String nbDeCoup, String nbChiffreCombinaison) {
		System.out.println("\n---------------------------------------------------");
		System.out.println("-------------------MODE DEFENSEUR------------------");
		System.out.println("---------------------------------------------------");
		System.out.println("----donner une combinaison mystère à " + nbChiffreCombinaison + " chiffres----");
		System.out.println("--l'ordinateur dispose de " + nbDeCoup + " coups pour la trouver--");
		System.out.println("---------------------------------------------------\n");
	}
	
	public static void presentationModeDuel(String nbDeCoup, String nbChiffreCombinaison) {
		System.out.println("\n---------------------------------------------------");
		System.out.println("---------------------MODE DUEL---------------------");
		System.out.println("---------------------------------------------------");
		System.out.println("----------------ORDINATEUR VS VOUS-----------------");
		System.out.println("---------------------------------------------------");
		System.out.println("-soyez le premier à trouver la combinaison mystère-");
		System.out.println("-------------à " + nbChiffreCombinaison + " chiffres en " + nbDeCoup + " coups max-----------");
		System.out.println("---------------------------------------------------\n\n");
	}

	public static void propositionMenuFinDePartie() {
		System.out.println("\nSouhaitez vous refaire une partie ? O pour oui");
		System.out.println("Ou retourner au menu ? M pour menu");
		System.out.println("Ou quitter le jeu ? Q pour Quitter");
	}

}
