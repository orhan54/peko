package pekopeko.afpa.controller;


//TODO : creation nom projet pekopeko  => OK
//TODO : structure MVC  =>OK
//TODO : depot Git correspondant  => OK
//TODO : création diagrammes de classes des objets métiers  => OK
//TODO : création de use-case de l'abonné  => OK
//TODO : création de classe métiers nécessaires au projet
//TODO : mettre en place un CRUD et TESTER les CRUD
//TODO : mettre en place le codage defensif sur les objets métiers
//TODO : tester le codage défensif
//TODO : mettre en place les tests unitaires [sur une classe métiers au choix]
//TODO : mettre en place un menu proposant les fonctionnalités demandées
//TODO : développer les fonctionnalités tour a tour
//TODO : revue de code et amélioration
//TODO : Javadoc du projet

import pekopeko.afpa.exception.SaisieException;
import pekopeko.afpa.model.Client;
import pekopeko.afpa.model.Livre;
import pekopeko.afpa.model.Pret;
import pekopeko.afpa.view.swing.MenuSwing;

import java.time.LocalDateTime;
import static pekopeko.afpa.view.viewBibliotheque.menu;

public class Main {
    public static void main(String[] args) {
        try {
            MenuSwing myMenu = new MenuSwing();
            Main main = new Main();
            main.run();
        }catch (Exception e){
            System.out.println("Erreur au lancement du programme " + e.getMessage());
        }
    }

    public void run() {
        try {
            initialisation();
            menu();
        }catch (Exception e){
            System.out.println("Erreur au lancement de la vue accueil " + e.getMessage());
        }
    }

    public void initialisation() {
        try{
            Client c1 = new Client("Doe", "John", "johndoe@live.fr", LocalDateTime.now());
            Client.getClients().add(c1);
            Client c2 = new Client("Jean", "Louis", "jeanlouis@gmail.com", LocalDateTime.now());
            Client.getClients().add(c2);
            Livre l1 = new Livre("L'étranger", "Albert Camus", 20);
            Livre.getLivres().add(l1);
            Livre l2 = new Livre("Le bruit et la fureur", "William Faulkner", 30);
            Livre.getLivres().add(l2);
            Pret p1 = new Pret("L'étranger", "Doe", LocalDateTime.now());
            Pret.getPrets().add(p1);
            Pret p2 = new Pret("Le bruit et la fureur", "Louis", LocalDateTime.now());
            Pret.getPrets().add(p2);
//            Staff s1 = new Staff("Jean", "Neymar", 1);
//            Staff.getStaffs().add(s1);
//            Staff s2 = new Staff("Jean", "Peuplus", 2);
//            Staff.getStaffs().add(s2);
        }catch (SaisieException e){
            System.out.println("Erreur au lancement de l'initialisation " + e.getMessage());
        }

    }
}