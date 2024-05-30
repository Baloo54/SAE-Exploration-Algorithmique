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
        this.arcs.add(a);
    }
    /**
     * getter des arcs
     * @return les arcs
     */
    public ArrayList<Arc> getArcs()
    {
        return this.arcs;
    }
}