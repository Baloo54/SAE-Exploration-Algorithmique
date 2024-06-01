package algorithme.main;

import java.util.List;
import algorithme.graphe.GrapheListe;
import algorithme.algorithmes.BellmanFord;
import algorithme.autres.Valeur;

/**
 * @version 1.0
 * @autor : Comte Gabriel
 * @autor : Fuchs Thomas
 * Permet de tester le projet
 */
public class Main 
{
    /**
     * methode principale
     * @param args
     */
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
        /********************BELLMAN-FORD***********************/
        //création d'un objet BellmanFord
        BellmanFord bf = new BellmanFord();
        //plus court chemin
        Valeur v = new Valeur();
        v=bf.resoudre(graphe,"A");
        System.out.println("Plus court chemin : \n"+v);
        List<String> chemin = v.chemin("E");
        //affichage du chemin pour aller de A à E
        System.out.println("Chemin : "+chemin);
    }
}
