package algorithme;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstract permettant de construire une liste de graphe
 * @version 1.0
 * @autor : Comte Gabriel
 * @autor : Fuchs Thomas
 */
public abstract class buildListe
{
     /**
     * abstract méthode qui lit un fichier pour construire un graphe
     * @param file
     */
    public abstract void lireFichier(String file, String folder, ArrayList<GrapheListe> graphe);
    /**
     * permet de faire une liste de tous les fichiers se trouvant dans Ressource/Graphe
     * @param dossier à lire
     * @return List<String>
     */
    public List<String> lireDossier(String dossier){
        try {
            File folder = new File(dossier);
            File[] listeOfFile = folder.listFiles();
            List<String> res = new ArrayList<>();
            for(File f : listeOfFile){
                res.add(f.getName());
            }
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<String>();
        }
    }

    /**
     *  fonction qui permet de construire une liste de graphe à partir de fichiers
     */
    public ArrayList<GrapheListe> buildList(String folder) {
        ArrayList<GrapheListe> graphe = new ArrayList<GrapheListe>();
        List<String> liste = lireDossier(folder);
        for (String file : liste) {
            lireFichier(file, folder ,graphe);
        }return graphe;
    }
}
