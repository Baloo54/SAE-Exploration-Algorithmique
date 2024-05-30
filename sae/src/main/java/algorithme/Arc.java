package algorithme;

/***
 * @version 1.0
 * @autor : Comte Gabriel
 * @autor : Fuchs Thomas
 * Permet de stocker créer un arc
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
    /**
     * getter de la destination
     * @return la destination
     */
    public String getDest() {
        return dest;
    }
    /**
     * setter de la destination
     * @param dest la destination
     */
    public void setDest(String dest) {
        this.dest = dest;
    }
    /**
     * getter du cout
     * @return le cout
     */
    public double getCout() {
        return cout;
    }
    /**
     * setter du cout
     * @param cout le cout
     */
    public void setCout(double cout) {
        this.cout = cout;
    }
    /**
     * toString de l'arc
     * @return la destination et le cout
     */
    public String toString()
    {
        return dest + "(" + (int)Math.round(cout) + ")";
    }
}