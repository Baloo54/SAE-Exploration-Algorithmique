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
        if(c < 0 || d == null)
        {
            throw new IllegalArgumentException("Le cout doit être positif et la destination non nulle");
        }else
        {
            this.dest = d;
            this.cout = c;
        }
    }
    /**
     * getter de la destination
     * @return la destination
     */
    public String getDest() 
    {   
        if(this.dest==null)
        {
            throw new IllegalArgumentException("Les ne peut pas être nulle");
        }
        return dest;
    }
    /**
     * setter de la destination
     * @param dest la destination
     */
    public void setDest(String dest) {
        if(dest == null)
        {
            throw new IllegalArgumentException("La destination ne doit pas être nulle");
        }
    }
    /**
     * getter du cout
     * @return le cout
     */
    public double getCout()
    {   
        if(this.cout<0)
        {
            throw new IllegalArgumentException("Le cout ne peut être négatif");
        }
        return cout;
    }
    /**
     * setter du cout
     * @param cout le cout
     */
    public void setCout(double cout) {
        if(cout < 0)
        {
            throw new IllegalArgumentException("Le cout doit être positif");
        }
    }
    /**
     * toString de l'arc
     * @return la destination et le cout
     */
    public String toString()
    {
        return dest + "(" + (int)Math.round(cout) + ")";
    }
    /**
     * méthode equals
     * @param o l'objet a comparer
     * @return true si les objets sont égaux, false sinon
     */
    public boolean equals(Object o)
    {
        if(o instanceof Arc)
        {
            Arc a = (Arc) o;
            return this.dest.equals(a.getDest()) && this.cout == a.getCout();
        }
        return false;
    }
}