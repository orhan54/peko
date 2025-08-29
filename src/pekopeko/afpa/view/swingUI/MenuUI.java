package pekopeko.afpa.view.swingUI;

import pekopeko.afpa.exception.SaisieException;
import pekopeko.afpa.model.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class MenuUI extends JFrame{
    private JPanel contentPane;
    private JPanel logoMenu;
    private JPanel mainContent;
    private JPanel footerContent;
    private JButton addClient;
    private JButton addLivre;
    private JButton addPret;
    private JButton afficherClient;
    private JButton afficherLivre;
    private JButton afficherPret;
    private JButton afficherStaff;
    private JButton addClientStaffButton;
    private JButton quitterButton;
    private String nom;
    private String prenom;
    private String email;

    public MenuUI() {

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\User\\Pictures\\logo.jpg");
        Dimension dimension = new Dimension(1200, 1000);

        //les attributs
        this.setTitle("Bibliothèque");
        this.setIconImage(imageIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(dimension);
        this.setResizable(false);
        this.setContentPane(contentPane);

        this.pack();
        this.setLocationRelativeTo(null);

        addClientStaffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayClientStaff();
            }
        });
        addLivre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addLivre();
            }
        });
        addPret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPret();
            }
        });
        afficherClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    displayClient();
                } catch (SaisieException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        afficherLivre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayLivre();
            }
        });
        afficherPret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPret();
            }
        });
        afficherStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayStaff();
            }
        });
        quitterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitter();
            }
        });
    }

    private void displayClientStaff() {
        ChooseCientStaff chooseCientStaff = new ChooseCientStaff();
        chooseCientStaff.setVisible(true);
    }

    private void addLivre() {
        AddLivre addLivre = new AddLivre();
        addLivre.setVisible(true);
    }

    private void addPret() {
        AddPret addPret = new AddPret();
        addPret.setVisible(true);
    }

    private void displayClient() throws SaisieException {
        ListClient myListClient = new ListClient();
        myListClient.setVisible(true);
    }

    private void displayLivre() {
        ListLivre listLivre = new ListLivre();
        listLivre.setVisible(true);
    }

    private void displayPret() {
        ListPret myList = new ListPret();
        myList.setVisible(true);
    }

    private void displayStaff() {
        ListStaff listStaff = new ListStaff();
        listStaff.setVisible(true);
    }

    private void quitter() {
        int reponse = JOptionPane.showConfirmDialog(MenuUI.this, "Voulez-vous quitter l'application ?", "Quitter", JOptionPane.YES_NO_OPTION);
        if (reponse == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }



}
