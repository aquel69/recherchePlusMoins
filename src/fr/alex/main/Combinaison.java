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
					PartieClassique.nombreIndiceEgale++;
					
				}else if(this.chiffres[i] < combinaisonAttaquant.chiffres[i]) 
					indice = "-";
				else indice = "+";	
				
				indiceTotal += indice;
			}
			
			if(PartieClassique.nombreIndiceEgale != 4)
				PartieClassique.nombreIndiceEgale = 0;
		
		return indiceTotal;
	}
	
	/*public int toInt() {
		String chiffre
		int chiffreInt;
		
		for (int i = 0; i < chiffres.length; i++){
			
			chiffreString += chiffres[i];
		}
		
		
		return 
	}*/
	
	public String toString() {
		
		String chiffreString = "";
			
		for (int i = 0; i < chiffres.length; i++){
			
			chiffreString += chiffres[i];
		}
		//System.out.println(chiffreString);
		return chiffreString;
	}
		
	

	
	
}
