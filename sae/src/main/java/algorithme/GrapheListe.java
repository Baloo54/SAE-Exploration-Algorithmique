
import java.lang.reflect.Array;
import java.util.ArrayList;

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
    


    public ArrayList<Arc> suivants(String n)
    {   
       ArrayList<Arc> res; 
       Arcs tmp = new Arcs();

       //res.add();

    }

    public ArrayList<String> listNoeuds(String n)
    {

        
    }

}
