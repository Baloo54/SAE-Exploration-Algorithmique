
import java.util.ArrayList;

public class Arcs
{
    private ArrayList<Arc> arcs;

    public Arcs()
    {
        this.arcs=new ArrayList<>();
    }

    public void ajouterArc(Arc a)
    {
        this.arcs.add(a);
    }

    public ArrayList<Arc> getArcs()
    {
        return this.arcs;
    }

    
}