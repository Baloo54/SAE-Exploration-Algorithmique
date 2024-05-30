package algorithme;
/**
 * @version 1.0
 * @autor : Comte Gabriel
 * @autor : Fuchs Thomas
 * Interface Graphe
 * - permet de lister les noeuds
 * - permet de lister les noeuds suivants
 */
import java.util.*;

public interface  Graphe 
{
    /**
     * @return 
     * Retourne la liste des noeuds du graphe
     */
    public List<String> listNoeuds(); 
    /**
     * @param n 
     * @return 
     * Retourne la liste des noeuds suivants du noeud n
     */
    public List<Arc> suivants(String n);
}
