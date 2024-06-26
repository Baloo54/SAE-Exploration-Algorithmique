import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import algorithme.algorithmes.Algorithme;
import algorithme.algorithmes.BellmanFord;
import algorithme.algorithmes.Dijkstra;
import algorithme.autres.Valeur;
import algorithme.graphe.GrapheListe;
/**
 * Classe de test permettant de tester les algorithmes de résolution de graphe
 * algorithme de BellmanFord
 * algorithme de Dijkstra
 * @version 1.0
 * @autor : Comte Gabriel
 * @autor : Fuchs Thomas
 */
public class AlgorithmeTest 
{
    private Algorithme[] Algo;
    @BeforeEach
    public void setUp() {
        Algo = new Algorithme[]{new BellmanFord(), new Dijkstra()};
    }
    /**
     * Test de la méthode resoudre avec BellmanFord et Dijkstra
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
        //création d'un algorithme puis Dijkstra
        Valeur v = new Valeur();
        for(Algorithme algo : Algo){
            //résolution du graphe
            v=algo.resoudre(graphe,"A");
            //test
            assertEquals(0,v.getValeur("A"));
            assertEquals(12,v.getValeur("B"));
            assertEquals(76,v.getValeur("C"));
            assertEquals(66,v.getValeur("D"));
            assertEquals(23,v.getValeur("E"));
            assertEquals(null, v.getParent("A"));
            //test des parents
            assertEquals("A", v.getParent("B"));
            assertEquals("D", v.getParent("C"));
            assertEquals("E", v.getParent("D"));
            assertEquals("B", v.getParent("E"));
            //test du backtracking
            List<String> chemin = new ArrayList<>();
            chemin.add("C");
            chemin.add("D");
            chemin.add("E");
            chemin.add("B");
            chemin.add("A");
            assertEquals(chemin, v.chemin("C"));
        }
    }
    //test numéro 2 avec graphe du cours avec des graphes non pris en compte dans l'algorithme
    @Test
    public void testResoudre2(){
        GrapheListe graphe = new GrapheListe();
        //ajout des arcs
        graphe.ajouterArc("A", "B", 1);
        graphe.ajouterArc("E", "B", 2);
        graphe.ajouterArc("E", "F", 1);
        graphe.ajouterArc("B", "C", 3);
        graphe.ajouterArc("B", "G", 4);
        graphe.ajouterArc("B", "D", 5);
        graphe.ajouterArc("F", "C", 5);
        graphe.ajouterArc("F", "G", 3);
        graphe.ajouterArc("F", "H", 3);
        graphe.ajouterArc("C", "H", 2);
        graphe.ajouterArc("C", "D", 3);
        graphe.ajouterArc("G", "I", 5);
        graphe.ajouterArc("H", "I", 4);
        graphe.ajouterArc("D", "I", 2);
        //création d'un algorithme BellmanFord puis Dijkstra   
        Valeur v = new Valeur();
        for(Algorithme algo : Algo){
            //résolution du graphe
            v=algo.resoudre(graphe,"A");
            //test
            assertEquals(0,v.getValeur("A"));
            assertEquals(1,v.getValeur("B"));
            assertEquals(4,v.getValeur("C"));
            assertEquals(5,v.getValeur("G"));
            assertEquals(6,v.getValeur("D"));
            assertEquals(6,v.getValeur("H"));
            assertEquals(8,v.getValeur("I"));
            assertEquals(Double.MAX_VALUE,v.getValeur("E"));
            assertEquals(Double.MAX_VALUE,v.getValeur("F"));
            //test des parents
            assertEquals("A", v.getParent("B"));
            assertEquals("B", v.getParent("C"));
            assertEquals("C", v.getParent("H"));
            assertEquals("B", v.getParent("G"));
            assertEquals("B", v.getParent("D"));
            assertEquals("D", v.getParent("I"));
            //test du backtracking
            List<String> chemin = new ArrayList<>();
            chemin.add("I");
            chemin.add("D");
            chemin.add("B");
            chemin.add("A");
            assertEquals(chemin, v.chemin("I"));
        }
    }

    @Test
    public void testResoudre3() //test graphe vide
    {
        GrapheListe graphe = new GrapheListe();
        Algorithme[] algo = {new BellmanFord(), new Dijkstra()};
        Valeur v = new Valeur();
        for(Algorithme Algo : algo)
        {
            v=Algo.resoudre(graphe, "A");
            assertEquals(0,v.getValeur("A"));
            assertThrows(IllegalArgumentException.class, () -> {
                Algo.resoudre(graphe, "A").getParent("B");
            });
        }

    }

    @Test
    public void testResoudre4()//Test avec un graphe qui a un seul arc
    {
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A","B",13);
        Algorithme[] algo = {new BellmanFord(), new Dijkstra()};
        Valeur v = new Valeur();
        for(Algorithme Algo : algo)
        {
            v=Algo.resoudre(graphe, "A");
            assertEquals(0, v.getValeur("A"));
            assertEquals(13, v.getValeur("B"));
            assertEquals("A", v.getParent("B"));
        }
    }

    @Test
    public void testResoudre6()//Pattern linéaire
    {
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A", "B", 1);
        graphe.ajouterArc("B", "C", 1);
        Algorithme[] algo = {new BellmanFord(), new Dijkstra()};
        Valeur v = new Valeur();
        for(Algorithme Algo : algo)
        {
            v=Algo.resoudre(graphe, "A");
            assertEquals(0, v.getValeur("A"));
            assertEquals(1, v.getValeur("B"));
            assertEquals(2, v.getValeur("C"));
        }

    }

    @Test
    public void testResoudre7()//Pattern Circulaire
    {
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A", "B", 11);
        graphe.ajouterArc("B", "C", 3);
        graphe.ajouterArc("C", "D", 10);
        graphe.ajouterArc("D", "A", 20);
        Algorithme[] algo = {new BellmanFord(), new Dijkstra()};
        Valeur v = new Valeur();
        for(Algorithme Algo : algo)
        {
            v=Algo.resoudre(graphe, "A");
            assertEquals(null,v.getParent("A"));
            assertEquals("A", v.getParent("B"));
            assertEquals("B", v.getParent("C"));
            assertEquals("C", v.getParent("D"));
            assertEquals(null, v.getParent("A"));
        }
    }


    @Test
    public void testGrapheDeconnecte()//test avec des noeuds qui ne sont pas reliés
    {
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A", "B", 1);
        graphe.ajouterArc("C", "D", 1);
        Algorithme[] algo = {new BellmanFord(), new Dijkstra()};
        for(Algorithme Algo : algo)
        {
            Valeur v = Algo.resoudre(graphe, "A");
            assertEquals(0, v.getValeur("A"));
            assertEquals(1, v.getValeur("B"));
            assertEquals(Double.MAX_VALUE,v.getValeur("C"));
            assertEquals(Double.MAX_VALUE,v.getValeur("D"));
        }
    }

    @Test
    public void testUnSeulNoeud()//test avec un seul noeud
    {
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A", "A", 0);
        Algorithme[] algo = {new BellmanFord(), new Dijkstra()};
        for(Algorithme Algo : algo)
        {
            Valeur v = Algo.resoudre(graphe, "A");
            assertEquals(0, v.getValeur("A"));
        }
    }

    @Test
    public void testValuationNegative() // Test de la levée d'excpetion quand valuation négative
    {
        GrapheListe graphe = new GrapheListe();
        Algorithme[] algo = {new BellmanFord(), new Dijkstra()};
        for(Algorithme Algo : algo)
        {
            Valeur v = Algo.resoudre(graphe, "A");
            assertThrows(IllegalArgumentException.class, () -> {
                graphe.ajouterArc("A", "B", -1);
                assertEquals(0, v.getValeur("A"));
                assertEquals(-1, v.getValeur("B"));
            });
            
            
        }
    }

    


    //lancement du test 4
    public static void main(String[] args) {
        AlgorithmeTest test = new AlgorithmeTest();
        test.testResoudre4();
    }
}

