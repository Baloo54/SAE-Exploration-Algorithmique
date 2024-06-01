package algorithme.graphe;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @autor : Comte Gabriel
 * @autor : Fuchs Thomas
 * Permet de stocker un graphe sous forme de liste
 */
public class GrapheListe
{
    /**
     * attributs pour stocker les informations
     * - noeuds : liste des noeuds
     * - adjacence : liste des arcs
     */
    private ArrayList<String> noeuds;
    private ArrayList<Arcs> adjacence;
    private String firstNode = null;
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
     * @return l'indice du noeud et -1 si le noeud n'est pas present
     */
    public int getIndice(String n)
    {
        if(this.noeuds.indexOf(n)==-1)
        {
            throw new IllegalArgumentException("Noeud non présent dans le graphe");
        }
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
        if(depart == null){
            throw new IllegalArgumentException("Noeud de départ null");   
        }//verifie si le noeud n'est pas deja present
        else if(!this.noeuds.contains(depart))
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
    public List<Arc> suivants(String n)
    {   
        int indice = getIndice(n);
        List<Arc> res=this.adjacence.get(indice).getArcs();
        return res;
    }
    /**
     * @return 
     * Retourne la liste des noeuds du graphe
     */
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
     /**
     * methode setFirstNode
     * @String
     */
    public void setFirstNode(String firstNode){
        if(firstNode == null){
            throw new IllegalArgumentException("Noeud de départ null");   
        }else if(!this.noeuds.contains(firstNode)){
            throw new IllegalArgumentException("Noeud de départ non présent dans le graphe");
        }else{
            this.firstNode = firstNode;
        }
    }
    /**
     * 
     * méthode qui donne le premier noeud du graphe
     * @param g
     * @return String
     */
    public String getFirstNode(){
        return firstNode;
    }
}
