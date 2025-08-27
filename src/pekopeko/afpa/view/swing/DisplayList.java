package pekopeko.afpa.view.swing;

import pekopeko.afpa.model.Client;
import pekopeko.afpa.model.Livre;
import pekopeko.afpa.model.Pret;
import pekopeko.afpa.model.Staff;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DisplayList extends JFrame {

    // static
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private JPanel contentPane;
    private JTable table;
    private JButton backButton;
    private JLabel affichage;
    private JPanel panelTable = new JPanel();
    private JScrollPane scrollPaneTable;

    private final String[] HEADER_CLIENT = new String[] {"nom", "prenom", "email", "dateInscription"};
    private final String[] HEADER_LIVRE = new String[] {"titreLivre", "auteurLivre", "quantiteLivre"};
    private final String[] HEADER_PRET = new String[] {"titreLivrePret", "nomLivrePret", "datePret"};
    private final String[] HEADER_STAFF = new String[] {"nom", "prenom", "id"};


    public DisplayList(int type) {

        Dimension dimension = new Dimension(700, 800);

        this.setTitle("Affichage des listes");
        this.setLocationRelativeTo(null);
        this.setPreferredSize(dimension);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(contentPane);
        this.setResizable(false);
        this.pack();

        switch (type) {
            case 0:
                affichage.setText("Affichage des clients");
                constructDataTable(Client.getClients(), HEADER_CLIENT);
                break;
            case 1:
                affichage.setText("Affichage des livres");
                constructDataTable(Livre.getLivres(), HEADER_LIVRE);
                break;
            case 2:
                affichage.setText("Affichage des prets");
                constructDataTable(Pret.getPrets(), HEADER_PRET);
                break;
            case 3:
                affichage.setText("Affichage des staffs");
                constructDataTable(Staff.getStaffs(), HEADER_STAFF);
                break;
        }

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }

            public void actionPerformed(Action e) {
                cancel();
            }
        });

    }

    private <T> void constructTable(List<T> dataList, String[] headers) {
        TableModel model = new DefaultTableModel(headers, dataList.size());
        this.table.setModel(model);
        this.table.revalidate();
        this.table.repaint();
    }

    private void cancel() {
        this.dispose();
    }

    private <T> void constructDataTable(List<T> dataList, String[] headers) {

        //creation du tableau de données
        String[][] data= new String[dataList.size()][headers.length];

        //remplissage du tableau
        for (int i = 0; i < dataList.size(); i++) {
            Object obj = dataList.get(i);
            if (obj instanceof Client) {
                Client client = (Client) obj;
                data[i][0] = client.getNom();
                data[i][1] = client.getPrenom();
                data[i][2] = client.getEmail();
                data[i][3] = formatter.format(client.getDateInscription());
            }else if (obj instanceof Livre) {
                Livre livre = (Livre) obj;
                data[i][0] = livre.getTitreLivre();
                data[i][1] = livre.getAuteurLivre();
                data[i][2] = String.valueOf(livre.getQuantiteLivre());
            }else if (obj instanceof Pret) {
                Pret pret = (Pret) obj;
                data[i][0] = pret.getTitreLivrePret();
                data[i][0] = pret.getNomLivrePret();
                data[i][0] = pret.getDatePretFormatee();
            }else if (obj instanceof Staff) {
                Staff staff = (Staff) obj;
                data[i][0] = staff.getNom();
                data[i][1] = staff.getPrenom();
                data[i][2] = String.valueOf(staff.getId());
            }
        }


        //initialisation de la table
        table = new JTable(data, HEADER_CLIENT);
        //ajout de la table dans le scrollpane
        scrollPaneTable.setViewportView(table);
        //on redefinie le panelTable avec les modifications
        panelTable.revalidate();
        panelTable.repaint();



    }





}
