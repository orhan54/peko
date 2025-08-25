package pekopeko.afpa.model;

import pekopeko.afpa.exception.SaisieException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static pekopeko.afpa.Utility.RegexUtility.regexAlpha;

public class Pret {
    //attribut pour le pret
    private LocalDateTime datePret;
    private String titreLivrePret, nomLivrePret;

    //List des pret des livres
    private static List<Pret> prets = new ArrayList<Pret>();

    //constructeur pour le pret de livre
    public Pret(String titreLivrePret, String nomLivrePret, LocalDateTime datePret) throws SaisieException {
        this.setTitreLivrePret(titreLivrePret);
        this.setNomLivrePret(nomLivrePret);
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

    public void setTitreLivrePret(String titreLivrePret) throws SaisieException {
        if (titreLivrePret == null && !regexAlpha(titreLivrePret)) {
            throw new SaisieException("error le pret du titre du livre :");
        }else{
            this.titreLivrePret = titreLivrePret;
        }

    }

    public String getNomLivrePret() {
        return this.nomLivrePret;
    }

    public void setNomLivrePret(String nomLivrePret) throws SaisieException {
        if (nomLivrePret == null && !regexAlpha(nomLivrePret)) {
            throw new SaisieException("error le pret du nom livre :");
        }else{
            this.nomLivrePret = nomLivrePret;
        }
    }

}
