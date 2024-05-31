package algorithme;

import java.util.ArrayList;

/**
 * Class tempsAlgorithme qui permet de calculer le temps d'execution d'un algorithme
 * @version 1.0
 * @autor : Comte Gabriel
 * @autor : Fuchs Thomas
 */
public class tempsAlgorithme {
    /**
     * fonction qui permet de calculer le temps d'execution d'un algorithme
     * @param buildListe selecteur de liste
     * @param Algo selecteur d'algorithme
     */
    public void calculTemps(buildListe Liste, Algorithme Algo, String folder){
        long startTime = System.currentTimeMillis();
        ArrayList<GrapheListe> graphe = Liste.buildList(folder);
        for(GrapheListe g : graphe){
            Algo.resoudre(g, g.getFirstNode());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Temps d'execution de réolution des différents graphes : " + (endTime - startTime) + "ms");
    }
}
