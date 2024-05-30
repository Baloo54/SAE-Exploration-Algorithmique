package algorithme;

/**
 * @version 1.0
 * @autor : Comte Gabriel
 * @autor : Fuchs Thomas
 * permet de stocker des arcs
 */
import java.util.ArrayList;

public class Arcs
{
    /**
     * attribut pour stocker les arcs
     */
    private ArrayList<Arc> arcs;
    /**
     * constructeur vide
     */
    public Arcs()
    {
        this.arcs=new ArrayList<>();
    }
    /**
     * permet d'ajouter un arc
     * @param a l'arc a ajouter
     */
    public void ajouterArc(Arc a)
    {
        if (a != null) {
            this.arcs.add(a);    
        }else
        {
            throw new IllegalArgumentException("L'arc ne doit pas être nul");
        }
    }
    /**
     * getter des arcs
     * @return les arcs
     */
    public ArrayList<Arc> getArcs()
    {
        return this.arcs;
    }
    /**
     * méthode equals
     * @param o l'objet a comparer
     * @return true si les objets sont égaux, false sinon
     */
    public boolean equals(Object o)
    {
        if(o instanceof Arcs)
        {
            Arcs a = (Arcs) o;
            return this.arcs.equals(a.getArcs());
        }
        return false;
    }
}