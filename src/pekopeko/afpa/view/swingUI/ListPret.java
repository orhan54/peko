package pekopeko.afpa.view.swingUI;

import pekopeko.afpa.exception.SaisieException;
import pekopeko.afpa.model.Livre;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListPret extends JFrame {
    private JPanel contentPane;
    private JPanel logoListPret;
    private JPanel mainListPret;
    private JPanel FooterList;
    private JButton ajouterButton;
    private JButton modifierButton;
    private JButton supprimerButton;
    private JButton retourButton;
    private JPanel listName;
    private JTable table1;                 // JTable
    private JScrollPane JTableListPret;    // ScrollPane qui contient la table

    private DefaultTableModel tableModel;  // modèle pour le tableau

    public ListPret() {
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\User\\Pictures\\logo.jpg");
        Dimension dimension = new Dimension(1200, 1000);

        // attributs fenêtre
        this.setTitle("Bibliothèque");
        this.setIconImage(imageIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(dimension);
        this.setResizable(false);
        this.setContentPane(contentPane);

        // Création du modèle de tableau
        String[] colonnes = {"N°", "Titre", "Auteur", "Quantité", "ISBN"};
        tableModel = new DefaultTableModel(colonnes, 0);
        table1.setModel(tableModel);

        // affichage des prêts de livres
        afficherLivres();

        this.pack();
        this.setLocationRelativeTo(null);

        // Boutons
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

    /**
     * Remplit le tableau avec les livres en prêt
     */
    private void afficherLivres() {
        tableModel.setRowCount(0); // vider le tableau avant de recharger

        if (Livre.getLivres().isEmpty()) {
            tableModel.addRow(new Object[]{"-", "Aucun livre", "", "", ""});
        } else {
            int i = 1;
            for (Livre livre : Livre.getLivres()) {
                tableModel.addRow(new Object[]{
                        i++,
                        livre.getTitreLivre().toUpperCase(),
                        livre.getAuteurLivre().toUpperCase(),
                        livre.getQuantiteLivre(),
                        livre.getIsbn()
                });
            }
        }
    }

    private void addList() {
        AddLivre addLivre = new AddLivre();
        addLivre.setVisible(true);
    }

    private void updateList() throws SaisieException {
        int selectedRow = table1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un livre à modifier !");
            return;
        }

        int reponse = JOptionPane.showConfirmDialog(
                this,
                "Voulez-vous modifier le livre ?",
                "Modification du livre",
                JOptionPane.YES_NO_OPTION
        );

        if (reponse == JOptionPane.YES_OPTION) {
            String newTitre = JOptionPane.showInputDialog("Saisir le nouveau titre : ");
            String newAuteur = JOptionPane.showInputDialog("Saisir l'auteur : ");
            int newQuantite = Integer.parseInt(JOptionPane.showInputDialog("Saisir la quantité : "));

            Livre livre = Livre.getLivres().get(selectedRow);
            livre.setTitreLivre(newTitre);
            livre.setAuteurLivre(newAuteur);
            livre.setQuantiteLivre(newQuantite);

            JOptionPane.showMessageDialog(this, "Livre modifié !");
            afficherLivres(); // recharger le tableau
        }
    }

    private void deleteList() {
        int selectedRow = table1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un livre à supprimer !");
            return;
        }

        Livre.getLivres().remove(selectedRow);
        afficherLivres();
        JOptionPane.showMessageDialog(this, "Livre supprimé !");
    }

    private void retour() {
        this.dispose();
    }
}
