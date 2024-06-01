package algorithme.main;

import java.util.List;
import algorithme.algorithmes.Dijkstra;
import algorithme.autres.Valeur;
import algorithme.graphe.GrapheListe;

/**
 * Classe MainDijkstra qui permet de tester l'algorithme de Dijkstra
 * @version 1.0
 * @autor : Comte Gabriel
 * @autor : Fuchs Thomas
 */
public class MainDijkstra 
{
    public static void main(String[] args) 
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
        //affichage du graphe
        System.out.println("\n" + graphe);
        /*************************DIJKSTRA*********************/
        System.out.println();
        System.out.println();
        //objet Dijkstra
        Dijkstra dijkstra = new Dijkstra();
        //plus court chemin
        Valeur v = new Valeur();
        v=dijkstra.resoudre(graphe, "A");
        //affichage du resultat
        System.out.print(v);
        System.out.println("\n" + v.chemin("C"));
        List<String> chemin = v.chemin("C");
        System.out.println("Chemin : " + chemin);
    }
    
}
