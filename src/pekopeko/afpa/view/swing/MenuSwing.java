package pekopeko.afpa.view.swing;

import javax.swing.*;
import java.awt.*;

public class MenuSwing extends JFrame {

    private JPanel contentPane;
    private JLabel lblTitle;
    private JButton btnAbonne;
    private JButton btnLivre;
    private JButton btnpret;
    private JButton btnDisplayAbonne;
    private JButton btnDisplayLivre;
    private JButton btnDisplayPret;
    private JButton btnDisplayStaff;
    private JButton btnQuitter;


    /**
     * Constructeur de la frame
     */
    public MenuSwing() {

        Dimension dimension = new Dimension(600, 800); // dimension de la fenetre

        //ajout du titre
        this.setTitle("Bibliotheque");

        //action fermeture de la fenetre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //ajout du contentPane à la fenêtre
        this.setContentPane(contentPane);

        //redimension interdit
        this.setSize(dimension);

        this.setLocationRelativeTo(null);

        this.pack();
        this.setVisible(true);









    }

}
