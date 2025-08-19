package pekopeko.afpa.model;

import java.util.ArrayList;
import java.util.List;

public class Staff extends Personne {
    //attribut du Staff
    private int  id;

    private static List<Staff> staffs = new ArrayList<Staff>();

    //contructeur pour le Staff qui extends de Personne
    public Staff(String nom, String prenom, int id) {
        super(nom, prenom);
        this.id = id;
    }

    public static List<Staff> getStaffs() {
        return staffs;
    }

    //Setters et Getters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
