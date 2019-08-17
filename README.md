# recherche Plus / Moins


**1.Les Différents Modes**

		*Le mode "Challenger" / Le joueur doit trouver la combinaison mystère en un nombre de coup limité.
		*Le mode "Défenseur"  / Le joueur donne une combinaison mystère et les indices nécessaires à l'ordinateur pour qu'il puisse trouver la combinaison en un nombre de coup limité.
		*Le Mode "Duel"       / Le joueur joue contre l'ordinateur. Le premier à trouver la combinaison mystère de l'autre dans le nombre de coup imparti à gagné.
		
**2.Lancer l'application avec éclipse**

		1. Allez dans le repo "recherchePlusMoins, trouver sur le site github à cette adresse(https://github.com/aquel69/recherchePlusMoins), puis dans "clone or download", copier le lien.  
		2. Dans l'IDE éclipse faites : File -> Import
		3. Allez dans Git et faites : Projects from Git et ensuite Clone URL
		4. Collez l'adresse du repo dans la première case URL(la suite devrait se remplir tout seul)
		5. Sélectionnez la branch Master
		6. Indiquez l'emplacement du dossier souhaité de votre repo Git dans la case "Directory"
		7. Cochez la case "import existing Eclipse Projects". Votre repository Git est désormais installé
		8. Dans la partie Git Repositories de votre interface Eclipse(Window -> Show View -> other -> Gits -> Git repositories)
		9. Faites un clic droit sur le repo concerné et choissisez "import Projects"
		10. vérifiez l'emplacement et faites finish
		11. Eclipse se charge d'ajouter le projet dans le Package Explorer
		12. Si une erreur apparait concernant Log4j2. Ajouter le fichier ressources dans le classPath(Run -> Run Configurations... -> puis dans l'onglet "Dependencies" -> Classpath Entries
			 -> Advanced -> Add Folders -> puis sélectionner le fichier "ressources" dans votre projet -> apply -> run
		13. Le programme se lance
		
**3.Lancer l'application en mode console**

		1. Mettre le fichier recherchePlusMoins.jar dans un dossier
		2. Extraire les fichiers du recherchePlusMoins.jar dans le dossier
		3. Lancez un terminal(cmder, gitbash...) à partir du dossier
		4. entrer la ligne de commande suivante : java -Dfile.encoding=UTF-8 -classpath "C:\Users\alex\Desktop\openclassrooms\projet 3\recherchePlusMoins\bin;
		C:\Users\alex\Desktop\openclassrooms\projet 3\recherchePlusMoins\lib\log4j-api-2.12.0.jar;C:\Users\alex\Desktop\openclassrooms\projet 3\recherchePlusMoins\lib\log4j-core-2.12.0.jar;
		C:\Users\alex\Desktop\openclassrooms\projet 3\recherchePlusMoins\ressources"fr.alex.escapegame.EscapeGame
		5. faire entrer et le programme se lance
		

**4.Fichier .properties**

		1. Le mode développeur donne la solution de la combinaison mystère. Pour l'activer mettre 1 en valeur ou 0 pour le désactiver
		2. Le nombre de coup maximum détermine le nombre de coup au joueur attaquant pour trouver la combinaison mystère
		3. Le nombre de chiffre combinaison détermine le nombre de chiffre composant la combinaison	

		
		
		
		