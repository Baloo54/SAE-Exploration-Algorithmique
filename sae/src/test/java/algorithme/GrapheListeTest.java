package algorithme;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrapheListeTest
{

    @Test
    public void testGraphe1()
    {

        GrapheListe graphe = new GrapheListe();

        graphe.ajouterArc("A","B",10);
        graphe.ajouterArc("B","C",20);



    }


}