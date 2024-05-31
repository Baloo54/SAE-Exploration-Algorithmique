package algorithme;
/**
 * Class mainTempsAlgorithme qui permet de lancer le calcul du temps d'execution d'un algorithme
 */
public class mainTempsAlgorithme {
    public static void main(String[] args) {
        tempsAlgorithme ta = new tempsAlgorithme();
        // premier temps avec les liste laby et Dijkstra
        ta.calculTemps(new LabyListes(), new Dijkstra(), "sae/src/main/resources/labySimple/");
        // deuxieme temps avec les liste laby et BellmanFord
        ta.calculTemps(new LabyListes(), new BellmanFord(), "sae/src/main/resources/labySimple/");
        // troisieme temps avec les liste Graphes et Dijkstra
        ta.calculTemps(new GrapheListes(), new Dijkstra(), "sae/src/main/resources/Graphes/");
        // quatrieme temps avec les liste Graphes et BellmanFord
        ta.calculTemps(new GrapheListes(), new BellmanFord(), "sae/src/main/resources/Graphes/");
    }
}
