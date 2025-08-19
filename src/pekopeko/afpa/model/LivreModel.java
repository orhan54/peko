package pekopeko.afpa.model;

import java.util.ArrayList;
import java.util.List;

public class LivreModel {
    //attributs du Livre
    private int idIsbn;
    private String titreLivre;
    private String auteurLivre;
    private int quantiteLivre;

    //List des livres enregistrée
    private static List<LivreModel> livres = new ArrayList<LivreModel>();

    //constructeur du livre avec tout les parametres
    public LivreModel(String titreLivre, String auteurLivre, int quantiteLivre, int idIsbn) {
        this.titreLivre = titreLivre;
        this.auteurLivre = auteurLivre;
        this.quantiteLivre = quantiteLivre;
        this.idIsbn = idIsbn;
    }

    //affichage des livres enregistrée
    public static List<LivreModel> getLivres() {
        return livres;
    }

    // Getters et Setters
    public int getIdIsbn() {
        return this.idIsbn;
    }

    public void setIdIsbn(int idIsbn) {
        this.idIsbn = idIsbn;
    }

    public String getTitreLivre() {
        return this.titreLivre;
    }

    public void setTitreLivre(String titreLivre) {
        this.titreLivre = titreLivre;
    }

    public String getAuteurLivre() {
        return this.auteurLivre;
    }

    public void setAuteurLivre(String auteurLivre) {
        this.auteurLivre = auteurLivre;
    }

    public int getQuantiteLivre() {
        return this.quantiteLivre;
    }

    public void setQuantiteLivre(int quantiteLivre) {
        this.quantiteLivre = quantiteLivre;
    }
}
