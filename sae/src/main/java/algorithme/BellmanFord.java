package algorithme;

public class BellmanFord 
{
 
    public Valeur resoudre(Graphe g, String depart)
    {
        Valeur v = new Valeur();

        for(String s : g.listNoeuds())
        {
            v.setValeur(s, Double.MAX_VALUE);
            v.setParent(s, null);
        }

        v.setValeur(depart,0);

        while(//TODO)
        {
            for(String s : g.listNoeuds())
            {
                for(Arc arc : g.suivants(s))
                {
                    if()
                    {
                        //J'AI PAS FINI
                    }
                }
            }
        }


        

        
    }

}
