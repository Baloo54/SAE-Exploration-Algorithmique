import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import algorithme.*;
/**
 * Test de la classe Arcs
 * @version 1.0
 * @autor : Comte Gabriel
 * @autor : Fuchs Thomas
 */
public class ArcsTest {
    //Test  création arcs simple
    @Test
    public void testArcsCreation() {
        Arcs a = new Arcs();
        assertNotNull(a.getArcs());
    }
    //Test  ajout d'un arc
    @Test
    public void testArcsAjouterArc() {
        Arcs a = new Arcs();
        a.ajouterArc(new Arc("B", 2.0));
        assertEquals(1, a.getArcs().size());
    }
    //Test  ajout d'un arc nul
    @Test
    public void testArcsAjouterArcNul() {
        Arcs a = new Arcs();
        assertThrows(IllegalArgumentException.class, () -> {
            a.ajouterArc(null);
        });
    }
    //Test  si deux arcs sont égaux
    @Test
    public void testArcsEquals() {
        Arcs a = new Arcs();
        a.ajouterArc(new Arc("B", 2.0));
        Arcs b = new Arcs();
        b.ajouterArc(new Arc("B", 2.0));
        assertTrue(a.equals(b));
    }
    //Test  si deux arcs sont différents
    @Test
    public void testArcsNotEquals() {
        Arcs a = new Arcs();
        a.ajouterArc(new Arc("B", 2.0));
        Arcs b = new Arcs();
        b.ajouterArc(new Arc("C", 2.0));
        assertFalse(a.equals(b));
    }
}
