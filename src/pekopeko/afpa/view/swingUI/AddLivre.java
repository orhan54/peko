package pekopeko.afpa.view.swingUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddLivre extends JFrame {
    private JPanel contentPane;
    private JTextField textFieldTitreLivre;
    private JTextField textFieldAuteurLivre;
    private JTextField textField3;
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
                enregistrerLivre();
            }
        });
        annulerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retour();
            }
        });
    }

    private void enregistrerLivre() {
    }

    private void retour() {
        this.dispose();
    }


}
