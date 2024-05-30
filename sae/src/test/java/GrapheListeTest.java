import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import algorithme.*;

public class GrapheListeTest {
    private GrapheListe graphe;
    @BeforeEach
    // factorisation de la création du graphe
    public void setUp() {
        graphe = new GrapheListe();
        // création d'un graphe simple
        graphe.ajouterArc("A", "B", 12);
        graphe.ajouterArc("A", "D", 87);
        graphe.ajouterArc("E", "D", 43);
        graphe.ajouterArc("D", "B", 23);
        graphe.ajouterArc("D", "C", 10);
        graphe.ajouterArc("C", "A", 19);
    }
    // test création d'un graphe simple
    @Test
    public void testGrapheListe() {
        // ajout du noeud manquant soit le b
        graphe.ajouterArc("B", "E", 11);
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
    // test création d'un graphe avec un noeud sans successeur car dans le beforeeach on a pas ajouté de successeur à B
    @Test
    public void testGrapheListeSansSuccesseur() {
        // noeud B n'a pas de successeur
        String attendu = "A -> B(12) D(87) \nB -> \nC -> A(19) \nD -> B(23) C(10) \nE -> D(43) \n";
        assertEquals(attendu, graphe.toString());
    }
    //test méthode listNoeuds
    @Test
    public void testListeNoeuds() {
        String[] attendu = {"A", "B", "C", "D", "E"};
        for(int i = 0; i < attendu.length; i++) {
            assertEquals(attendu[i], graphe.listNoeuds().get(i));
        }
    }
    // test méthode listeNoeuds avec un graphe vide
    @Test
    public void testListeNoeudsVide() {
        GrapheListe graphe = new GrapheListe();
        assertEquals(0, graphe.listNoeuds().size());
    }
}


