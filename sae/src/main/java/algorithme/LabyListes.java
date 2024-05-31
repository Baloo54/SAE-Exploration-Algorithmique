package algorithme;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/**
 * Classe LabyListes qui permet de générer une lite de GrapheListe avec les fichiers texte
 * @version 1.0
 * @autor : Comte Gabriel
 * @autor : Fuchs Thomas
 */
public class LabyListes extends buildListe
{
    /**
     * fonction getVoisin qui permet de retourner les voisins d'un sommet
     * @param x
     * @param y
     * @param Base
     * @return ArrayList<String>
     */
    public List<String> getVoisin(int x, int y, String[][] Base){
        List<String> res = new ArrayList<>();
        String s;
        int [][] deplacement = {{x+1, y}, {x-1, y}, {x, y+1}, {x, y-1}, {x+1, y+1}, {x-1, y-1}, {x+1, y-1}, {x-1, y+1}};
        for (int[] d : deplacement) {
            if(d[0] >= 0 && d[0] < Base.length && d[1] >= 0 && d[1] < Base[0].length){
                if(Base[d[0]][d[1]].equals(".")){
                    s = x + "" + y+","+d[0] + "" + d[1]+",1";
                    res.add(s);
                }else{
                    s = x + "" + y+","+d[0] + "" + d[1]+",0";
                    res.add(s);
                }
            }
        }
        return res;
    }
    /**
     * fonction qui lit un fichier pour construire un graphe
     * @param file
     */
    public void lireFichier(String file, String folder, ArrayList<GrapheListe> graphe) {
        try (BufferedReader bf = new BufferedReader(new FileReader(new File(folder +"/"+ file)))) {
            String line;
            GrapheListe gl = new GrapheListe();
            String[][] Base = new String[Integer.parseInt(bf.readLine())][Integer.parseInt(bf.readLine())]; 
            int i = 0, j = 0;
            while((line = bf.readLine())!=null){
                String[] LineListe = line.split("");
                for (String s : LineListe) {
                    Base[i][j] = s;
                    j++;
                }
                i++;
                j = 0;
            }
            boolean first = false;
            for (int x = 0; x < Base.length; x++) {
                for (int y = 0; y < Base[0].length; y++) {  
                    if(!first && Base[x][y].equals(".")){
                        gl.setFirstNode(x + "" + y);
                        first = true;
                    }
                    List<String> voisin = getVoisin(x, y, Base);
                    for (String v : voisin) {
                        String[] vSplit = v.split(",");
                        Double cout = Double.parseDouble(vSplit[2]) == 1 ? 1.0 : Double.MAX_VALUE;
                        gl.ajouterArc(vSplit[0], vSplit[1], cout);
                    }
                }
            }
            graphe.add(gl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
