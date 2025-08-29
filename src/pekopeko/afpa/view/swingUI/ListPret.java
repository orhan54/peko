package pekopeko.afpa.view.swingUI;

import pekopeko.afpa.exception.SaisieException;
import pekopeko.afpa.model.Livre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListPret extends JFrame {
    private JPanel contentPane;
    private JPanel logoListPret;
    private JPanel mainListPret;
    private JPanel FooterList;
    private JList listPret;
    private JButton ajouterButton;
    private JButton modifierButton;
    private JButton supprimerButton;
    private JButton retourButton;
    private JScrollBar scrollBar1;
    private JPanel listName;

    public ListPret() {

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

        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addList();
            }
        });
        modifierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    updateList();
                } catch (SaisieException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteList();
            }
        });
        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retour();
            }
        });
    }

    private void addList() {
        AddLivre addLivre = new AddLivre();
        addLivre.setVisible(true);
    }
    private void updateList() throws SaisieException {
        int reponse = JOptionPane.showConfirmDialog(ListPret.this, "Voulez-vous modifier le livre ?", "Modification du livre", JOptionPane.YES_NO_OPTION);

        if (reponse == JOptionPane.YES_OPTION) {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            String newTitre = JOptionPane.showInputDialog("Saisir le nouveau titre : ", JFrame.EXIT_ON_CLOSE);
            String newAuteur = JOptionPane.showInputDialog("Saisir l'auteur : ", JFrame.EXIT_ON_CLOSE);
            int newQuantite = Integer.parseInt(JOptionPane.showInputDialog("Saisir la quantité : ", JFrame.EXIT_ON_CLOSE));

            Livre livre = new Livre(newTitre, newAuteur, newQuantite);
            livre.setTitreLivre(newTitre);
            livre.setAuteurLivre(newAuteur);
            livre.setQuantiteLivre(newQuantite);

            JOptionPane.showMessageDialog(this, "Votre livre est bien modifier", newTitre, JOptionPane.INFORMATION_MESSAGE);
        }else if (reponse == JOptionPane.CANCEL_OPTION) {
            this.dispose();
        }
    }
    private void deleteList() {

    }
    private void retour() {
        this.dispose();
    }
}
