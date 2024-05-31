package algorithme;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

/**
 * Class GrapheListes qui permet de générer une lite de 
 * GrapheListe avec les fichiers texte
 * @author Comte Gabriel
 * @author Fucsh Thomas
 * @version 1.0
 */
public class GrapheListes {
    /**
     * fonction qui lit un fichier pour construire un graphe
     * @param file
     */
    public void lireFichier(String file, String folder, ArrayList<GrapheListe> graphe) {
        try (BufferedReader bf = new BufferedReader(new FileReader(new File(folder +"/"+ file)))) {
            String line;
            GrapheListe gl = new GrapheListe();
            while((line = bf.readLine())!=null){
                String[] LineListe = line.split("\t");
                gl.ajouterArc(LineListe[0], LineListe[1], Double.parseDouble(LineListe[2]));
            }
            graphe.add(gl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
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
