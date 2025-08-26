package pekopeko.afpa.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pekopeko.afpa.exception.SaisieException;
import pekopeko.afpa.model.Livre;

import static org.junit.jupiter.api.Assertions.*;

public class LivreTest {

    Livre livre;

    @BeforeEach
    void setUp() throws Exception {
        livre = new Livre("L'étranger", "Albert Camus", 20);
    }

    @AfterEach
    void tearDown() throws Exception {
        livre = null;
    }

    @Test
    public void testConstructeurArgsValide() throws SaisieException {
        Livre livre = new Livre("L'étranger", "Albert Camus", 20);

        assertEquals("L'étranger", livre.getTitreLivre());
        assertEquals("Albert Camus", livre.getAuteurLivre());
        assertEquals(25, livre.getQuantiteLivre());
    }

    @Test
    public void testConstructeurArgsNull_Empty() {
        assertThrows(SaisieException.class, () -> {
            new Livre("", "Albert Camus", 20); // cas pour empty ou null
        });
    }

    @Test
    void getLivres() {
    }

    @Test
    void getIsbn() {
    }

    @Test
    void setIsbn() throws SaisieException {
        livre.setIsbn("1234567891");
        assertEquals("1234567891", livre.getIsbn());
    }

    @Test
    void getTitreLivre() {
    }

    @Test
    void setTitreLivre() throws SaisieException {
        livre.setTitreLivre("L'étranger");
        assertEquals("L'étranger", livre.getTitreLivre());
    }

    @Test
    void getAuteurLivre() {
    }

    @Test
    void setAuteurLivre() throws SaisieException {
        livre.setAuteurLivre("Albert Camus");
        assertEquals("Albert Camus", livre.getAuteurLivre());
    }

    @Test
    void getQuantiteLivre() {
    }

    @Test
    void setQuantiteLivre() throws SaisieException {
        livre.setQuantiteLivre(11);
        assertEquals(11, livre.getQuantiteLivre());
    }
}
