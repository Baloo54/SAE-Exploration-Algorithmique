package algorithme;

/**
 * @version 1.0
 * @autor : Comte Gabriel
 * @autor : Fuchs Thomas
 * Permet de tester la classe GrapheListe
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


        BellmanFord bf = new BellmanFord();
        
        Valeur v = new Valeur();

        v=bf.resoudre(graphe,"A");

        System.out.print(v);


    }
    
}
