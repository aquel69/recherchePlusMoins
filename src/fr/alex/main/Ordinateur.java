package fr.alex.main;

import java.util.Random;

public class Ordinateur extends Joueur {
	
	Random random = new Random();
	
		
	public Ordinateur(String pNom) {
		super(pNom);
		
	}
	
	//fonction qui demande la combinaison mystere à l'ordinateur
	public Combinaison DonnerCombinaisonMystere() {
		
		byte [] combinaisonByte = new byte[4];
		String combinaisonString = "";
		int chiffreInt = 0;
		byte chiffreByte;
		
		
		System.out.println("l'ordinateur a établi une combinaison mystère");
		for(int i = 0; i < 4; i++) {	
			chiffreInt = random.nextInt(10);
			chiffreByte = (byte) chiffreInt;
			combinaisonByte[i] = chiffreByte;
			combinaisonString = combinaisonString + String.valueOf(chiffreInt);
			System.out.println(chiffreByte);
		}
		
		Combinaison combinaison = new Combinaison(combinaisonByte);
		return combinaison;
		
	}
	
	//fonction qui demande une proposition de combinaison à l'ordinateur
	public Combinaison ProposerCombinaison() {
		
		byte [] combinaisonByte = new byte[4];
		//byte [] combMyst = new byte[4];
		
		String combinaisonString = "";
		int chiffreInt = 0;
		byte chiffreByte;
				
		for(int i = 0; i < 4; i++) {	
			if(PartieClassique.nbDeCoupJoue == 0)
				chiffreInt = 5;
				
			else if(PartieClassique.nbDeCoupJoue >= 1){
				Combinaison ancienneCombinaison = PartieClassique.propositionsCombinaison.get(PartieClassique.nbDeCoupJoue - 1);
				boolean chiffreIdentique = false;
				int chiffreAncienneCombinaisonPropose = convertirCombinaisonsEnChiffre(ancienneCombinaison, i);
				int chiffreCombinaisonMystere = convertirCombinaisonsEnChiffre(PartieClassique.combinaisonMystere, i);
				
				if (PartieClassique.nbDeCoupJoue == 1) {
					if(chiffreCombinaisonMystere == 5)
						chiffreInt = 5;
					else if(chiffreCombinaisonMystere < 5)
						chiffreInt = 3;
					else chiffreInt = 7;
				}else if(chiffreAncienneCombinaisonPropose == chiffreCombinaisonMystere)
					chiffreInt = chiffreAncienneCombinaisonPropose;
				else do { 	
										
					chiffreIdentique = false;
					if (chiffreCombinaisonMystere > 5 && chiffreAncienneCombinaisonPropose < chiffreCombinaisonMystere) 
						chiffreInt = random.nextInt(9 - chiffreAncienneCombinaisonPropose + 1) + chiffreAncienneCombinaisonPropose;
					else if (chiffreCombinaisonMystere > 5 && chiffreAncienneCombinaisonPropose > chiffreCombinaisonMystere)
						chiffreInt = random.nextInt(chiffreAncienneCombinaisonPropose - 6 + 1) + 6;
					else if (chiffreCombinaisonMystere < 5 && chiffreAncienneCombinaisonPropose < chiffreCombinaisonMystere) 
						chiffreInt = random.nextInt(4 - chiffreAncienneCombinaisonPropose + 1) + chiffreAncienneCombinaisonPropose;
					else if (chiffreCombinaisonMystere < 5 && chiffreAncienneCombinaisonPropose > chiffreCombinaisonMystere) 
						chiffreInt = random.nextInt(chiffreAncienneCombinaisonPropose);
					
					for(int k = 0; k < PartieClassique.propositionsCombinaison.size(); k++) {
						Combinaison anciennesCombinaison = PartieClassique.propositionsCombinaison.get(k);
						int chiffreAncienneCombinaisonProposeListeEntiere = convertirCombinaisonsEnChiffre(anciennesCombinaison, i);
						
						if(chiffreAncienneCombinaisonProposeListeEntiere == chiffreInt)
							chiffreIdentique = true;
					}
					
				}while(chiffreIdentique);
							
			}
			chiffreByte = (byte) chiffreInt;
			combinaisonByte[i] = chiffreByte;
			combinaisonString = combinaisonString + String.valueOf(chiffreInt);
			System.out.println(chiffreByte);
		}
		System.out.println("l'ordinateur propose la combinaison : " + combinaisonString);
		
		Combinaison combinaison = new Combinaison(combinaisonByte);
		return combinaison;
	}
	
	public int convertirCombinaisonsEnChiffre(Combinaison combinaison, int i) {
		int chiffre;
		char ancienChiffreChar = combinaison.toString().charAt(i);
		chiffre  = Character.getNumericValue(ancienChiffreChar);
		return chiffre;
	}
	
		
}
