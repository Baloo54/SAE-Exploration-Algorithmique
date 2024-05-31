package algorithme;

import java.util.ArrayList;
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
public class GrapheListes  extends buildListe{
    /**
     * fonction qui lit un fichier pour construire un graphe
     * @param file
     */
    public void lireFichier(String file, String folder, ArrayList<GrapheListe> graphe) {
        try (BufferedReader bf = new BufferedReader(new FileReader(new File(folder +"/"+ file)))) {
            String line;
            GrapheListe gl = new GrapheListe();
            boolean first = false;
            while((line = bf.readLine())!=null){
                String[] LineListe = line.split("\t");
                // permet de recuperer le premier noeud
                if(!first){
                    gl.setFirstNode(LineListe[0]);
                    first = true;
                }
                gl.ajouterArc(LineListe[0], LineListe[1], Double.parseDouble(LineListe[2]));
            }
            graphe.add(gl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
