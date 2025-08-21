package pekopeko.afpa.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client extends Personne {

    static Scanner sc = new Scanner(System.in);

    //attibuts pour les Clients
    private String email, nom, prenom;
    private LocalDateTime dateInscription;

    //List des Clients enregistrer
    private static List<Client> clients = new ArrayList<Client>();

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

    @Override
    public String toString() {
        System.out.println("==================================================");
        return super.toString() + "email : " + email + ("\n") +
                "est inscrit : " + this.getDateCreationFormatee();
    }
}
