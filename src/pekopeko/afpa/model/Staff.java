package pekopeko.afpa.model;

import pekopeko.afpa.exception.SaisieException;

import java.util.ArrayList;
import java.util.List;

import static pekopeko.afpa.Utility.RegexUtility.PositifInt;

public class Staff extends Personne {
    public static int getID;
    //attribut du Staff
    private static int nextId = 0;
    private int id;

    private static List<Staff> staffs = new ArrayList<Staff>();

    //contructeur pour le Staff qui extends de Personne
    public Staff(String nom, String prenom, int id) throws SaisieException {
        super(nom, prenom);
        this.setId(id);
    }

    public static List<Staff> getStaffs() {
        return staffs;
    }

    //Setters et Getters
    public int getId() {
        return this.id;
    }

    public void setId(int id) throws SaisieException {
        if(!PositifInt(String.valueOf(id))){
            throw new SaisieException("Error sur id Staff");
        }else{
            this.id = nextId++;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "- ID staff : " +  id;
    }
}
