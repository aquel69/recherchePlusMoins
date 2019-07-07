package fr.alex.main;

public class Combinaison {
	
	private byte[] chiffres = new byte[4];
	
	
	public Combinaison(byte[] chiffres) {
		super();
		this.chiffres = chiffres;
	}
	
	
	public String Comparer(Combinaison combinaisonAttaquant) {
		String indice = "";
		String indiceTotal = "";
				
			for(int i = 0; i < 4; i++) {
				if(this.chiffres[i] == combinaisonAttaquant.chiffres[i]) { 
					indice = "=";
					PartieChallenger.nombreIndiceEgale++;
					
				}else if(this.chiffres[i] < combinaisonAttaquant.chiffres[i]) 
					indice = "-";
				else indice = "+";	
				
				indiceTotal += indice;
			}
			
			if(PartieChallenger.nombreIndiceEgale != 4)
				PartieChallenger.nombreIndiceEgale = 0;
		
		return indiceTotal;
	}
	
		
	public String toString() {
		String chiffreString = "";
			
		for (int i = 0; i < chiffres.length; i++){
			
			chiffreString += chiffres[i];
		}
		return chiffreString;
	}
	
}
