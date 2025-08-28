package pekopeko.afpa.view.swingUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClient extends JFrame {

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton validerButton;
    private JButton annulerButton;
    private JPanel contentPane;
    private JPanel titleAddClient;
    private JPanel mainAddClient;
    private JPanel footerAddClient;


    public AddClient() {

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

        validerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validerClient();
            }
        });
        annulerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retour();
            }
        });
    }

    private void validerClient() {
    }

    private void retour() {
        this.dispose();
    }
}
