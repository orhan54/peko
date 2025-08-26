package pekopeko.afpa.model;

import pekopeko.afpa.exception.SaisieException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static pekopeko.afpa.Utility.RegexUtility.regexAlpha;

public class Livre {
    //attributs du Livre
    private String isbn , titreLivre, auteurLivre;
    private int quantiteLivre;

    //List des livres enregistrée
    private static List<Livre> livres = new ArrayList<Livre>();

    //constructeur du livre avec tout les parametres
    public Livre(String titreLivre, String auteurLivre, int quantiteLivre) throws SaisieException {
        this.setTitreLivre(titreLivre);
        this.setAuteurLivre(auteurLivre);
        this.setQuantiteLivre(quantiteLivre);
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

    private static int stockLivres() {
        if(livres.isEmpty()){
            System.out.println("Error le livre est pas en stock : ");
        } else if (livres.size()>1) {
            System.out.println("Le livre est en stock : ");
        }
        return livres.size();
    }

    // Getters et Setters
    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) throws SaisieException {
        if (isbn.length()!=10) {
            System.out.println("Error ISBN du livre : ");
        }else if (isbn.length()==10) {
            this.isbn = isbn;
        }
    }

    public String getTitreLivre() {
        return this.titreLivre;
    }

    public void setTitreLivre(String titreLivre) throws SaisieException {
        if (titreLivre ==null || !regexAlpha(titreLivre)) {
            throw  new SaisieException("Error sur le titre du livre : ");
        }else{
            this.titreLivre = titreLivre;
        }
    }

    public String getAuteurLivre() {
        return this.auteurLivre;
    }

    public void setAuteurLivre(String auteurLivre) throws SaisieException {
        if(auteurLivre.isEmpty() && !regexAlpha(auteurLivre)){
            //System.out.println("Error Auteur du livre : ");
            throw new SaisieException("Error Auteur du livre : ");
        }else{
            this.auteurLivre = auteurLivre;
        }
    }

    public int getQuantiteLivre() {
        return this.quantiteLivre;
    }

    public void setQuantiteLivre(int quantiteLivre) throws SaisieException {
        if(quantiteLivre<10 || quantiteLivre>50){
            throw new SaisieException("Error Quantite du livre : ");
        }else{
            this.quantiteLivre = quantiteLivre;
        }
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
