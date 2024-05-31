package algorithme;

import java.util.ArrayList;

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

        //affichage du résultat
        System.out.print(v);
        System.out.println("\n" + v.chemin("C"));
        GrapheListes gl = new GrapheListes();
        ArrayList<GrapheListe> gListes = gl.biuldList("sae/src/main/resources/Graphes");
    }   
}
