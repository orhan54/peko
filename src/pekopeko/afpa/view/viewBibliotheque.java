package pekopeko.afpa.view;

import pekopeko.afpa.Utility.RegexUtility;
import pekopeko.afpa.model.Client;
import pekopeko.afpa.model.Livre;

import java.util.Scanner;

public class viewBibliotheque {

    static Scanner sc = new Scanner(System.in); // Lecture du clavier

    public static void menu() { //affichage du menu accueil
        try{
            System.out.println("Voici le menu : [choisir entre 1-6 et 0 pour quitter]");
            System.out.println("1 - Enregistrer un nouvel abonné : ");
            System.out.println("2 - Enrgistrer un nouveau livre : ");
            System.out.println("3 - Enregistrer un nouveau pret : ");
            System.out.println("4 - Afficher les abonnées : ");
            System.out.println("5 - Afficher la liste des livres : ");
            System.out.println("6 - Afficher la liste des prets : ");
            System.out.println("0 - Quitter : ");
        }catch(Exception e){
            System.out.println("Erreur au lancement du choix menu " + e.getMessage());
        }

        System.out.print("Saisir choix menu : ");
        int choix = sc.nextInt();

        if(RegexUtility.PositiveIntStrict(String.valueOf(choix))) {
            choix = Integer.parseInt(String.valueOf(choix));
        }else{
            System.out.println("Erreur saisir un nombre qui correspond au menu !");
        }

        if(choix>=0||choix<=6){
            switch(choix){
                case 1:
                    Client.createClient();
                    break;
                case 2:
                    Livre.createLivre();
                    break;
                case 0:
                    System.out.println("Vous avez quitter l'application : ");
                    break;

            }
        }

    }

}
