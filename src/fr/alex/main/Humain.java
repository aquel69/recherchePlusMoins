package fr.alex.main;

import java.util.Scanner;

public class Humain extends Joueur {

	public Humain(String pNom) {
		super(pNom);
		
	}
	
	//fonction qui demande la combinaison mystere au joueur
		public Combinaison DonnerCombinaisonMystere() {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			byte [] combinaisonByte = new byte[4];
			String combinaisonString;
			
			//demande et entrée de la saisie du joueur
			System.out.println(nom + " veuillez saisir 4 chiffres pour la combinaison mystère : ");
			combinaisonString = sc.nextLine();
			
			//conversion et remplissage du tableau byte a partir de la saisie String
			for(int i = 0; i < combinaisonString.length(); i++) {
				char [] combinaisonChar = combinaisonString.toCharArray();
				int a=Character.getNumericValue(combinaisonChar[i]);  
				combinaisonByte[i] = (byte) a;
				
			}
			
			Combinaison combinaison = new Combinaison(combinaisonByte);
			return combinaison;
		}
		
		//fonction qui demande une proposition de combinaison au joueur et conversion en tableau byte
		public Combinaison ProposerCombinaison() {
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			byte [] combinaisonByte = new byte[4];
			String combinaisonString;
			
			System.out.println(nom + " veuillez proposer une combinaison à 4 chiffres : ");
			combinaisonString = sc.nextLine();
			
			
			for(int i = 0; i < combinaisonString.length(); i++) {
				char [] combinaisonChar = combinaisonString.toCharArray();
				int a=Character.getNumericValue(combinaisonChar[i]);  
				combinaisonByte[i] = (byte) a;
			}
			
			Combinaison combinaison = new Combinaison(combinaisonByte);
			
			return combinaison;
		}
	
	
	
}
