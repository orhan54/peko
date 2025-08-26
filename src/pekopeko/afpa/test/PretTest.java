package pekopeko.afpa.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pekopeko.afpa.exception.SaisieException;
import pekopeko.afpa.model.Pret;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PretTest {

    Pret pret;

    @BeforeEach
    void setUp() throws SaisieException {
        pret = new Pret("L'étranger", "Albert Camus", LocalDateTime.now());
    }

    @AfterEach
    void tearDown() throws SaisieException {
        pret = null;
    }

    @Test
    public void testConstructeurPret() throws SaisieException {
        Pret p = new Pret("L'étranger", "Albert Camus", LocalDateTime.now());
        assertEquals("L'étranger", pret.getTitreLivrePret());
        assertEquals("Albert Camus", p.getNomLivrePret());
    }

    @Test
    void getPrets() {
    }

    @Test
    void getDatePret() {
    }

    @Test
    void getDatePretFormatee() {
    }

    @Test
    void getTitreLivrePret() {
    }

    @Test
    void setTitreLivrePret() throws SaisieException {
        pret.setTitreLivrePret("L'étranger");
        assertEquals("L'étranger", pret.getTitreLivrePret());
    }

    @Test
    void getNomLivrePret() {
    }

    @Test
    void setNomLivrePret() throws SaisieException {
        pret.setNomLivrePret("Albert Camus");
        assertEquals("Albert Camus", pret.getNomLivrePret());
    }
}