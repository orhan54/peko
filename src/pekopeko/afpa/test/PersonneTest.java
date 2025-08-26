package pekopeko.afpa.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pekopeko.afpa.exception.SaisieException;
import pekopeko.afpa.model.Personne;

import static org.junit.jupiter.api.Assertions.*;

class PersonneTest {

    Personne personne;

    @BeforeEach
    void setUp() throws Exception {
        personne = new Personne("Doe", "John");
    }

    @AfterEach
    void tearDown() throws Exception {
        personne = null;
    }

    @Test
    public void testContructeurArgsValide() throws SaisieException {
        Personne p = new Personne("Doe", "John");
        //Assert
        assertEquals("Doe", p.getNom());
        assertEquals("John", p.getPrenom());
    }

    @Test
    public void testContructeurArgsNull_Empty() throws SaisieException {
        assertThrows(SaisieException.class, () -> {
            new Personne("Doe", null);
        });
    }

    /**
     * Test des cas positifs
     * @param nom
     * @throws SaisieException
     */
    @ParameterizedTest(name="{0} : le setter fonctionne correctement")
    @ValueSource(strings = {"Toto", "toto", "TOTO", "toTo", "TotOttI"})
    void setNomTest_Success(String nom) throws SaisieException {
        personne.setNom(nom);
        assertEquals(nom, personne.getNom());
    }

    @Test
    void setNom() throws SaisieException {
        personne.setNom("Doe");
        assertEquals("Doe", personne.getNom());
    }


    @Test
    void setPrenom() throws SaisieException {
        personne.setPrenom("John");
        assertEquals("John", personne.getPrenom());
    }

}