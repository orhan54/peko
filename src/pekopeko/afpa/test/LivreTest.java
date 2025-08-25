package pekopeko.afpa.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import pekopeko.afpa.exception.SaisieException;
import pekopeko.afpa.model.Livre;

import static org.junit.jupiter.api.Assertions.*;

public class LivreTest {

    @Test
    public void testConstructeurArgsValide() throws SaisieException {
        Livre livre = new Livre("L'étranger", "Albert Camus", 25);

        assertEquals("L'étranger", livre.getTitreLivre());
        assertEquals("Albert Camus", livre.getAuteurLivre());
        assertEquals(25, livre.getQuantiteLivre());
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testConstructeurArgsNull_Empty(String lTitre) {
        assertThrows(SaisieException.class, () -> {
            new Livre(lTitre, "Albert Camus", 25);
        });
    }

    @Test
    void getLivres() {
    }

    @Test
    void getIsbn() {
    }

    @Test
    void setIsbn() {
    }

    @Test
    void getTitreLivre() {
    }

    @Test
    void setTitreLivre() {
    }

    @Test
    void getAuteurLivre() {
    }

    @Test
    void setAuteurLivre() {
    }

    @Test
    void getQuantiteLivre() {
    }

    @Test
    void setQuantiteLivre() {
    }
}
