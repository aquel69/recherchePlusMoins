package fr.alex.main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String choixDuMenu;
		Joueur joueurDefenseur;
		Joueur joueurAttaquant;
		Parties partie;
		String reponse = null;
		char caracChoixMenu = ' ';
		VerificationSaisie verificationSaisie = new VerificationSaisie();
		
		do {
			presentation();
			System.out.print("Selectionnez un mode de jeu : ");
			do{
				choixDuMenu = sc.nextLine();
				verificationSaisie.erreurDeSaisieModeDeJeux(choixDuMenu);
				System.out.println(verificationSaisie.erreurDeSaisieModeDeJeux(choixDuMenu));
			}while(VerificationSaisie.SiEntrerClavierEstVrai);
			
			switch (choixDuMenu) {
				case "1":
					do{
						
						joueurDefenseur = new Ordinateur("defenseur");
					
						joueurAttaquant = new Humain("attaquant");
									
						partie = new PartieChallenger(joueurDefenseur, joueurAttaquant);
						partie.Jouer();
						
						propositionMenuFinDePartie();
						do {
							choixDuMenu = sc.nextLine();
							verificationSaisie.erreurDeSaisieFinDePartie(choixDuMenu);
							System.out.println(verificationSaisie.erreurDeSaisieFinDePartie(choixDuMenu));
							if(choixDuMenu.isEmpty() == false)
								caracChoixMenu = choixDuMenu.charAt(0);
						}while(caracChoixMenu != 'O' && caracChoixMenu != 'M' && caracChoixMenu != 'Q');
						
					}while(caracChoixMenu == 'O');
					if (caracChoixMenu == 'M' || caracChoixMenu == 'Q') 
						break;
					
				case "2":
					do {
						joueurDefenseur = new Humain("defenseur");
						joueurAttaquant = new Ordinateur("attaquant");
						
						partie = new PartieDefenseur(joueurDefenseur, joueurAttaquant);
						partie.Jouer();
										
						propositionMenuFinDePartie();
						do {
							choixDuMenu = sc.nextLine();
							verificationSaisie.erreurDeSaisieFinDePartie(choixDuMenu);
							System.out.println(verificationSaisie.erreurDeSaisieFinDePartie(choixDuMenu));
							if(choixDuMenu.isEmpty() == false)
								caracChoixMenu = choixDuMenu.charAt(0);
						}while(caracChoixMenu != 'O' && caracChoixMenu != 'M' && caracChoixMenu != 'Q');
						
					}while(caracChoixMenu == 'O');
					if (caracChoixMenu == 'M' || caracChoixMenu == 'Q') 
						break;
					
				case "3" :
					do {
						System.out.println("mode duel");
						
						propositionMenuFinDePartie();
						do {
							choixDuMenu = sc.nextLine();
							verificationSaisie.erreurDeSaisieFinDePartie(choixDuMenu);
							System.out.println(verificationSaisie.erreurDeSaisieFinDePartie(choixDuMenu));
							if(choixDuMenu.isEmpty() == false)
								caracChoixMenu = choixDuMenu.charAt(0);
						}while(caracChoixMenu != 'O' && caracChoixMenu != 'M' && caracChoixMenu != 'Q');
					}while(caracChoixMenu == 'O');
					if (caracChoixMenu == 'M' || caracChoixMenu == 'Q') 
						break;
					
				default:
					break;
				}
		
		}while(caracChoixMenu == 'M');
		
		
		System.out.println("Merci d'avoir joué avec nous!!!");
		
	}
	
	public static void presentation() {
		
			System.out.println( 
			"---------------------------------------------------\n" +
			"--------------- Jeu de Recherche +/----------------\n" +
			"---------------------------------------------------\n" +
			"1 - Mode Challenger\n" + 
			"2 - Mode Defenseur\n" +
			"3 - Mode Duel\n" +
			"4 - Quitter le jeu\n" +
			"---------------------------------------------------");
		
	}
	
	
	public static void propositionMenuFinDePartie() {
			System.out.println("\nSouhaitez vous refaire une partie ? O pour oui");
		System.out.println("Ou retourner au menu ? M pour menu");
		System.out.println("Ou quitter le jeu ? Q pour Quitter");
	}
		
}
