package algorithme;
/**
 * Interface qui permet de définir les méthodes que doit implémenter un algorithme
 * de résolution de graphe
 * @version 1.0
 * @autor : Comte Gabriel
 * @autor : Fuchs Thomas
 */
public interface Algorithme {
    /**
     * Méthode qui permet de résoudre un graphe
     * @param g graphe
     * @param depart point de départ
     * @return Valeur
     */
    public Valeur resoudre(GrapheListe g, String depart);
}
