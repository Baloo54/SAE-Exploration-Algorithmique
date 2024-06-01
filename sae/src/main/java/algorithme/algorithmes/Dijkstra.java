package algorithme.algorithmes;

import java.util.ArrayList;

import algorithme.autres.Valeur;
import algorithme.graphe.Arc;
import algorithme.graphe.GrapheListe;

public class Dijkstra implements Algorithme
{
    /**
     * Entrées :
        G un graphe orienté avec une pondération positive des arcs (coût ou poids)
        A un sommet (départ) de G

        Début
        Q <- {} //utilisation d’une liste de noeuds à traiter
        Pour chaque sommet v de G faire
            v.valeur <- Infini
            v.parent <- Indéfini
            Q <- Q U {v} //ajouter le sommet v à la liste Q
        Fin Pour

        A.valeur <- 0

        Tant que Q est un ensemble non vide faire
            u <- un sommet de Q telle que u.valeur est minimal
            //enlever le sommet u de la liste Q
            Q <- Q \ {u}
            Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
                d <- u.valeur + poids(u,v)
                Si d < v.valeur
                    //le chemin est plus interessant
                    Alors v.valeur <- d
                          v.parent <- u
                Fin Si
            Fin Pour
        Fin Tant que
       Fin
     *  
     * */    



    /**
     * @return
     * @param g
     * @param depart
     * 
     * Recherhce du plus court chemin en utilisant L'Algorithme de Bellman-Ford
     */
    public Valeur resoudre(GrapheListe g, String depart)
    {   

        Valeur v = new Valeur();
        ArrayList<String> noeudsTraiter = new ArrayList<>();


        for(String s : g.listNoeuds())
        {
            v.setValeur(s, Double.MAX_VALUE);
            v.setParent(s, null);
            noeudsTraiter.add(s);
        }

        v.setValeur(depart, 0);
        boolean b = true;
        while(!noeudsTraiter.isEmpty() && b)
        {
            b = false;
            String u = getMini(noeudsTraiter,v);
            noeudsTraiter.remove(u);
            
            for(Arc arc : g.suivants(u))
            {
                String voisin = arc.getDest();
                double poids = arc.getCout();
                double d = v.getValeur(u) + poids;

                if(d < v.getValeur(voisin))
                {
                    b = true;
                    v.setValeur(voisin, d);
                    v.setParent(voisin, u);
                }
            }
        }

        return v;
    }

    /**
     * @param noeuds
     * @param v
     * @return
     * Cherche l'arête la plus courte vers un voisin d'un sommet encore non traité
     */
    public String getMini(ArrayList<String> noeuds, Valeur v)
    {
        String minNoeud = null;
        double minValeur = Double.MAX_VALUE;
        for(String noeud : noeuds )
        {
            double valeur = v.getValeur(noeud);
            if(valeur<minValeur)
            {
                minValeur = valeur;
                minNoeud = noeud;
            }
        }
        return minNoeud;
    }
}
