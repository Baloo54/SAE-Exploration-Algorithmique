import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import algorithme.*;

public class GrapheListeTest {
    // test création d'un graphe simple
    @Test
    public void testGrapheListe() {
        GrapheListe graphe = new GrapheListe();
        // création d'un graphe simple
        graphe.ajouterArc("A", "B", 12);
        graphe.ajouterArc("A", "D", 87);
        graphe.ajouterArc("B", "E", 11);
        graphe.ajouterArc("E", "D", 43);
        graphe.ajouterArc("D", "B", 23);
        graphe.ajouterArc("D", "C", 10);
        graphe.ajouterArc("C", "A", 19);
        // vérification du graphe
        String attendu = "A -> B(12) D(87) \nB -> E(11) \nC -> A(19) \nD -> B(23) C(10) \nE -> D(43) \n";
        assertEquals(attendu, graphe.toString());
    }
    // test création d'un graphe vide
    @Test
    public void testGrapheListeVide() {
        GrapheListe graphe = new GrapheListe();
        String attendu = "";
        assertEquals(attendu, graphe.toString());
    }
    // test création d'un graphe avec un noued sans successeur
    @Test
    public void testGrapheListeSansSuccesseur() {
        GrapheListe graphe = new GrapheListe();
        // création d'un graphe avec un noeud sans successeur
        graphe.ajouterArc("A", "B", 12);
        graphe.ajouterArc("A", "D", 87);
        graphe.ajouterArc("E", "D", 43);
        graphe.ajouterArc("D", "B", 23);
        graphe.ajouterArc("D", "C", 10);
        graphe.ajouterArc("C", "A", 19);
        // noeud B n'a pas de successeur
        String attendu = "A -> B(12) D(87) \nB -> \nC -> A(19) \nD -> B(23) C(10) \nE -> D(43) \n";
        assertEquals(attendu, graphe.toString());
    }
}


