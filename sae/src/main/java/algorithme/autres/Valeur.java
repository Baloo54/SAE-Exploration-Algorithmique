package algorithme.autres;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Classe fournie, permet de stocker des valeurs associées au noeud et des parents
 * - un noeud est represente par un String (son nom)
 * - on accede avec des get (getValeur et getParent)
 * - on modifie avec des set (setValeur et setParent)
 */
public class Valeur {

    /**
     * attributs pour stocker les informations (type Table = Dictionnaire)
     * dans le programme de 2 annee.
     */
    Map<String, Double> valeur;
    Map<String, String> parent;
    
    /**
     * constructeur vide (initialise la possibilité de stocker des valeurs)
     */
    public Valeur() {
        this.valeur = new TreeMap<>();
        this.parent = new TreeMap<>();
    }

    /**
     * permet d'associer une valeur a un nom de noeud (ici L(X))
     *
     * @param nom    le nom du noeud
     * @param valeur la valeur associée
     */
    public void setValeur(String nom, double valeur) {
        if (nom != null) {
            this.valeur.put(nom, valeur < 0 ? 0 : valeur);
        }else{
            throw new IllegalArgumentException("Le nom du noeud ne peut pas être null");
        }
    }

    /**
     * * permet d'associer un parent a un nom de noeud (ici parent(X))
     *
     * @param nom    nom du noeud
     * @param parent nom du noeud parent associe
     */
    public void setParent(String nom, String parent) {
        if (nom != null) {
            this.parent.put(nom, parent);
        }else{
            throw new IllegalArgumentException("Le nom du noeud ne peut pas être null");
        }
    }

    /**
     * accede au parent stocke associe au noeud nom passe en parametre
     *
     * @param nom nom du noeud
     * @return le nom du noeud parent
     */
    public String getParent(String nom) {
        if (nom == null) {
            throw new IllegalArgumentException("Le noeud ne peut pas être null");
        }else if (this.parent.containsKey(nom)) {
            return this.parent.get(nom);
        } else {
            throw new IllegalArgumentException("Le noeud n'a pas de parent");
        }
    }


    /**
     * accede a la valeur associee au noeud nom passe en parametre
     *
     * @param nom nom du noeud
     * @return la valeur stockee 
     */
    public double getValeur(String nom) {
        if (nom == null) {
            throw new IllegalArgumentException("Le noeud ne peut pas être null");
        }else if (this.valeur.containsKey(nom)) {
            return this.valeur.get(nom);
        } else {
            throw new IllegalArgumentException("Le noeud n'existe pas dans la liste des noeuds stockés");
        }
    }

        /**
         * retourne une chaine qui affiche le contenu
         * - par noeud stocke
         * - a chaque noeud, affiche la valeur puis le noeud parent
     *
     * @return descriptif du noeud
     */
    public String toString() {
        String res = "";
        // pour chaque noeud
        for (String s : this.valeur.keySet()) {
            // ajoute la valeur et le noeud parent
            Double valeurNoeud = valeur.get(s);
            String noeudParent = parent.get(s);
            res += s + " ->  V:" + valeurNoeud + " p:" + noeudParent + "\n";
        }
        return res;
    }
    /**
     * fonction qui retourne le chemin entre le noeud de départ et le noeud d'arrivée
     * @param destination noeud d'arrivée
     * @return List<String> chemin
     */
    public List<String> chemin(String destination){
        if (destination == null) {
            throw new IllegalArgumentException("Le noeud d'arrivée ne peut pas être null");
        }
        List<String> chemin = new ArrayList<>();
        String noeud = destination;
        // tant que le noeud n'est pas null
        while (noeud != null){
            chemin.add(noeud);
            noeud = parent.get(noeud);
        }
        return chemin;
    }
}
