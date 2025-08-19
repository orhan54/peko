package pekopeko.afpa.model;

import java.util.ArrayList;
import java.util.List;

public class StaffModel extends PersonneModel{
    //attribut du Staff
    private int  id;

    private static List<StaffModel> staffs = new ArrayList<StaffModel>();

    //contructeur pour le Staff qui extends de Personne
    public StaffModel(String nom, String prenom, int id) {
        super(nom, prenom);
        this.id = id;
    }

    public static List<StaffModel> getStaffs() {
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
