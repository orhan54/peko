package pekopeko.afpa.view;

import pekopeko.afpa.Utility.RegexUtility;
import pekopeko.afpa.exception.SaisieException;
import pekopeko.afpa.model.Client;
import pekopeko.afpa.model.Livre;
import pekopeko.afpa.model.Pret;
import pekopeko.afpa.model.Staff;

import java.time.LocalDateTime;
import java.util.Scanner;

import static pekopeko.afpa.Utility.RegexUtility.regexAlpha;
import static pekopeko.afpa.Utility.RegexUtility.validate;

public class viewBibliotheque {

    static Scanner sc = new Scanner(System.in); // Lecture du clavier

    //menu interface
    public static void menu() throws SaisieException { //affichage du menu accueil
        try{
            System.out.println("Voici le menu : [choisir entre 1-6 et 0 pour quitter]");
            System.out.println("1 - Enregistrer un nouvel abonné : ");
            System.out.println("2 - Enregistrer un nouveau livre : ");
            System.out.println("3 - Enregistrer un nouveau pret : ");
            System.out.println("4 - Afficher les abonnées : ");
            System.out.println("5 - Afficher la liste des livres : ");
            System.out.println("6 - Afficher la liste des prets : ");
            System.out.println("7 - Afficher la listes des staff : ");
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
        switch (choix) {
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
            case 7:
                afficherStaff();
                break;
            case 0:
                System.out.println("Vous avez quitter l'application : ");
                System.exit(0);
                break;
        }
    }

    //afficher les livres
    private static void afficherLivre() throws SaisieException {
        int i = 1;// indice pour le numero de livre de ma liste [ex: Livre°1]
        System.out.println("Voici la liste des livres : ");
        if(Livre.getLivres().isEmpty()){
            System.out.println("La liste des livres est vide : ");
            System.out.println(" ");
        } else {

            for (Livre livre : Livre.getLivres()) {
                System.out.println();
                System.out.println("Livre n°" + i++ + ":");
                System.out.println("- Titre du livre : " + livre.getTitreLivre().toUpperCase());
                System.out.println("- Auteur du livre : " + livre.getAuteurLivre().toUpperCase());
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
    private static void createLivre() throws SaisieException {

        String titreLivre;
        String auteurLivre;
        int quantiteLivre;

        sc.nextLine();
        do{
            System.out.println();
            System.out.println("Vous allez ajouter un nouveau livre : ");
            System.out.print("Nom du livre : ");
            titreLivre = sc.nextLine().toUpperCase();
            if(titreLivre.isEmpty() || !regexAlpha(titreLivre)){
                System.out.println("Error sur le nom du livre : ");
            }
        }while(titreLivre.isEmpty());

        do{
            System.out.print("Auteur du livre : ");
            auteurLivre = sc.nextLine().toUpperCase();
            if(auteurLivre.isEmpty() || !regexAlpha(auteurLivre)){
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
            Livre livre = null;
            try {
                livre = new Livre(titreLivre, auteurLivre, quantiteLivre);
            } catch (SaisieException e) {
                System.out.println("Erreur " + e.getMessage());
            }
            Livre.getLivres().add(livre);

            System.out.println();
            System.out.println("[ Le nouveau livre est bien enregistrer : ]");
            assert livre != null;
            System.out.println("Nom du livre : "+ livre.getTitreLivre());
            System.out.println("Auteur du livre : "+livre.getAuteurLivre());
            System.out.println("Quantite du livre commander : "+livre.getQuantiteLivre());
            System.out.println("Voici la reference ISBN : " + livre.getIsbn());
        }

        if(addLivre.equals("non")){
            System.out.println("Saisir [0] pour revenir au menu : ");
            int revenir = sc.nextInt();
            if (revenir == 0) {
                menu();
            }
        }

        System.out.println();
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
    private static void updateLivre() throws SaisieException {
        System.out.print("Saisir le numero du livre a modifier : ");
        int j = sc.nextInt();
        sc.nextLine();

        //parcourir tableau de Livre pour retrouver l'indice
        Livre livre = Livre.getLivres().get(j-1);

        System.out.print("Modification nom du livre : ");
        String newTitreLivre = sc.nextLine().toUpperCase();

        System.out.print("Modification auteur du livre : ");
        String newAuteurLivre = sc.nextLine().toLowerCase();

        System.out.print("Modification quantite du livre : ");
        int newQuantiteLivre = sc.nextInt();

        System.out.println("Etes vous sur de vouloir modifier : [oui/non] ");
        sc.nextLine();
        String chooseUpdateLivre = sc.nextLine();
        if(chooseUpdateLivre.equals("oui")){
            livre.setTitreLivre(newTitreLivre);
            try {
                livre.setAuteurLivre(newAuteurLivre);
            } catch (SaisieException e) {
                System.out.println("Erreur " + e.getMessage());
            }
            livre.setQuantiteLivre(newQuantiteLivre);
            System.out.println();
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
    public static void deleteLivre() throws SaisieException {
        System.out.print("Saisir le numero du livre a supprimer : ");
        int j = sc.nextInt();
        sc.nextLine();

        System.out.println("Etes vous sur de supprimer le livre : [oui/non]");
        String deleteLivre = sc.nextLine();
        if(deleteLivre.equals("oui")){
            //parcourir le tableau pour supprimer l'indice recharcher

            Livre.getLivres().remove(j-1);
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
    public static void createClient() throws SaisieException {
        String email, nom, prenom;
        LocalDateTime dateInscription;
        System.out.print("Vous voulez enregister un membre staff : [oui/non] ");
        sc.nextLine();
        String choixInscription = sc.nextLine();
        if(choixInscription.equals("oui")){
            createStaff();
        }else if(choixInscription.equals("non")){
            try{
                System.out.println("Créer un client : ");
                sc.nextLine();

                //verification du nom avec le regexAlpha
                do {
                    System.out.print("Saisir le nom : ");
                    nom = sc.nextLine().toUpperCase();
                    if(!regexAlpha(nom)) {
                        System.out.println("Erreur : Le nom est incorrecte");
                    }
                }while (!regexAlpha(nom));

                //verification du prenom avec le regexAlpha
                do {
                    System.out.print("Saisir le prenom : ");
                    prenom = sc.nextLine().toUpperCase();
                    if(!regexAlpha(prenom)) {
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

                    System.out.println();
                    System.out.println("[ Nouveau client : " + client.getNom() + "  " + client.getPrenom() + " " + client.getEmail() + "est inscrit le  " + client.getDateCreationFormatee() + " ]");
                    System.out.println(" ");
                }
                if(validateAddClient.equals("non")){
                    System.out.println();
                    System.out.println("Votre nouveau client a pas été ajouter : ");
                }
                System.out.println("Saisir 0 pour revenir au menu ou [1] afficher liste client : ");
                int saisie = sc.nextInt();
                if (saisie == 0) {
                    menu();
                }
                if (saisie == 1) {
                    afficherClient();
                }
            }catch(Exception e){
                System.err.println("Erreur dans l'inscription du Client");
            }
        }
    }

    // creation membre staff
    private static void createStaff() throws SaisieException {
        int id = 1;
        sc.nextLine();
        System.out.println("Saisir le nom du membre staff : ");
        String nomMembre = sc.nextLine();
        System.out.println("Saisir le prenom du membre : ");
        String prenomMembre = sc.nextLine();

        System.out.println("Etes vous sur de creer un nouveau staff : [oui/non] ");
        String creerMembre = sc.nextLine();
        if(creerMembre.equals("oui")){
            Staff staff = new Staff(nomMembre, prenomMembre, id);
            Staff.getStaffs().add(staff);
            System.out.println();
            System.out.println("Votre nouveau staff est : " + nomMembre + " " + prenomMembre);
        }else if(creerMembre.equals("non")){
            System.out.println("Votre nouveau membre staff est pas creer : ");
        }

        System.out.println("Saisir [0] pour le menu : [1] afficher staff [2] modiffier staff et [3] supprimer ");
        int choix = sc.nextInt();
        switch (choix){
            case 0:
                menu();
                break;
            case 1:
                afficherStaff();
                break;
            case 2:
                updateStaff();
                break;
            case 3:
                deleteStaff();
                break;
        }
    }

    private static void updateStaff() throws SaisieException {
        System.out.println("Saisir le numero staff a modifier : ");
        int j = sc.nextInt();
        sc.nextLine();

        LocalDateTime.now();

        //parcourir le tableau de staff pour trouver l'indice
        Staff staff = Staff.getStaffs().get(j-1);

        System.out.println("Le nom du staff a modifier est " + staff.getNom() + " !!");
        System.out.print("Saisir le nouveau nom du staff : ");
        String newNomStaff = sc.nextLine().toUpperCase();
        System.out.println();

        System.out.println("Le prenom du client a modifier est " + staff.getPrenom() + " !!");
        System.out.print("Saisir le nouveau prenom du staff : ");
        String newPrenomStaff = sc.nextLine().toUpperCase();
        System.out.println();

        System.out.println("Etes vous sur de vouloir modifier : [oui/non]");
        //sc.nextLine();
        String chooseUpdateClient = sc.nextLine();
        if(chooseUpdateClient.equals("oui")){
            staff.setNom(newNomStaff);
            staff.setPrenom(newPrenomStaff);
            System.out.println();
            System.out.println("[ Votre staff est bien modifier : ]");
        }

        if(chooseUpdateClient.equals("non")){
            System.out.println("Votre staff est pas modifier : ");
        }

        System.out.println("Saisir [0] pour revenir au menu ou [1] afficher liste : ");
        int revenir = sc.nextInt();
        switch (revenir){
            case 0:
                menu();
                break;
            case 1:
                afficherStaff();
                break;
        }
    }

    private static void afficherStaff() throws SaisieException {
        try{
            if(Staff.getStaffs().isEmpty()){
                System.out.println("La liste des staff est vide : ");
                System.out.println(" ");
            } else {
                System.out.println("Voici la liste des membres staff : ");
                System.out.println();
                int j = 1;
                for (Staff staff : Staff.getStaffs()) {
                    System.out.println("Staff n°" + j);
                    System.out.println(staff);
                    j++;
                    System.out.println();
                }
            }

        }catch(Exception e){
            System.err.println("Erreur dans l'affichage des membres staff : ");
        }
        System.out.println("Saisir [0] pour le menu : [1] ajouter [2] modifier [3] supprimer staff ");
        int choix = sc.nextInt();
        switch (choix){
            case 0:
                menu();
                break;
            case 1:
                createStaff();
                break;
            case 2:
                updateStaff();
                break;
            case 3:
                deleteStaff();
                break;
        }
    }

    //afficher client
    public static void afficherClient() throws SaisieException {
        try{
            System.out.println("voici la liste des clients : ");
            if (Client.getClients().isEmpty()) {
                System.out.println("        La liste des clients est vide !!   =(      ");
                System.out.println();
            }
            int i = 1;
            for (Client client : Client.getClients()) {
                System.out.println();
                System.out.println("Client n°" + i);
                System.out.println(client);
                i++;
            }
        }catch(Exception e){
            System.err.println("Erreur : "+e.getMessage());
        }
        System.out.println(" ");
        System.out.println("Saisir [0] pour revenir au menu : [1] ajouter [2] modifier et [3] supprimer");
        int revenir = sc.nextInt();

        switch (revenir){
            case 0:
                menu();
                break;
            case 1:
                createClient();
                break;
            case 2:
                updateClient();
                break;
            case 3:
                deleteClient();
                break;
        }

    }

    //mettre a jour un client
    private static void updateClient() throws SaisieException {
        System.out.println("Saisir le numero client a modifier : ");
        int j = sc.nextInt();
        sc.nextLine();

        LocalDateTime.now();

        //parcourir le tableau de client pour trouver l'indice
        Client client = Client.getClients().get(j-1);

        System.out.println("Le nom du client a modifier est " + client.getNom() + " !!");
        System.out.print("Saisir le nouveau nom du client : ");
        String newNom = sc.nextLine().toUpperCase();
        System.out.println();

        System.out.println("Le prenom du client a modifier est " + client.getPrenom() + " !!");
        System.out.print("Saisir le nouveau prenom du client : ");
        String newPrenom = sc.nextLine().toUpperCase();
        System.out.println();

        System.out.println("Le email du client a modifier est " + client.getEmail() + " !!");
        System.out.print("Saisir le nouveau email du client : ");
        String newEmail = sc.nextLine().toLowerCase();
        System.out.println();

        System.out.println("Etes vous sur de vouloir modifier : [oui/non]");
        //sc.nextLine();
        String chooseUpdateClient = sc.nextLine();
        if(chooseUpdateClient.equals("oui")){
            client.setNom(newNom);
            client.setPrenom(newPrenom);
            client.setEmail(newEmail);
            System.out.println();
            System.out.println("[ Votre client est bien modifier : ]");
        }

        if(chooseUpdateClient.equals("non")){
            System.out.println("Votre client est pas modifier : ");
        }

        System.out.println("Saisir [0] pour revenir au menu ou [1] afficher liste : ");
        int revenir = sc.nextInt();
        switch (revenir){
            case 0:
                menu();
                break;
            case 1:
                afficherClient();
                break;
        }

    }

    //supprimer un client
    private static void deleteClient() throws SaisieException {
        System.out.println("Voulez vous supprimer un membre staff : [oui/non] ");
        String choix = sc.nextLine();
        if (choix.equals("oui")){
            deleteStaff();
        }else{
            System.out.println("Saisir le numero client a supprimer : ");
            int j = sc.nextInt();
            sc.nextLine();

            System.out.println("Etes vous sur de supprimer le client : [oui/non]");
            String chooseDeleteClient = sc.nextLine();
            if(chooseDeleteClient.equals("oui")){
                //parcourir le tableau pour supprimer le client
                Client client = Client.getClients().get(j-1);

                Client.getClients().remove(j-1);
                System.out.println();
                System.out.println("[ Votre client " + client.getNom() + " " + client.getPrenom() + " est bien supprimer de la liste ! ]");
                System.out.println();
                System.out.println("Saisir [0] pour revenir au menu ou [1] afficher liste : ");
                System.out.println();
            } else if (chooseDeleteClient.equals("non")) {
                System.out.println();
                System.out.println("Votre client n'est pas supprimer de la liste ! : ");
                System.out.print("Saisir [0] pour revenir au menu ou [1] afficher liste : ");
            }

            int revenir = sc.nextInt();
            switch (revenir){
                case 0:
                    menu();
                    break;
                case 1:
                    afficherClient();
                    break;
            }
        }
    }

    private static void deleteStaff() throws SaisieException {
        System.out.println("Saisir le numero du staff a supprimer : ");
        int j = sc.nextInt();
        sc.nextLine();

        System.out.println("Etes vous sur de supprimer le staff : [oui/non]");
        String chooseDeleteClient = sc.nextLine();
        if(chooseDeleteClient.equals("oui")){
            //parcourir le tableau pour supprimer le client
            Staff staff = Staff.getStaffs().get(j-1);

            Staff.getStaffs().remove(j-1);
            System.out.println();
            System.out.println("[ Votre client " + staff.getNom() + " " + staff.getPrenom() + " est bien supprimer de la liste ! ]");
            System.out.println();
            System.out.println("Saisir [0] pour revenir au menu ou [1] afficher liste : ");
            System.out.println();
        } else if (chooseDeleteClient.equals("non")) {
            System.out.println();
            System.out.println("Votre membre staff n'est pas supprimer de la liste ! : ");
            System.out.print("Saisir [0] pour revenir au menu ou [1] afficher liste : ");
        }

        int revenir = sc.nextInt();
        switch (revenir){
            case 0:
                menu();
                break;
            case 1:
                afficherStaff();
                break;
        }
    }

    //afiicher les prets et si le livre est disponible
    private static void pretLivre() throws SaisieException {
        LocalDateTime datePret;
        int i = 1;// indice pour le numero de livre de ma liste [ex: Livre°1]
        System.out.println();
        System.out.println("Voici la liste des livres : ");
        if(Livre.getLivres().isEmpty()){
            System.out.println("La liste des livres est vide : ");
            System.out.println(" ");
        } else {

            for (Livre livre : Livre.getLivres()) {
                System.out.println();
                System.out.println("Livre n°" + i++ + ":");
                System.out.println("- Titre du livre : " + livre.getTitreLivre().toUpperCase());
                System.out.println("- Auteur du livre : " + livre.getAuteurLivre().toUpperCase());
                System.out.println("- Quantité du livre : " + livre.getQuantiteLivre());
                System.out.println("- ISBN du livre : " + livre.getIsbn());
            }
        }
        System.out.println();
        System.out.println("Enregistrer votre livre pour le pret :");
        sc.nextLine();
        System.out.print("Saisir le titre du livre : ");
        String titreLivre = sc.nextLine();
        System.out.print("Saisir le nom du client : ");
        String nomClient = sc.nextLine();
        System.out.print("");
        datePret = LocalDateTime.now();

        Pret pret = new Pret(titreLivre, nomClient, datePret);
        Pret.getPrets().add(pret);
        System.out.println();
        System.out.print("L'abonné(e) au nom de " + nomClient + " a reserver le livre " +  titreLivre + " le " + pret.getDatePretFormatee() + " : ");
        System.out.println();

        System.out.print("Saisir 0 pour revenir au menu ou [1] pour afficher les prets : ");
        int revenir = sc.nextInt();
        switch (revenir){
            case 0:
                menu();
                break;
            case 1:
                afficherPret();
                break;
        }

    }

    private static void afficherPret() throws SaisieException {
        try{
            System.out.println();
            System.out.println("Voici la liste des prets : ");
            System.out.println();
            if (Pret.getPrets().isEmpty()) {
                System.out.println("        La liste des prets est vide !!   =(      ");
                System.out.println();
            }
            int j = 1;
            for (Pret pret : Pret.getPrets()) {
                System.out.println("Pret n°" + j);
                System.out.println("- Le titre du livre : " + pret.getTitreLivrePret());
                System.out.println("- Nom de l'abonné(e) : " + pret.getNomLivrePret());
                System.out.println("- Réserver le livre : " + pret.getDatePretFormatee());
                System.out.println();
                j++;
            }
        }catch(Exception e){
            System.err.println("Erreur : "+e.getMessage());
        }
        System.out.println("Saisir [0] pour revenir au menu : ");
        int revenir = sc.nextInt();
        if (revenir == 0) {
            menu();
        }
    }

}

