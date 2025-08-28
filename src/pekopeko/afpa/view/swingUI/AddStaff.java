package pekopeko.afpa.view.swingUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStaff extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JButton validerButton;
    private JButton annulerButton;
    private JPanel contentPane;
    private JPanel titleAddStaff;
    private JPanel mainAddStaff;
    private JPanel footerAddStaff;

    public AddStaff() {

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
                validerStaff();
            }
        });
        annulerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retour();
            }
        });

    }

    private void validerStaff() {

    }

    private void retour() {
        this.dispose();
    }

}
