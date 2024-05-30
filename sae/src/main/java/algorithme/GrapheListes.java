package algorithme;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
     * Attribut 
     * Une liste de GrapheListe
     */
    private ArrayList<GrapheListe> graphe = new ArrayList<GrapheListe>();
    /**
     * Constructeur de la classe GrapheListes
     * @param folder
     */
    public GrapheListes(String folder) {
        graphe = new ArrayList<GrapheListe>();
        List<String> liste = lireDossier(folder);
        for (String file : liste) {
            lireFichier(folder+file);
        }
    }
    /**
     * fonction qui lit un fichier pour construire un graphe
     * @param file
     */
    public void lireFichier(String file) {
        try (BufferedReader bf = new BufferedReader(new FileReader(new File(file)))) {
            String line;
            GrapheListe gl = new GrapheListe();
            while((line = bf.readLine())!=null){
                String[] LineListe = line.split(" ");
                gl.ajouterArc((String)LineListe[0], (String)LineListe[1], Double.parseDouble(LineListe[2]));
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
        try (Stream<Path> paths = Files.walk(Paths.get(dossier))) {
        return paths
            .filter(Files::isRegularFile)
            .map(Path::getFileName)
            .map(Path::toString)
            .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    public ArrayList<GrapheListe> getGraphe() {
        return graphe;
    }
}
