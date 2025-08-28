package pekopeko.afpa.view.swingUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUI extends JFrame{
    private JPanel contentPane;
    private JPanel title;
    private JPanel mainContent;
    private JPanel footerContent;
    private JButton addClient;
    private JButton addLivre;
    private JButton listePret;
    private JButton afficherClient;
    private JButton afficherLivre;
    private JButton afficherPret;
    private JButton afficherStaff;
    private JButton addClientStaffButton;

    public MenuUI() {

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\User\\Pictures\\logo.jpg");
        Dimension dimension = new Dimension(600, 800);

        //les attributs
        this.setTitle("Bibliothèque");
        this.setIconImage(imageIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(dimension);
        this.setResizable(false);
        this.setContentPane(contentPane);
        this.setLocationRelativeTo(null);
        this.pack();


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
        listePret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPret();
            }
        });
        afficherClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayClient();
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
    }

    private void displayClientStaff() {
        ChooseCientStaff chooseCientStaff = new ChooseCientStaff();
        chooseCientStaff.setVisible(true);
    }

    private void addLivre() {

    }

    private void addPret() {

    }

    private void displayClient() {

    }

    private void displayLivre() {

    }

    private void displayPret() {

    }

    private void displayStaff() {

    }


}
