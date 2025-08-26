package pekopeko.afpa.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import pekopeko.afpa.exception.SaisieException;
import pekopeko.afpa.model.Client;
import pekopeko.afpa.model.Personne;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    Client client;

    @BeforeEach
    void setUp() throws SaisieException {
        client= new Client("Doe", "John", "johndoe@live.fr", LocalDateTime.now());
    }

    @AfterEach
    void tearDown() throws SaisieException {
        client=null;
    }

    @Test
    public void testConstructeurArgsValide() throws SaisieException {
        Client c = new Client("Doe", "John", "johndoe@live.fr", LocalDateTime.now());
        assertEquals("Doe", c.getNom());
        assertEquals("John", c.getPrenom());
        assertEquals("johndoe@live.fr", c.getEmail());
        assertEquals(LocalDateTime.now(), c.getDateInscription());
    }


    @Test
    public void testConstructeurArgsNull_Empty() throws SaisieException {
        assertThrows(SaisieException.class, ()->{
            new Client(null,null,null,LocalDateTime.now());
        });
    }

    @Test
    void getClients() {
    }

    @Test
    void getEmail() {
    }

    @Test
    void setEmail() throws SaisieException {
        client.setEmail("johndoe@live.fr");
        assertEquals("johndoe@live.fr", client.getEmail());
    }

    @Test
    void getDateInscription() {
    }

    @Test
    void getDateCreationFormatee() {
    }
}