package pekopeko.afpa.view.swingUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListClient extends JFrame {
    private JPanel contentPane;
    private JPanel logoListClient;
    private JScrollBar scrollBar1;
    private JButton ajouterButton;
    private JButton modifierButton;
    private JButton supprimerButton;
    private JButton retourButton;
    private JButton modifierButton1;
    private JButton annulerButton;
    private JButton supprimerButton1;
    private JList listClient;

    public ListClient() {

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

        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addClientUI();
            }
        });
        modifierButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateClientUI();
            }
        });
        supprimerButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteClientUI();
            }
        });
        annulerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retour();
            }
        });
    }

    private void addClientUI() {
    }

    private void updateClientUI() {
    }

    private void deleteClientUI() {
    }

    private void retour() {
        this.dispose();
    }

}
