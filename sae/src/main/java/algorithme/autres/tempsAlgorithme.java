package algorithme.autres;

import algorithme.chargerFichiers.*;
import java.util.ArrayList;
import algorithme.algorithmes.Algorithme;
import algorithme.graphe.GrapheListe;

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
        if(Liste == null || Algo == null || folder == null){
            throw new IllegalArgumentException("Les paramètres ne peuvent pas être null");
        }
        long startTime = System.currentTimeMillis();
        ArrayList<GrapheListe> graphe = Liste.buildList(folder);
        for(GrapheListe g : graphe){
            Algo.resoudre(g, g.getFirstNode());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("\nTemps d'execution de réolution des différents graphes de type : " + folder + "avec l'algo de :" + Algo.getClass() +" "+ (endTime - startTime) + " ms\n");
    }
}
