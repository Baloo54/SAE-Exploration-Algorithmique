package algorithme;


import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @autor : Comte Gabriel
 * @autor : Fuchs Thomas
 * Permet de stocker un graphe sous forme de liste
 */
public class GrapheListe implements Graphe
{
    /**
     * attributs pour stocker les informations
     * - noeuds : liste des noeuds
     * - adjacence : liste des arcs
     */
    private ArrayList<String> noeuds;
    private ArrayList<Arcs> adjacence;
    /**
     * constructeur vide
     */
    public GrapheListe()
    {
        this.noeuds=new ArrayList<>();
        this.adjacence=new ArrayList<>();
    }
    /**
     * permet de recuperer l'indice d'un noeud
     * @param n le noeud
     * @return l'indice du noeud
     */
    public int getIndice(String n)
    {
        return this.noeuds.indexOf(n);
    }
    /**
     * permet d'ajouter un arc
     * @param depart le noeud de depart
     * @param destination le noeud d'arrivee
     * @param cout le cout de l'arc
     */
    public void ajouterArc(String depart, String destination, double cout)
    {    
        Arcs arcs = new Arcs();
        Arc arc = new Arc(destination, cout);
        // on ajoute l'arc a la liste des arcs
        arcs.ajouterArc(arc);
        // on ajoute le noeud a la liste des noeuds
        this.noeuds.add(depart!=null ? depart : null);
        // on ajoute les arcs a la liste des arcs
        this.adjacence.add(getIndice(depart),arcs);
    }
    /**
     * @param n 
     * @return 
     * Retourne la liste des noeuds suivants du noeud n
     */
    @Override
    public List<Arc> suivants(String n)
    {   
        List<Arc> res=this.adjacence.get(getIndice(n)).getArcs();
        return res;
    }
    /**
     * @return 
     * Retourne la liste des noeuds du graphe
     */
    @Override
    public List<String> listNoeuds()
    {
        List<String> res = new ArrayList<>();
        // on parcourt la liste des noeuds
        for(int i=0; i<this.noeuds.size(); i++)
        {
            res.add(this.noeuds.get(i));
        }
        return res;
    }
    /**
     * toString du graphe
     * @return le graphe
     */
    public String toString()
    {
        String res = "";
        // on parcourt la liste des noeuds
        for(int i=0; i<this.noeuds.size(); i++)
        {
            res += this.noeuds.get(i) + " -> ";
            // on parcourt la liste des arcs
            for(int j=0; j<this.adjacence.get(i).getArcs().size(); j++)
            {
                res += this.adjacence.get(i).getArcs().get(j).toString() + " ";
            }
            res += "\n";
        }
        return res;
    }
}
