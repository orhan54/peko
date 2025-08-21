package pekopeko.afpa.model;

public class Personne {
    //attribut de la classe personne
    private String nom, prenom;

    //constructeur de peronne avec  2 param nom et prenom
    public Personne(String nom, String prenom) {
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

    @Override
    public String toString() {
        StringBuilder personne = new StringBuilder();
        personne.append("Nom : ");
        personne.append(this.nom).append("\n");
        personne.append("Prenom :");
        personne.append(this.prenom).append("\n");

        return personne.toString();
    }
}
