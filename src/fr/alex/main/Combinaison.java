package fr.alex.main;

public class Combinaison {
	
	Proprietes propriete = new Proprietes();
	protected final String NB_DE_COUP_MAX = propriete.getNbDeCoupMax();
	protected final String NB_DE_CHIFFRE_COMBINAISON = propriete.getNbDeChiffreCombinaison();
	
	private byte[] chiffres = new byte[4];
	
	
	public Combinaison(byte[] chiffres) {
		super();
		this.chiffres = chiffres;
	}
	
	
	public String Comparer(Combinaison combinaisonAttaquant) {
		String indice = "";
		String indiceTotal = "";
				
			for(int i = 0; i < Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON); i++) {
				if(this.chiffres[i] == combinaisonAttaquant.chiffres[i]) { 
					indice = "=";
					PartieChallenger.nombreIndiceEgale++;
					
				}else if(this.chiffres[i] < combinaisonAttaquant.chiffres[i]) 
					indice = "-";
				else indice = "+";	
				
				indiceTotal += indice;
			}
			
			if(Parties.nombreIndiceEgale != Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON))
				Parties.nombreIndiceEgale = 0;
		
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
