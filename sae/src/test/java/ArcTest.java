import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import algorithme.*;
/**
 * Test de la classe Arc
 * @version 1.0
 * @autor : Comte Gabriel
 * @autor : Fuchs Thomas
 */
public class ArcTest {
    //Test  création arc simple
    @Test
    public void testArcCreation() {
        Arc a = new Arc("B", 2.0);
        assertEquals("B", a.getDest());
        assertEquals(2.0, a.getCout());
    }
    //Test  création arc avec cout négatif
    @Test
    public void testArcCreationCoutNegatif() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Arc("B", -2.0);
        });
    }
    //Test  création arc avec destination nulle
    @Test
    public void testArcCreationDestinationNulle() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Arc(null, 2.0);
        });
    }
    //Test  si deux arcs sont égaux
    @Test
    public void testArcEquals() {
        Arc a = new Arc("B", 2.0);
        Arc b = new Arc("B", 2.0);
        assertTrue(a.equals(b));
    }
    //Test  si deux arcs sont différents
    @Test
    public void testArcNotEquals() {
        Arc a = new Arc("B", 2.0);
        Arc b = new Arc("C", 2.0);
        assertFalse(a.equals(b));
    }
    //Test setter destination nulle
    @Test
    public void testArcSetDestinationNulle() {
        Arc a = new Arc("B", 2.0);
        assertThrows(IllegalArgumentException.class, () -> {
            a.setDest(null);
        });
    }
    //Test setter cout négatif
    @Test
    public void testArcSetCoutNegatif() {
        Arc a = new Arc("B", 2.0);
        assertThrows(IllegalArgumentException.class, () -> {
            a.setCout(-2.0);
        });
    }
}

