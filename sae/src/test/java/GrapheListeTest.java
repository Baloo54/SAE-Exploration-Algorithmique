import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import algorithme.graphe.GrapheListe;

/**
 * Classe de tests de la classe GrapheListe
 * 
 * @author Gabriel
 * @author Thomas
 * @version 1.0
 */
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
    // test création d'un graphe simple et test de la méthode toString
    @Test
    public void testGrapheListe() {
        // ajout du noeud manquant soit le b
        graphe.ajouterArc("B", "E", 11);
        // vérification du graphe
        String attendu = "A -> B(12) D(87) \nB -> E(11) \nC -> A(19) \nD -> B(23) C(10) \nE -> D(43) \n";
        assertEquals(attendu, graphe.toString());
    }
    // test création d'un graphe vide et test de la méthode toString
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
    // test getIndice avec un noeud inexistant
    @Test
    public void testGetIndiceInexistant() {
        assertThrows(IllegalArgumentException.class, () -> {
            graphe.getIndice("F");
        });
    }
    //test ajout d'un arc avec un noeud de départ null
    @Test
    public void testAjouterArcDepartNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            graphe.ajouterArc(null, "B", 12);
        });
    }
    //test ajout d'un arc avec un noeud de destination null
    @Test
    public void testAjouterArcDestinationNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            graphe.ajouterArc("A", null, 12);
        });
    }
    //test ajout d'un arc avec un cout négatif
    @Test
    public void testAjouterArcCoutNegatif() {
        assertThrows(IllegalArgumentException.class, () -> {
            graphe.ajouterArc("A", "B", -12);
        });
    }
    // test suivants avec un noeud existant
    @Test
    public void testSuivants() {
        String[] attendu = {"B(12)", "D(87)"};
        for(int i = 0; i < attendu.length; i++) {
            assertEquals(attendu[i], graphe.suivants("A").get(i).toString());
        }
    }
    // test suivants avec un noeud inexistant
    @Test
    public void testSuivantsInexistant() {
        assertThrows(IllegalArgumentException.class, () -> {
            graphe.suivants("F");
        });
    }
    // test suivants avec un noeud sans successeur
    @Test
    public void testSuivantsSansSuccesseur() {
        assertEquals(0, graphe.suivants("B").size());
    }
    // test suivants avec un graphe vide
    @Test
    public void testSuivantsVide() {
        GrapheListe graphe = new GrapheListe();
        assertThrows(IllegalArgumentException.class, () -> {
            graphe.suivants("A");
        });
    }
    //test toString avec un graphe vide
    @Test
    public void testToStringVide() {
        GrapheListe graphe = new GrapheListe();
        String attendu = "";
        assertEquals(attendu, graphe.toString());
    }
    //test setFirstNode et utilisation de getFirstNode
    @Test
    public void testSetFirstNode() {
        graphe.setFirstNode("A");
        assertEquals("A", graphe.getFirstNode());
    }
    //test setFirstNode avec un noeud inexistant
    @Test
    public void testSetFirstNodeInexistant() {
        assertThrows(IllegalArgumentException.class, () -> {
            graphe.setFirstNode("F");
        });
    }
}


