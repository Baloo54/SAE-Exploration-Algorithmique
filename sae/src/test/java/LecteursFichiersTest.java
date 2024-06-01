import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import algorithme.chargerFichiers.LabyListes;
import algorithme.chargerFichiers.GrapheListes;
import algorithme.graphe.GrapheListe;

/**
 * Test de la classe GrapheListes
 * @version 1.0
 * @autor : Comte Gabriel
 * @autor : Fuchs Thomas
 */
public class LecteursFichiersTest {
    //Test de la fonction lireFichier
    @Test
    public void testLireFichier(){
        GrapheListes gl = new GrapheListes();
        LabyListes ll = new LabyListes();
        gl.buildList("sae/src/main/resources/Graphes/");
        ll.buildList("sae/src/main/resources/labySimple/");
    }
    //Test de la fonction lireFichier avec un dossier incorrect
    @Test
    public void testLireFichierDossierIncorrect(){
        GrapheListes gl = new GrapheListes();
        LabyListes ll = new LabyListes();
        assertThrows(IllegalArgumentException.class, () -> {
            gl.lireFichier("ezlknfzjoago", "fjqzhfui", new ArrayList<GrapheListe>());
        });
        assertThrows(IllegalArgumentException.class, () -> {
            ll.lireFichier("ezlknfzjoago", "fjqzhfui", new ArrayList<GrapheListe>());
        });
    }

}
