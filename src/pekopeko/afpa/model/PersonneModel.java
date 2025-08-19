package pekopeko.afpa.model;

public class PersonneModel {
    //attribut de la classe personne
    private String nom;
    private String prenom;

    //constructeur de peronne avec  2 param nom et prenom
    public PersonneModel(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    //Getters et Setters pour acceder au attributs private
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
