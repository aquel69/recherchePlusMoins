package fr.alex.main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

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
				System.out.println("Mode développeur activé\n");
			else
				System.out.println("Mode développeur désactivé\n");
			System.out.print("Selectionnez un mode de jeu : ");

			do {
				choixDuMenu = sc.nextLine();
				verificationSaisie.erreurDeSaisieModeDeJeux(choixDuMenu);
				System.out.print(verificationSaisie.erreurDeSaisieModeDeJeux(choixDuMenu));
			} while (VerificationSaisie.SiEntrerClavierEstVrai);

			switch (choixDuMenu) {
			case "1":
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

	public static void propositionMenuFinDePartie() {
		System.out.println("\nSouhaitez vous refaire une partie ? O pour oui");
		System.out.println("Ou retourner au menu ? M pour menu");
		System.out.println("Ou quitter le jeu ? Q pour Quitter");
	}

}
