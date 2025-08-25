package pekopeko.afpa.model;

import pekopeko.afpa.exception.SaisieException;

import static pekopeko.afpa.Utility.RegexUtility.regexAlpha;

public class Personne {
    //attribut de la classe personne
    private String nom, prenom;

    //constructeur de peronne avec  2 param nom et prenom
    public Personne(String nom, String prenom) throws SaisieException {
        this.setNom(nom);
        this.setPrenom(prenom);
    }

    //Getters et Setters pour acceder au attributs private
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) throws SaisieException {
        if (nom == null && !regexAlpha(nom)){
            throw new SaisieException("Le nom n'est pas valide !");
        }else{
            this.nom = nom;
        }
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) throws SaisieException {
        if (nom == null && !regexAlpha(prenom)){
            throw new SaisieException("Le prenom n'est pas valide !");
        }else{
            this.prenom = prenom;
        }
    }

    @Override
    public String toString() {
        StringBuilder personne = new StringBuilder();
        personne.append("- Nom : ");
        personne.append(this.nom.toUpperCase()).append("\n");
        personne.append("- Prenom :");
        personne.append(this.prenom.toUpperCase()).append("\n");

        return personne.toString();
    }
}
