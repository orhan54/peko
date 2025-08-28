package pekopeko.afpa.view.swingUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPret extends JFrame {
    private JPanel contentPane;
    private JPanel logoPret;
    private JPanel mainPret;
    private JPanel footerPret;
    private JTextField textField1;
    private JTextField textField2;
    private JButton validerButton;
    private JButton annulerButton;

    public AddPret() {

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
                validerPret();
            }
        });
        annulerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retour();
            }
        });
    }

    private void validerPret() {

    }

    private void retour() {
        this.dispose();
    }

}
