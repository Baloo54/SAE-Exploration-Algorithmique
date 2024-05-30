package algorithme;
/**
 * 
 * @author Thomas
 * @author Gabriel
 * 
 */
public class BellmanFord 
{
    /**
     * 
     * @param g
     * @param depart
     * @return
     * 
     * Méthode qui à partir d'un graphe et un point de départ,
     * va retourner le point fixe du plus court chemin de ce même graphe en utilisant l'algorithme de Bellman-Ford
     */
    public Valeur resoudre(Graphe g, String depart)
    {
        Valeur v = new Valeur();

        for(String s : g.listNoeuds())
        {
            v.setValeur(s, Double.MAX_VALUE);
            v.setParent(s, null);
        }

        v.setValeur(depart,0);

        boolean b = true;
        while(b)
        {   
            b=false;
            for(String s : g.listNoeuds())
            {
                for(Arc arc : g.suivants(s))
                {
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
