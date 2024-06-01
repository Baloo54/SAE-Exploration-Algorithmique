import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import algorithme.autres.Valeur;
/**
 * Test de la classe valeur
 * @version 1.0
 * @autor : Comte Gabriel
 * @autor : Fuchs Thomas
 */
public class ValeurTest {
    @BeforeEach
    public void setUp() {
        @SuppressWarnings("unused")
        Valeur v = new Valeur();
    }
    //Test  de setValeur
    @Test
    public void testSetValeur() {
        Valeur v = new Valeur();
        v.setValeur("B", 2.0);
        assertEquals(2.0, v.getValeur("B"));
    }
    //Test  de setValeur avec nom null
    @Test
    public void testSetValeurNomNull() {
        Valeur v = new Valeur();
        assertThrows(IllegalArgumentException.class, () -> {
            v.setValeur(null, 2.0);
        });
    }
    //Test  de setParent
    @Test
    public void testSetParent() {
        Valeur v = new Valeur();
        v.setParent("B", "A");
        assertEquals("A", v.getParent("B"));
    }
    //Test  de setParent avec nom null  
    @Test
    public void testSetParentNomNull() {
        Valeur v = new Valeur();
        assertThrows(IllegalArgumentException.class, () -> {
            v.setParent(null, "A");
        });
    }
    //Test  de getParent
    @Test
    public void testGetParent() {
        Valeur v = new Valeur();
        v.setParent("B", "A");
        assertEquals("A", v.getParent("B"));
    }
    //Test  de getParent avec nom null
    @Test
    public void testGetParentNomNull() {
        Valeur v = new Valeur();
        assertThrows(IllegalArgumentException.class, () -> {
            v.getParent(null);
        });
    }
    //Test  de getParent avec nom inexistant
    @Test
    public void testGetParentInexistant() {
        Valeur v = new Valeur();
        assertThrows(IllegalArgumentException.class, () -> {
            v.getParent("B");
        });
    }
    //Test  de getValeur
    @Test
    public void testGetValeur() {
        Valeur v = new Valeur();
        v.setValeur("B", 2.0);
        assertEquals(2.0, v.getValeur("B"));
    }
    //Test  de getValeur avec nom null
    @Test
    public void testGetValeurNomNull() {
        Valeur v = new Valeur();
        assertThrows(IllegalArgumentException.class, () -> {
            v.getValeur(null);
        });
    }
    //Test  de getValeur avec nom inexistant
    @Test
    public void testGetValeurInexistant() {
        Valeur v = new Valeur();
        assertThrows(IllegalArgumentException.class, () -> {
            v.getValeur("B");
        });
    }
}