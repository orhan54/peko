package pekopeko.afpa.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientModel extends PersonneModel{

    //attibuts pour les Clients
    private String email;
    private Date dateInscription;

    //List des Clients enregistrer
    private static List<ClientModel> clients = new ArrayList<ClientModel>();

    //constructeur avec le super qui extends de Personne
    public ClientModel(String nom, String prenom, String email, Date dateInscription) {
        super(nom, prenom);
        this.email = email;
        this.dateInscription = dateInscription;
    }

    //afficher la List Client
    public static List<ClientModel> getClients() {
        return clients;
    }

    //Getters et Setters pour acceder au attributs private
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateInscription() {
        return this.dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }
}
