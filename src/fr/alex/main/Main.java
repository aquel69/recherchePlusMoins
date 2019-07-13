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
			}while(VerificationSaisie.SiEntrerClavierEstFausse);
			switch (choixDuMenu) {
			case "1":
				do{
					
					joueurDefenseur = new Ordinateur("defenseur");
				
					joueurAttaquant = new Humain("attaquant");
								
					partie = new PartieChallenger(joueurDefenseur, joueurAttaquant);
					partie.Jouer();
					
					do {
						choixDuMenu = sc.nextLine();
						caracChoixMenu = choixDuMenu.charAt(0);
					}while(caracChoixMenu != 'O' && caracChoixMenu != 'N' && caracChoixMenu != 'M');
					System.out.println("lettre en dehors " + choixDuMenu);
				}while(caracChoixMenu == 'O');
				if (caracChoixMenu == 'N' && caracChoixMenu == 'M') 
				break;
				
			case "2":
				joueurDefenseur = new Humain("defenseur");
				joueurAttaquant = new Ordinateur("attaquant");
				
				partie = new PartieDefenseur(joueurDefenseur, joueurAttaquant);
				partie.Jouer();
				break;
			default:
		
				break;
			}
		}while(caracChoixMenu == 'M');
		
		
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
	
	@SuppressWarnings("resource")
	public static String reponseMenu() {
		String pReponse = null;
		Scanner sc = null;
		
		System.out.println("Souhaitez vous refaire une partie ? O pour oui / N pour non");
		System.out.println("Ou retourner au menu ? M pour menu");
		
		pReponse = sc.nextLine();
		
		
		return pReponse;
	}
	
	
}
