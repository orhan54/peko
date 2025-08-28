package pekopeko.afpa.view.swingUI;

import pekopeko.afpa.exception.SaisieException;
import pekopeko.afpa.model.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class AddClient extends JFrame {

    private JTextField textFieldNom;
    private JTextField textFieldPrenom;
    private JTextField textFieldEmail;
    private JButton validerButton;
    private JButton annulerButton;
    private JPanel contentPane;
    private JPanel titleAddClient;
    private JPanel mainAddClient;
    private JPanel footerAddClient;


    public AddClient() {

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
                    validerClient();
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

    private void validerClient() throws SaisieException {
        String nomClient = textFieldNom.getText().trim().toUpperCase();
        String prenomClient = textFieldPrenom.getText().trim().toUpperCase();
        String emailClient = textFieldEmail.getText().trim().toUpperCase();

        if (nomClient.isEmpty() || prenomClient.isEmpty() || emailClient.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tout les champs sont obligatories!",
                    "Erreur", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if(!nomClient.matches("^[A-Za-z]+$") || !prenomClient.matches("^[A-Za-z]+$")) {
            JOptionPane.showMessageDialog(this, "Nom et prénom ne doivent contenir que des lettres.",
                    "Erreur", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (emailClient.isEmpty() ||
                !emailClient.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            JOptionPane.showMessageDialog(this, "Votre email n'est pas valide.",
                    "Erreur", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Client client = new Client(nomClient, prenomClient, emailClient, LocalDateTime.now());
        Client.getClients().add(client);

        JOptionPane.showMessageDialog(this, "Client ajouté : " + client.getNom() + " " + client.getPrenom(),
                "Succès",
                JOptionPane.INFORMATION_MESSAGE);

        // Reset des champs
        textFieldNom.setText("");
        textFieldPrenom.setText("");
        textFieldEmail.setText("");
    }

    private void retour() {
        this.dispose();
    }
}
