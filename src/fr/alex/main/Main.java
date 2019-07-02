package fr.alex.main;

public class Main {
	public static void main(String[] args) {
		
		
		Joueur joueurAttaquant = new Ordinateur("attaquant");
		Joueur joueurDefenseur = new Humain("d�fenseur");
		
		PartieClassique partie = new PartieClassique(joueurAttaquant, joueurDefenseur);
		
		partie.Jouer();
	}
}
