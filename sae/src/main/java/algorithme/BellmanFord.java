package algorithme;

public class BellmanFord 
{
 
    public Valeur resoudre(Graphe g, String depart)
    {
        Valeur[] v = new Valeur[g.listNoeuds().size()];

        for(int i =0;i<v.length;i++)
        {
            v[i].setValeur(g.listNoeuds().get(i), Double.MAX_VALUE);
        }


        //todo
        return null;

        
    }

}
