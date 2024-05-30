import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import algorithme.*;
public class testGrapheListe {
    // test création d'un graphe simple
    @Test
    public void testGrapheListe() {
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A", "B", 12);
        graphe.ajouterArc("A", "D", 87);
        graphe.ajouterArc("B", "E", 11);
        graphe.ajouterArc("E", "D", 43);
        graphe.ajouterArc("D", "B", 23);
        graphe.ajouterArc("D", "C", 10);
        graphe.ajouterArc("C", "A", 19);
        System.out.println(graphe);
    }
    // lancement des tests
    public static void main(String[] args) {
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(() -> {
            testGrapheListe test = new testGrapheListe();
            test.testGrapheListe();
        });
    }
}


