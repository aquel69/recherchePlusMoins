package fr.alex.escapegame.jeu;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.alex.escapegame.EscapeGame;
import fr.alex.escapegame.utils.VerificationSaisie;

/**
 * La classe Humain permet de créér un joueur de type humain
 * @author alex
 *
 */
public class Humain extends Joueur {
	static Logger logger = LogManager.getLogger(EscapeGame.class);
	/**
	 * constructeur permettant de créér un joueur humain 
	 * @param pNom de type String permet de donner un nom au joueur humain
	 */
	public Humain(String pNom) {
		super(pNom);
	}

	/**
	 * 
	 * fonction qui demande au joueur humain d'entrer la combinaison mystere dans une variable String
	 * et la convertit en tableau byte pour l'entrer en paramètre du constructeur de la classe Combinaison
	 * 
	 * @return la Combinaison mystere
	 *
	 */
	public Combinaison DonnerCombinaisonMystere() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		byte[] combinaisonByte = new byte[Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON)];
		String combinaisonString;

		// demande et entrée de la saisie du joueur
		System.out.print("Veuillez saisir les " + Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON)
				+ " chiffres\nde la combinaison mystère : ");
		
		do {
			combinaisonString = sc.nextLine();
			verificationSaisie.erreurDeSaisieCombinaison(combinaisonString);
			System.out.print(verificationSaisie.erreurDeSaisieCombinaison(combinaisonString));
			if(VerificationSaisie.SiEntrerClavierEstVrai)
				logger.info("erreur saisie de la combinaison, le joueur a rentré : " + combinaisonString);
		} while (VerificationSaisie.SiEntrerClavierEstVrai);

		// conversion et remplissage du tableau byte a partir de la saisie String
		for (int i = 0; i < combinaisonString.length(); i++) {
			char[] combinaisonChar = combinaisonString.toCharArray();
			int a = Character.getNumericValue(combinaisonChar[i]);
			combinaisonByte[i] = (byte) a;
		}
		Combinaison combinaison = new Combinaison(combinaisonByte);
		
		return combinaison;
	}

	/**
	 * 
	 * fonction qui demande au joueur humain d'entrer une proposition de combinaison dans une variable String
	 * et la convertit en tableau byte pour l'entrer en paramètre du constructeur de la classe Combinaison
	 *  
	 * @return la proposition combinaison du joueur humain
	 */
	public Combinaison ProposerCombinaison(List<Combinaison> listeDesPropositionDeCombinaison, List<String> indices) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		byte[] combinaisonByte = new byte[Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON)];
		String combinaisonString;
		//System.out.println("\n----------------------------------------------------------");
		System.out.print("Veuillez proposer une combinaison à " + Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON)
				+ " chiffres\nafin de trouver la combinaison mystère : ");

		do {
			combinaisonString = sc.nextLine();
			verificationSaisie.erreurDeSaisieCombinaison(combinaisonString);
			System.out.print(verificationSaisie.erreurDeSaisieCombinaison(combinaisonString));
			if(VerificationSaisie.SiEntrerClavierEstVrai)
				logger.info("erreur saisie de la combinaison, le joueur a rentré : " + combinaisonString);
		} while (VerificationSaisie.SiEntrerClavierEstVrai);

		for (int i = 0; i < combinaisonString.length(); i++) {
			char[] combinaisonChar = combinaisonString.toCharArray();
			int a = Character.getNumericValue(combinaisonChar[i]);
			combinaisonByte[i] = (byte) a;
		}
		Combinaison combinaison = new Combinaison(combinaisonByte);

		return combinaison;
	}
	
	/**
	 * la fonction permet de demander au joueur humain les indices correspondant à la proposition du joueur ordinateur
	 * 
	 * @return une variable de type String contenant les indices 
	 */
	public String DonnerLesIndices() {
		Parties.nombreIndiceEgaleOrdinateur = 0;

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String indices;

		System.out.print("Donner les indices de la proposition : ");

		do {
			indices = sc.nextLine();
			verificationSaisie.erreurDeSaisieIndice(indices);
			System.out.print(verificationSaisie.erreurDeSaisieIndice(indices));
			if(VerificationSaisie.SiEntrerClavierEstVrai)
				logger.info("erreur saisie des indices, le joueur a rentré : " + indices);
		} while (VerificationSaisie.SiEntrerClavierEstVrai);

		// calcul nombre indice '='
		for (int i = 0; i < indices.length(); i++) {
			if (indices.charAt(i) == '=')
				Parties.nombreIndiceEgaleOrdinateur++;
		}

		return indices;
	}

	@Override
	public byte convertirCombinaisonsEnChiffre(Combinaison combinaison, int emplacementDansLeTableau) {
		
		return 0;
	}

}
