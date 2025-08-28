package pekopeko.afpa.view.swingUI;

import pekopeko.afpa.exception.SaisieException;
import pekopeko.afpa.model.Personne;
import pekopeko.afpa.model.Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class AddStaff extends JFrame{
    private JTextField textFieldNomStaff;
    private JTextField textFieldPrenomStaff;
    private JButton validerButton;
    private JButton annulerButton;
    private JPanel contentPane;
    private JPanel logoAddStaff;
    private JPanel mainAddStaff;
    private JPanel footerAddStaff;

    public AddStaff() throws SaisieException {

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
                    validerStaff();
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

    private void validerStaff() throws SaisieException {
        String nomStaff = textFieldNomStaff.getText().trim().toUpperCase();
        String prenomStaff = textFieldPrenomStaff.getText().trim().toUpperCase();

        if (nomStaff.isEmpty() || prenomStaff.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nom et prénom sont obligatoires.",
                    "Erreur", JOptionPane.ERROR_MESSAGE);
            return; // on arrête l’exécution
        }

        if (!nomStaff.matches("^[A-Za-z]+$") || !prenomStaff.matches("^[A-Za-z]+$")) {
            JOptionPane.showMessageDialog(this, "Nom et prénom ne doivent contenir que des lettres.",
                    "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Ici je peux créer l’objet Staff
        Staff staff = new Staff(nomStaff, prenomStaff, Staff.getID);
        Staff.getStaffs().add(staff);

        JOptionPane.showMessageDialog(this,
                "Staff ajouté : " + staff.getNom() + " " + staff.getPrenom(),
                "Succès",
                JOptionPane.INFORMATION_MESSAGE);

        // Reset des champs
        textFieldNomStaff.setText("");
        textFieldPrenomStaff.setText("");
    }

    private void retour() {
        this.setVisible(false);
    }

}
