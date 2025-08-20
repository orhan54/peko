package pekopeko.afpa.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static pekopeko.afpa.Utility.RegexUtility.*;
import static pekopeko.afpa.model.Client.sc;
import static pekopeko.afpa.view.viewBibliotheque.menu;

public class Livre {
    //attributs du Livre
    private String isbn;
    private String titreLivre;
    private String auteurLivre;
    private int quantiteLivre;

    //List des livres enregistrée
    private static List<Livre> livres = new ArrayList<Livre>();

    //constructeur du livre avec tout les parametres
    public Livre(String titreLivre, String auteurLivre, int quantiteLivre) {
        this.titreLivre = titreLivre;
        this.auteurLivre = auteurLivre;
        this.quantiteLivre = quantiteLivre;
        this.isbn = generateRandomISBN10();
    }

    //affichage des livres enregistrée
    public static List<Livre> getLivres() {
        return livres;
    }

    private static String generateRandomISBN10() {
        Random random = new Random();
        StringBuilder isbn = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            isbn.append(random.nextInt(10)); // Ajoute un chiffre entre 0 et 9
        }
        if(isbn.length()!=10){
            System.out.println("Error ISBN du livre : ");
        }
        return isbn.toString();
    }

    // Getters et Setters
    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    @Override
    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append(titreLivre);
//        builder.append(auteurLivre);
//        builder.append(quantiteLivre);
//        builder.append(" ");
//        builder.append(isbn);
//        builder.append(" ");

        //System.out.println("Titre du livre : " + this.titreLivre);
        //System.out.println("Auteur du livre : " + this.auteurLivre);
        //System.out.println("Quantite du livre : " + this.quantiteLivre);
        //System.out.println("Isbn du livre : " + this.isbn);

        //return livres.toString();

        return this.getIsbn() + " - " + this.getTitreLivre();
    }
}
