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
                    pretLivre();
                    break;
                case 4:
                    afficherClient();
                    break;
                case 5:
                    afficherLivre();
                    break;
                case 6:
                    afficherPret();
                    break;
                case 0:
                    System.out.println("Vous avez quitter l'application : ");
                    System.exit(0);
                    break;
            }
        }
    }

    //afficher les livres
    private static void afficherLivre() {
        int i = 1;// indice pour le numero de livre de ma liste [ex: Livre°1]
        System.out.println("Voici la liste des livres : ");
        if(Livre.getLivres().isEmpty()){
            System.out.println("La liste des livres est vide : ");
            System.out.println(" ");
        } else {

            for (Livre livre : Livre.getLivres()) {
                System.out.println("");
                System.out.println("Livre n°" + i++ + ":");
                System.out.println("- Titre du livre : " + livre.getTitreLivre());
                System.out.println("- Auteur du livre : " + livre.getAuteurLivre());
                System.out.println("- Quantité du livre : " + livre.getQuantiteLivre());
                System.out.println("- ISBN du livre : " + livre.getIsbn());
            }
        }
        System.out.println(" ");
        System.out.println("Saisir [0] pour revenir au menu : [1] ajouter [2] modifier et [3] supprimer");
        int revenir = sc.nextInt();
        switch(revenir){
            case 0:
                menu();
                break;
            case 1:
                createLivre();
                break;
            case 2:
                updateLivre();
                break;
            case 3:
                deleteLivre();
                break;
        }

    }

    //creation d'un livre
    private static void createLivre() {

        String isbn;
        String titreLivre;
        String auteurLivre;
        int quantiteLivre;

        sc.nextLine();
        do{
            System.out.println("");
            System.out.println("Vous allez ajouter un nouveau livre : ");
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

        System.out.println("Confirmation pour ajouter le nouveau livre dans la liste : [oui/non]");
        sc.nextLine();
        String addLivre = sc.nextLine();
        if(addLivre.equals("oui")){
            Livre livre = new Livre(titreLivre, auteurLivre, quantiteLivre);
            Livre.getLivres().add(livre);

            System.out.println("");
            System.out.println("[ Le nouveau livre est bien enregistrer : ]");
            System.out.println("Nom du livre : "+ livre.getTitreLivre());
            System.out.println("Auteur du livre : "+livre.getAuteurLivre());
            System.out.println("Quantite du livre commander : "+livre.getQuantiteLivre());
            System.out.println("Voici la reference ISBN : " + livre.getIsbn());
        }

        if(addLivre.equals("non")){
            System.out.println("Saisir [0] pour revenir au menu : ");
            int revenir = sc.nextInt();
            switch(revenir){
                case 0:
                    menu();
                    break;
            }
        }

        System.out.println("");
        System.out.println("Saisir [0] pour revenir au menu et [1] pour afficher la liste des livres :  ");
        int retour = sc.nextInt();
        sc.nextLine();
        if(retour==0){
            menu();
        }else if(retour==1){
            afficherLivre();
        }
    }

    //modification du livre
    private static void updateLivre() {
        System.out.print("Saisir le numero du livre a modifier : ");
        int j = sc.nextInt();
        sc.nextLine();

        //parcourir tableau de Livre pour retrouver l'indice
        Livre livre = Livre.getLivres().get(j-1);

        System.out.print("Modification nom du livre : ");
        String newTitreLivre = sc.nextLine();

        System.out.print("Modification auteur du livre : ");
        String newAuteurLivre = sc.nextLine();

        System.out.print("Modification quantite du livre : ");
        int newQuantiteLivre = sc.nextInt();

        System.out.println("Etes vous sur de vouloir modifier : [oui/non] ");
        sc.nextLine();
        String chooseUpdateLivre = sc.nextLine();
        if(chooseUpdateLivre.equals("oui")){
            livre.setTitreLivre(newTitreLivre);
            livre.setAuteurLivre(newAuteurLivre);
            livre.setQuantiteLivre(newQuantiteLivre);
            System.out.println("");
            System.out.println("[ Votre livre est bien modifié ! ]");
        }
        if(chooseUpdateLivre.equals("non")){
            System.out.println("Votre livre est pas mis a jour : ");
        }

        System.out.print("Saisir [0] pour revenir au menu ou [1] afficher liste : ");
        int retour = sc.nextInt();
        sc.nextLine();
        switch (retour){
            case 1:
                afficherLivre();
                break;
            case 0:
                menu();
                break;
        }
    }

    //methde pour delete un livre
    public static void deleteLivre() {
        System.out.print("Saisir le numero du livre a supprimer : ");
        int j = sc.nextInt();
        sc.nextLine();

        System.out.println("Etes vous sur de supprimer le livre : [oui/non]");
        String deleteLivre = sc.nextLine();
        if(deleteLivre.equals("oui")){
            //parcourir le tableau pour supprimer l'indice recharcher
            Livre livre = Livre.getLivres().get(j-1);

            livre.getLivres().remove(j-1);
            System.out.println(" ");
            System.out.println("Votre livre n°"+ j + " est bien supprimer de la liste : ");
            System.out.print(" ");
            System.out.print("Saisir [0] pour revenir au menu ou [1] afficher liste : ");
            System.out.println(" ");
        }else if(deleteLivre.equals("non")){
            System.out.print("");
            System.out.print("Saisir [0] pour revenir au menu ou [1] afficher liste : ");
        }

        int retour = sc.nextInt();
        sc.nextLine();
        switch (retour){
            case 1:
                afficherLivre();
                break;
            case 0:
                menu();
                break;
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

            System.out.println("Etes vous sur de vouloir ajouter un nouveau client : [oui/non] ");
            String validateAddClient = sc.nextLine();
            if(validateAddClient.equals("oui")){
                Client client = new Client(nom, prenom, email, dateInscription);
                client.setEmail(email);
                Client.getClients().add(client);

                System.out.println("");
                System.out.println("[ Nouveau client : " + client.getNom() + "  " + client.getPrenom() + " " + client.getEmail() + "est inscrit le  " + client.getDateCreationFormatee() + " ]");
                System.out.println(" ");
            }
            if(validateAddClient.equals("non")){
                System.out.println("");
                System.out.println("Votre nouveau client a pas été ajouter : ");
            }
            System.out.println("Saisir 0 pour revenir au menu ou [1] afficher liste client : ");
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
            int i = 1;
            for (Client client : Client.getClients()) {
                System.out.println("");
                System.out.println("Client n°" + i);
                System.out.println(client);
                i++;
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

    //afiicher les prets et si le livre est disponible
    private static void pretLivre() {
        LocalDateTime datePret;
        System.out.println("Enregistrer votre livre pour le pret : [0] pour revenir au menu : ");
        System.out.println("");
        sc.nextLine();
        System.out.print("Saisir le titre du livre : ");
        String titreLivre = sc.nextLine();
        System.out.print("Saisir le nom du client : ");
        String nomClient = sc.nextLine();
        System.out.print("");
        datePret = LocalDateTime.now();

        Pret pret = new Pret(titreLivre,nomClient , datePret);
        Pret.getPrets().add(pret);
        System.out.println("");
        System.out.print("L'abonné(e) au nom de " + nomClient + " a reserver le livre " +  titreLivre + " le " + pret.getDatePretFormatee() + " : ");
        System.out.println("");

        System.out.print("Saisir 0 pour revenir au menu : ");
        int revenir = sc.nextInt();
        if (revenir == 0) {
            menu();
        }
    }

    private static void afficherPret() {
        try{
            System.out.println("voici la liste des prets : ");
            if (Pret.getPrets().isEmpty()) {
                System.out.println("        La liste des prets est vide !!   =(      ");
                System.out.println("");
            }
            for (Pret pret : Pret.getPrets()) {
                System.out.println("==========================================================");
                System.out.println("- Le titre du livre : " + pret.getTitreLivrePret());
                System.out.println("- Nom de l'abonné(e) : " + pret.getNomLivrePret());
                System.out.println("- Réserver le livre : " + pret.getDatePretFormatee());
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

