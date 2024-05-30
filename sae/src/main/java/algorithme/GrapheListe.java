package algorithme;


import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe
{

    private ArrayList<String> noeuds;
    private ArrayList<Arcs> adjacence;

    public int getIndice(String n)
    {
        return this.getIndice(n);
    }

    public void ajouterArc(String depart, String destination, double cout)
    {    
        Arcs arcs = new Arcs();
        Arc arc = new Arc(destination, cout);
        arcs.ajouterArc(arc);

        this.noeuds.add(depart!=null ? depart : null);
        this.adjacence.add(getIndice(depart),arcs);
    }
    

    /**
     * @param n 
     * @return 
     * Retourne la liste des noeuds suivants du noeud n
     */
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
        for(int i=0; i<this.noeuds.size(); i++)
        {
            res.add(this.noeuds.get(i));
        }
       
        return res;
        
    }

   
}
