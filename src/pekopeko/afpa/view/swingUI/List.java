package pekopeko.afpa.view.swingUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class List extends JFrame {
    private JPanel contentPane;
    private JPanel logoList;
    private JPanel mainList;
    private JPanel FooterList;
    private JList list1;
    private JButton ajouterButton;
    private JButton modifierButton;
    private JButton supprimerButton;
    private JButton retourButton;
    private JScrollBar scrollBar1;
    private JPanel listName;

    public List() {

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\User\\Pictures\\logo.jpg");
        Dimension dimension = new Dimension(1200, 1000);

        //les attributs
        this.setTitle("Bibliothèque");
        this.setIconImage(imageIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(dimension);
        this.setResizable(false);
        this.setContentPane(contentPane);

        this.pack();
        this.setLocationRelativeTo(null);

        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addList();
            }
        });
        modifierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateList();
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

    private void addList() {

    }
    private void updateList() {

    }
    private void deleteList() {

    }
    private void retour() {
        this.dispose();
    }
}
