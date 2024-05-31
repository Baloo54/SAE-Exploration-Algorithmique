package algorithme;
import java.util.ArrayList;
import java.util.List;


public interface LabyAlgo
{
    public void lireFichier(String file, String folder,ArrayList<GrapheListe> graphe);

    public List<String> lireDossier();

    public void buildList();
}
