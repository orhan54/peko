package pekopeko.afpa.view.swingUI;

import pekopeko.afpa.exception.SaisieException;
import pekopeko.afpa.model.Livre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddLivre extends JFrame {
    private JPanel contentPane;
    private JTextField textFieldTitreLivre;
    private JTextField textFieldAuteurLivre;
    private JTextField textFieldQuantiteLivre;
    private JButton validerButton;
    private JButton annulerButton;
    private JPanel logoAddLivre;
    private JPanel mainAddLivre;
    private JPanel footerAddLivre;

    public AddLivre() {

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\User\\Pictures\\logo.jpg");
        Dimension dimension = new Dimension(1200, 1000);

        //les attributs
        this.setTitle("Bibliothèque");
        this.setIconImage(imageIcon.getImage());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(dimension);
        this.setResizable(false);
        this.setContentPane(contentPane);

        this.pack();
        this.setLocationRelativeTo(null);
        
        validerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    enregistrerLivre();
                } catch (SaisieException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        annulerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retour();
            }
        });
    }

    private void enregistrerLivre() throws SaisieException {
        String titreLivre = textFieldTitreLivre.getText().trim().toUpperCase();
        String auteurLivre = textFieldAuteurLivre.getText().trim().toUpperCase();
        int quantiteLivre;

        try {
            quantiteLivre = Integer.parseInt(textFieldQuantiteLivre.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "La quantité doit être un nombre entier.",
                    "Erreur", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (titreLivre.isEmpty() && auteurLivre.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Le titre et l'auteur ne peuvent pas être vides.",
                    "Erreur", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!titreLivre.matches("^[\\p{L}'-]+(?:\\s[\\p{L}'-]+)*$")) {
            JOptionPane.showMessageDialog(this,
                    "Le titre du livre n'est pas valide.",
                    "Erreur", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!auteurLivre.matches("^[\\p{L}'-]+(?:\\s[\\p{L}'-]+)*$")) {
            JOptionPane.showMessageDialog(this,
                    "Le nom de l'auteur n'est pas valide.",
                    "Erreur", JOptionPane.WARNING_MESSAGE);
            return;
        }


        if (quantiteLivre < 10 || quantiteLivre > 50) {
            JOptionPane.showMessageDialog(this,
                    "La quantité du livre doit être comprise entre 10 et 50.",
                    "Erreur", JOptionPane.WARNING_MESSAGE);
            return;
        }


        Livre livre = new Livre(titreLivre, auteurLivre, quantiteLivre);
        Livre.getLivres().add(livre);

        JOptionPane.showMessageDialog(this,
                "Le livre : " + titreLivre + " de l'auteur " + auteurLivre + " a été ajouté avec succès !",
                "Succès", JOptionPane.INFORMATION_MESSAGE);

        // Reset des champs
        textFieldTitreLivre.setText("");
        textFieldAuteurLivre.setText("");
        textFieldQuantiteLivre.setText("");

    }

    private void retour() {
        this.dispose();
    }


}
