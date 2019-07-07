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
		
		presentation();
		choixDuMenu = sc.nextLine();
		
		switch (choixDuMenu) {
		case "1":
			joueurDefenseur = new Ordinateur("défenseur");
			joueurAttaquant = new Humain("attaquant");
						
			partie = new PartieChallenger(joueurDefenseur, joueurAttaquant);
			partie.Jouer();
			break;
		case "2":
			joueurDefenseur = new Humain("défenseur");
			joueurAttaquant = new Ordinateur("attaquant");
			
			partie = new PartieDefenseur(joueurDefenseur, joueurAttaquant);
			partie.Jouer();
			break;
		default:
			break;
		}
		
	}
	
	public static void presentation() {
		
			System.out.println( 
			"---------------------------------------------------\n" +
			"--------------- Jeu de Recherche +/----------------\n" +
			"---------------------------------------------------\n" +
			"1 - Mode Challenger\n" + 
			"2 - Mode Defenseur\n" +
			"3 - Mode Duel\n" +
			"4 - Régles et aides\n" + 
			"5 - Quitter le jeu\n" +
			"---------------------------------------------------");
		
	}
}
