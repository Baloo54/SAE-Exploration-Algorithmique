import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import algorithme.*;
/**
 * Test de la classe BellmanFord
 * @version 1.0
 * @autor : Comte Gabriel
 * @autor : Fuchs Thomas
 */
public class BellmanFordTest 
{
    /**
     * Test de la méthode resoudre
     */
    @Test
    public void testResoudre()
    {
        GrapheListe graphe = new GrapheListe();
        //ajout des arcs
        graphe.ajouterArc("A", "B", 12);
        graphe.ajouterArc("A", "D", 87);
        graphe.ajouterArc("B", "E", 11);
        graphe.ajouterArc("E", "D", 43);
        graphe.ajouterArc("D", "B", 23);
        graphe.ajouterArc("D", "C", 10);
        graphe.ajouterArc("C", "A", 19);
        //création d'un objet BellmanFord
        BellmanFord bf = new BellmanFord();
        //résolution du graphe
        Valeur v = new Valeur();
        v=bf.resoudre(graphe,"A");
        //test
        assertEquals(0,v.getValeur("A"));
        assertEquals(12,v.getValeur("B"));
        assertEquals(76,v.getValeur("C"));
        assertEquals(66,v.getValeur("D"));
        assertEquals(23,v.getValeur("E"));
    }
}

