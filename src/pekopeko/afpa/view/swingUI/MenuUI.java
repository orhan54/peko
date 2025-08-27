package pekopeko.afpa.view.swingUI;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
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

    public MenuUI() {

        //les attributs
        this.setTitle("Bibliothèque");
        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(contentPane);
        this.pack();


        addClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        addLivre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        listePret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        afficherClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        afficherLivre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        afficherPret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        afficherStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static class MainUI {
        public static void main(String[] args) throws Exception {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            MenuUI myMenu = new MenuUI();
            myMenu.setVisible(true);
        }
    }
}
