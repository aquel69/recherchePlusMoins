package fr.alex.main;

import java.util.List;
import java.util.Scanner;

public class Humain extends Joueur {

	public Humain(String pNom) {
		super(pNom);

	}

	// fonction qui demande la combinaison mystere au joueur
	public Combinaison DonnerCombinaisonMystere() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		byte[] combinaisonByte = new byte[Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON)];
		String combinaisonString;

		// demande et entrée de la saisie du joueur
		System.out.print("\n" + nom + " veuillez saisir " + Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON)
				+ " chiffres afin de donner la combinaison mystère : ");

		do {
			combinaisonString = sc.nextLine();
			verificationSaisie.erreurDeSaisieCombinaison(combinaisonString);
			System.out.println(verificationSaisie.erreurDeSaisieCombinaison(combinaisonString));
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

	// fonction qui demande une proposition de combinaison au joueur et conversion
	// en tableau byte
	public Combinaison ProposerCombinaison(List<Combinaison> listeDesPropositionDeCombinaison, List<String> indices) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		byte[] combinaisonByte = new byte[Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON)];
		String combinaisonString;
		System.out.println("\n----------------------------------------------------------");
		System.out.print(nom + " veuillez proposer une combinaison à " + Integer.parseInt(NB_DE_CHIFFRE_COMBINAISON)
				+ " chiffres afin de trouver la combinaison mystère : ");

		do {
			combinaisonString = sc.nextLine();
			verificationSaisie.erreurDeSaisieCombinaison(combinaisonString);
			System.out.print(verificationSaisie.erreurDeSaisieCombinaison(combinaisonString));
		} while (VerificationSaisie.SiEntrerClavierEstVrai);

		for (int i = 0; i < combinaisonString.length(); i++) {
			char[] combinaisonChar = combinaisonString.toCharArray();
			int a = Character.getNumericValue(combinaisonChar[i]);
			combinaisonByte[i] = (byte) a;
		}

		Combinaison combinaison = new Combinaison(combinaisonByte);

		return combinaison;
	}

	public String DonnerLesIndices() {
		Parties.nombreIndiceEgaleOrdinateur = 0;

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String indices;

		System.out.print("Donner les indices correspondant à la proposition : ");

		do {
			indices = sc.nextLine();
			verificationSaisie.erreurDeSaisieIndice(indices);
			System.out.print(verificationSaisie.erreurDeSaisieIndice(indices));
		} while (VerificationSaisie.SiEntrerClavierEstVrai);

		// calcul nombre indice '='
		for (int i = 0; i < indices.length(); i++) {
			if (indices.charAt(i) == '=')
				Parties.nombreIndiceEgaleOrdinateur++;
		}

		return indices;
	}

}
