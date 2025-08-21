package pekopeko.afpa.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Pret {
    //attribut pour le pret
    private LocalDateTime datePret;
    private String titreLivrePret, nomLivrePret;

    //List des pret des livres
    private static List<Pret> prets = new ArrayList<Pret>();

    //constructeur pour le pret de livre
    public Pret(String titreLivrePret, String nomLivrePret, LocalDateTime datePret) {
        this.titreLivrePret = titreLivrePret;
        this.nomLivrePret = nomLivrePret;
        this.datePret = LocalDateTime.now();
    }

    //afficher les prets
    public static List<Pret> getPrets() {
        return prets;
    }

    //Getters et Setters
    public LocalDateTime getDatePret() {
        return this.datePret;
    }

    public String getDatePretFormatee() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy 'à' HH:mm");
        return datePret.format(formatter);
    }

    public String getTitreLivrePret() {
        return this.titreLivrePret;
    }

    public void setTitreLivrePret(String titreLivrePret) {
        this.titreLivrePret = titreLivrePret;
    }

    public String getNomLivrePret() {
        return this.nomLivrePret;
    }

    public void setNomLivrePret(String nomLivrePret) {
        this.nomLivrePret = nomLivrePret;
    }

}
