package pekopeko.afpa.model;

import pekopeko.afpa.Utility.RegexUtility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static pekopeko.afpa.Utility.RegexUtility.regexAlpha;
import static pekopeko.afpa.Utility.RegexUtility.validate;
import static pekopeko.afpa.view.viewBibliotheque.menu;

public class Client extends Personne {

    static Scanner sc = new Scanner(System.in);

    //attibuts pour les Clients
    private static String email;
    private static LocalDateTime dateInscription;

    //List des Clients enregistrer
    private static List<Client> clients = new ArrayList<Client>();
    private static String nom, prenom;

    //constructeur avec le super qui extends de Personne
    public Client(String nom, String prenom, String email, LocalDateTime dateInscription) {
        super(nom, prenom);
        this.email = email;
        this.dateInscription = LocalDateTime.now();
    }

    //afficher la List Client
    public static List<Client> getClients() {
        return clients;
    }

    //Getters et Setters pour acceder au attributs private
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDateInscription() {
        return this.dateInscription;
    }

    // Retourne la date formatée
    public String getDateCreationFormatee() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy 'à' HH:mm");
        return dateInscription.format(formatter);
    }

    public static void createClient() {
        try{
            System.out.println("Créer un client : ");

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
            Client.clients.add(client);

            System.out.println("");
            System.out.println("[ Nouveau client : " + client.getNom() + "  " + client.getPrenom() + " " + client.getEmail() + " est inscrit le  " + client.getDateCreationFormatee() + " ]");
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

//    @Override
//    public String toString() {
//        return super.toString() + "email : " + email +
//                " est inscrit : " + this.getDateCreationFormatee();
//    }
}
