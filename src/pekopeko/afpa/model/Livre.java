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
    private static String isbn;
    private static String titreLivre;
    private static String auteurLivre;
    private static int quantiteLivre;

    //List des livres enregistrée
    private static List<Livre> livres = new ArrayList<Livre>();

    //constructeur du livre avec tout les parametres
    public Livre(String titreLivre, String auteurLivre, int quantiteLivre, String isbn) {
        this.titreLivre = titreLivre;
        this.auteurLivre = auteurLivre;
        this.quantiteLivre = quantiteLivre;
        this.isbn = generateRandomISBN10();
    }

    //affichage des livres enregistrée
    public static List<Livre> getLivres() {
        return livres;
    }

    public static void createLivre() {
        System.out.println("Saisir le titre du livre : ");
        Scanner sc = new Scanner(System.in);

        do{
            System.out.print("Nom du livre : ");
            titreLivre = sc.nextLine().toUpperCase();
            if(titreLivre.length()<1 || titreLivre == null){
                System.out.println("Error sur le nom du livre : ");
            }
        }while(titreLivre.length()<1 || titreLivre == null);

        do{
            System.out.print("Auteur du livre : ");
            auteurLivre = sc.nextLine().toUpperCase();
            if(auteurLivre.length()<1 || !regexAlpha(auteurLivre) || auteurLivre == null){
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



        Livre livre = new Livre(titreLivre, auteurLivre, quantiteLivre, isbn);
        livres.add(livre);

        System.out.println("");
        System.out.println("[ Le nouveau livre est bien enregistrer : ]");
        System.out.println("Nom du livre : "+livre.getTitreLivre());
        System.out.println("Auteur du livre : "+livre.getAuteurLivre());
        System.out.println("Quantite du livre commander : "+livre.getQuantiteLivre());
        System.out.println("Voici la reference ISBN : " + livre.getIsbn());

        System.out.println("");
        System.out.println("Saisir [0] pour revenir au menu");
        int retour = sc.nextInt();
        if(retour==0){
            menu();
        }
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

    public static void afficherLivre() {
        try {
            System.out.println("Voici la liste des livres : ");
            if(livres.isEmpty()){
                System.out.println("La liste des livres est vide : ");
                System.out.println(" ");
            }
            for(Livre livre : livres){
                System.out.println("");
                System.out.println("- Titre du livre : " +livre.getTitreLivre());
                System.out.println("- Auteur du livre : " + livre.getAuteurLivre());
                System.out.println("- Quantité du livre : " + livre.getQuantiteLivre());
                System.out.println("- ISBN du livre : " + livre.getIsbn());
            }
        }catch (Exception e){
            System.out.println("Erreur : Le nom du livre : " + e.getMessage());
        }
        System.out.println(" ");
        System.out.println("Saisir [0] pour revenir au menu : ");
        int revenir = sc.nextInt();
        if (revenir == 0) {
            menu();
        }
    }

    // Getters et Setters
    public String getIsbn() {
        return this.isbn;
    }

    public static void setIsbn(String isbn) {
        Livre.isbn = isbn;
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

//    @Override
//    public String toString() {
//        System.out.println("Titre du livre : " + this.titreLivre);
//        System.out.println("Auteur du livre : " + this.auteurLivre);
//        System.out.println("Quantite du livre : " + this.quantiteLivre);
//        System.out.println("Isbn du livre : " + this.isbn);
//
//        return toString();
//    }
}
