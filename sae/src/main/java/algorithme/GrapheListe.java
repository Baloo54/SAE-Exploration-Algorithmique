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
        //verifie si le noeud n'est pas deja present
        if(!this.noeuds.contains(depart))
        {
            this.noeuds.add(depart);
            this.adjacence.add(new Arcs());
            
        }
        //verifie si le noeud destination n'est pas deja present 
        // et permet donc d'afficher tout de même les noeuds sans arcs
        // sans successeurs
        else if(!this.noeuds.contains(destination))
        {
            this.noeuds.add(destination);
            this.adjacence.add(new Arcs());
        }
        // on recupere l'indice du noeud de depart
        int i = getIndice(depart);
        // on cree un arc
        Arc a = new Arc(destination, cout);
        // on ajoute l'arc a la liste des arcs
        this.adjacence.get(i).ajouterArc(a);
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
        //trie les noeuds par ordre alphabetique
        res.sort(null);
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
        List<String> noeuds = listNoeuds();
        for(int i=0; i<noeuds.size(); i++)
        {
            res += noeuds.get(i) + " -> ";
            // on parcourt la liste des noeuds suivants
            List<Arc> suivants = suivants(noeuds.get(i));
            for(int j=0; j<suivants.size(); j++)
            {
                res += suivants.get(j).toString() + " ";
            }
            res += "\n";
        }
        return res;
    }
}
