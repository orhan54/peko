package pekopeko.afpa.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pekopeko.afpa.exception.SaisieException;
import pekopeko.afpa.model.Staff;

import static org.junit.jupiter.api.Assertions.*;

class StaffTest {

    Staff staff;

    @BeforeEach
    void setUp() throws SaisieException {
        staff = new Staff("Doe", "John", 1);
    }

    @AfterEach
    void tearDown() throws SaisieException {
        staff = null;
    }

    @Test
    public void testContructeurArgsValide() throws SaisieException {
        Staff staff = new Staff("Doe", "John", 1);
        assertEquals("Doe", staff.getNom());
        assertEquals("John", staff.getPrenom());
        assertEquals(1, staff.getId());
    }

    @Test
    void getStaffs() {
    }

    @Test
    void getId() {
    }

    @Test
    void setId() throws SaisieException {
        int value = staff.getId();
        staff.setId(5);
        assertEquals(value+1, staff.getId());
    }
}