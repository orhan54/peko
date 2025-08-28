package pekopeko.afpa.view.swingUI;

import pekopeko.afpa.exception.SaisieException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseCientStaff extends JFrame {
    private JButton chooseAddClientButton;
    private JButton addStaffButton;
    private JButton addClientButton;
    private JButton retourButton;
    private JPanel contentPane;
    private JPanel logoChoose;
    private JPanel titleChooseClientStaff;
    private JPanel chooseButon;
    private JPanel backContent;
    private JPanel footerChoose;
    private JButton chooseAddStaffButton;

    public ChooseCientStaff() {

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

        addClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addClient();
            }
        });
        addStaffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addStaff();
                } catch (SaisieException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retourButton();
            }
        });
    }

    private void addClient() {
        AddClient ajoutClient = new AddClient();
        ajoutClient.setVisible(true);
    }

    private void addStaff() throws SaisieException {
        AddStaff ajoutStaff = new AddStaff();
        ajoutStaff.setVisible(true);
    }

    private void retourButton() {
        this.dispose();
    }

}
