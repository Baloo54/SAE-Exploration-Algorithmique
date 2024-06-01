import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import algorithme.graphe.Arc;
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
    //Test  création arc avec destination null
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
    //Test setter cout positif
    @Test
    public void testArcSetCoutPositif() {
        Arc a = new Arc("B", 2.0);
        a.setCout(3.0);
        assertEquals(3.0, a.getCout());
    }
    //test methode toString
    @Test
    public void testArcToString() {
        Arc a = new Arc("B", 2.0);
        assertEquals("B(2)", a.toString());
    }
    //test setDest valide
    @Test
    public void testArcSetDest() {
        Arc a = new Arc("B", 2.0);
        a.setDest("C");
        assertEquals("C", a.getDest());
    }
    //test égalité de deux arcs null
    @Test
    public void testArcEqualsNull() {
        Arc a = new Arc("B", 2.0);
        assertFalse(a.equals(null));
    }
}

