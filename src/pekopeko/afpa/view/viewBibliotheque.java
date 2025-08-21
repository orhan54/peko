package pekopeko.afpa.view;

import pekopeko.afpa.Utility.RegexUtility;
import pekopeko.afpa.model.Client;
import pekopeko.afpa.model.Livre;
import pekopeko.afpa.model.Pret;

import java.time.LocalDateTime;
import java.util.Scanner;

import static pekopeko.afpa.Utility.RegexUtility.regexAlpha;
import static pekopeko.afpa.Utility.RegexUtility.validate;

public class viewBibliotheque {

    static Scanner sc = new Scanner(System.in); // Lecture du clavier

    //menu interface
    public static void menu() { //affichage du menu accueil
        try{
            System.out.println("Voici le menu : [choisir entre 1-6 et 0 pour quitter]");
            System.out.println("1 - Enregistrer un nouvel abonné : ");
            System.out.println("2 - Enregistrer un nouveau livre : ");
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

        //switch choix menu
        if(choix>=0||choix<=6){
            switch(choix){
                case 1:
                    createClient();
                    break;
                case 2:
                    createLivre();
                    break;
                case 3:
                    Pret.pretLivre();
                    break;
                case 4:
                    afficherClient();
                    break;
                case 5:
                    afficherLivre();
                    break;
                case 6:
                    Pret.afficherPret();
                    break;
                case 0:
                    System.out.println("Vous avez quitter l'application : ");
                    break;

            }
        }

    }

    //afficher les livres
    private static void afficherLivre() {

        System.out.println("Voici la liste des livres : ");
        if(Livre.getLivres().isEmpty()){
            System.out.println("La liste des livres est vide : ");
            System.out.println(" ");
        } else {
            for (Livre livre : Livre.getLivres()) {
                System.out.println("");
                System.out.println("- Titre du livre : " + livre.getTitreLivre());
                System.out.println("- Auteur du livre : " + livre.getAuteurLivre());
                System.out.println("- Quantité du livre : " + livre.getQuantiteLivre());
                System.out.println("- ISBN du livre : " + livre.getIsbn());
            }
        }
        System.out.println(" ");
        System.out.println("Saisir [0] pour revenir au menu : ");
        int revenir = sc.nextInt();
        if (revenir == 0) {
            menu();
        }
    }

    //creation d'un livre
    private static void createLivre() {

        String isbn;
        String titreLivre;
        String auteurLivre;
        int quantiteLivre;

        do{
            System.out.print("Nom du livre : ");
            titreLivre = sc.nextLine().toUpperCase();
            if(titreLivre.length()<1 || !regexAlpha(titreLivre) || titreLivre == null){
                System.out.println("Error sur le nom du livre : ");
            }
        }while(titreLivre.length()<1 || titreLivre == null);

        do{
            System.out.print("Auteur du livre : ");
            auteurLivre = sc.nextLine().toUpperCase();
            if(auteurLivre.length()<1 || !regexAlpha(auteurLivre) || auteurLivre == null){
                System.out.println("Error sur l'auteur du livre : ");
            }
        }while(!regexAlpha(auteurLivre));

        do{
            System.out.print("Quantite du livre : ");
            quantiteLivre = sc.nextInt();
            if(quantiteLivre<10 || quantiteLivre>50){
                System.out.println("Error sur quantite du livre : ");
            }
        }while(quantiteLivre<=10  || quantiteLivre>=50);

        Livre livre = new Livre(titreLivre, auteurLivre, quantiteLivre);
        Livre.getLivres().add(livre);

        System.out.println("");
        System.out.println("[ Le nouveau livre est bien enregistrer : ]");
        System.out.println("Nom du livre : "+ livre.getTitreLivre());
        System.out.println("Auteur du livre : "+livre.getAuteurLivre());
        System.out.println("Quantite du livre commander : "+livre.getQuantiteLivre());
        System.out.println("Voici la reference ISBN : " + livre.getIsbn());

        System.out.println("");
        System.out.println("Saisir [0] pour revenir au menu");
        int retour = sc.nextInt();
        sc.nextLine();
        if(retour==0){
            menu();
        }
    }

    //creer un nouveau client
    public static void createClient() {
        String email, nom, prenom;
        LocalDateTime dateInscription;

        try{
            System.out.println("Créer un client : ");
            sc.nextLine();

            //verification du nom avec le regexAlpha
            do {
                System.out.print("Saisir le nom : ");
                nom = sc.nextLine().toUpperCase();
                if(!regexAlpha(nom) || nom == null) {
                    System.out.println("Erreur : Le nom est incorrecte");
                }
            }while (!regexAlpha(nom));

            //verification du prenom avec le regexAlpha
            do {
                System.out.print("Saisir le prenom : ");
                prenom = sc.nextLine().toUpperCase();
                if(!regexAlpha(prenom) || prenom == null) {
                    System.out.println("Erreur : Le prenom est incorrecte");
                }
            }while (!regexAlpha(prenom));

            do{
                System.out.print("Email : ");
                email = sc.nextLine();
                if(!validate(email)){
                    System.out.println("Error saisir un email valide(ex: test@test.fr)");
                }
            }while(!validate(email));
            dateInscription = LocalDateTime.now();

            Client client = new Client(nom, prenom, email, dateInscription);
            client.setEmail(email);
            Client.getClients().add(client);

            System.out.println("");
            System.out.println("[ Nouveau client : " + client.getNom() + "  " + client.getPrenom() + " " + client.getEmail() + "est inscrit le  " + client.getDateCreationFormatee() + " ]");
            System.out.println(" ");
            System.out.println("Saisir 0 pour revenir au menu : ");
            int saisie = sc.nextInt();
            if (saisie == 0) {
                menu();
            }
        }catch(Exception e){
            System.err.println("Erreur dans l'inscription du Client");
        }
    }

    //afficher client
    public static void afficherClient() {
        try{
            System.out.println("voici la liste des clients : ");
            if (Client.getClients().isEmpty()) {
                System.out.println("        La liste des clients est vide !!   =(      ");
                System.out.println("");
            }
            for (Client client : Client.getClients()) {
                System.out.println(client);
            }
        }catch(Exception e){
            System.err.println("Erreur : "+e.getMessage());
        }
        System.out.println(" ");
        System.out.println("Saisir [0] pour revenir au menu : ");
        int revenir = sc.nextInt();
        if (revenir == 0) {
            menu();
        }
    }

}

