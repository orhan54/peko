package pekopeko.afpa.view.swing;

import pekopeko.afpa.exception.SaisieException;
import pekopeko.afpa.model.Client;
import pekopeko.afpa.model.Livre;
import pekopeko.afpa.model.Pret;
import pekopeko.afpa.model.Staff;
import pekopeko.afpa.view.swingUI.MenuUI;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.time.LocalDateTime;

public class MainSwingUI {
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        MenuUI myMenu = new MenuUI();
        myMenu.setVisible(true);
        initialisationUI();
    }

    public static void initialisationUI() {
        try {
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
            Staff s1 = new Staff("Jean", "Neymar", 1);
            Staff.getStaffs().add(s1);
            Staff s2 = new Staff("Jean", "Peuplus", 2);
            Staff.getStaffs().add(s2);
        } catch (SaisieException e) {
            System.out.println("Erreur au lancement de l'initialisation " + e.getMessage());
        }
    }
}