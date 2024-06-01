package algorithme.algorithmes;
import algorithme.autres.Valeur;
import algorithme.graphe.GrapheListe;
import algorithme.graphe.Arc;
/**
 * Classe qui permet de résoudre un graphe en utilisant l'algorithme de Bellman-Ford
 * @author Thomas
 * @author Gabriel
 * @version 1.0
 */
public class BellmanFord implements Algorithme
{
    /**
     * 
     * @param g graphe
     * @param depart point de départ
     * @return Valeur
     * 
     * Méthode qui à partir d'un graphe et un point de départ,
     * va retourner le point fixe du plus court chemin de ce même
     * graphe en utilisant l'algorithme de Bellman-Ford
     * L'algorithme se trouve dans le rapport
     */
    public Valeur resoudre(GrapheListe g, String depart)
    {
        Valeur v = new Valeur();
        //Initialisation des valeurs de v
        // toutes les valeurs sont à +infini sauf le départ qui est à 0
        for(String s : g.listNoeuds())
        {
            v.setValeur(s, Double.MAX_VALUE);
            v.setParent(s, null);
        }
        v.setValeur(depart,0);
        //tant qu'il y a des changements
        boolean b = true;
        while(b == true)
        {   
            b=false;
            //pour chaque noeud
            for(String s : g.listNoeuds())
            {
                //pour chaque arc partant de ce noeud
                for(Arc arc : g.suivants(s))
                {
                    //si la valeur du noeud de destination est plus grande que la valeur du noeud de départ 
                    // + le coût de l'arc

                    //Valeur nulle, qui balance une exception
                    if(v.getValeur(s) + arc.getCout() < v.getValeur(arc.getDest()))
                    {
                        v.setValeur(arc.getDest(), v.getValeur(s)+arc.getCout());
                        v.setParent(arc.getDest(), s);
                        b=true;
                    }
                }
            }
        }
        return v;
    }
}
