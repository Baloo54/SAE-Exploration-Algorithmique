package algorithme;

/***
 * @version 1.0
 * @autor : Comte Gabriel
 * @autor : Fuchs Thomas
 * Classe fournie, permet de stocker créer un arc
 * - un arc est represente par une destination et un cout
*/
public class Arc
{
    /**
     * attributs pour stocker les informations
     * - dest : destination de l'arc
     * - cout : cout de l'arc
     */
    private String dest;
    private double cout;
    /**
     * constructeur d'un arc
     * @param d destination
     * @param c cout
     */
    public Arc(String d, double c)
    {
        this.dest=d;
        // on ne veut pas de cout negatif
        this.cout = c < 0 ? -c : c;
    }
}