
public class Dijkstra {
    Prioritiätswarteschlange schlange;

    /* void GraphInit()
     * @params: Graph G, int startIndex
     * Initialisierung des Graphen
     */
    private void GraphInit(Graph G, int startIndex) {
        for (int i = 0; i < G.anzahlGeben(); i++) {
            Knoten kl[] = G.knotenlisteGeben();
            kl[i].vorgängerSetzen(null);
            kl[i].pfadgewichtSetzen(99999);
        }
        
        G.knotenlisteGeben()[startIndex].pfadgewichtSetzen(0);
    }

    /* void dijkstra_algorithmus()
     * @params: Graph G, int startIndex
     * Ausführung des Dijkstraalgorithmus
     */
    private void dijkstra_algorithmus(Graph G, int startIndex) {
        GraphInit(G, startIndex);

        schlange = new Prioritiätswarteschlange(G.anzahlGeben());

        for (int i = 0; i < G.anzahlGeben(); i++) {
            schlange.knotenEinfügen(G.knotenlisteGeben()[i]);
        }

        while(!schlange.istLeer()) {
            Knoten k = schlange.firstOut();
            int indexK  = G.knotenIndexSuchen(k.inhaltGeben().nameGeben());

            for(int j = 0; j < G.anzahlGeben(); j++) {
                if (G.matrixGeben()[indexK][j] >= 0) {
                    relaxation(G, indexK, j);
                }
            }
        }

    }

    /* void relaxation
     * @params: Graph G, int uIndex, int vIndex
     * Relaxationsschritt für den Dijkstraalgorithmus
     */
    private void relaxation(Graph G, int uIndex, int vIndex) {
        int uGewicht = G.knotenlisteGeben()[uIndex].pfadgewichtGeben();
        int vGewicht = G.knotenlisteGeben()[vIndex].pfadgewichtGeben();
        int kantengewicht = G.matrixGeben()[uIndex][vIndex];

        if (vGewicht > uGewicht + kantengewicht) {
            G.knotenlisteGeben()[vIndex].pfadgewichtSetzen(uGewicht + kantengewicht);
            G.knotenlisteGeben()[vIndex].vorgängerSetzen(G.knotenlisteGeben()[uIndex]);
        }  
    }

    /* Knoten [] wegFinden()
     * @params: int startIndex als Index des Startknoten, int zielIndex als Index des Zielknotens
     * kürzesten Weg der gewünschten Route nach Dijkstra finden und als Feldfreihenfolge ausgeben
     * return: Knoten array mit Route in Reihenfolge Ziel-Startknoten
     */
    private Knoten [] wegFinden(Graph G, int startIndex, int zielIndex) {
        Knoten v;
        Knoten [] reihenfolge = new Knoten[G.anzahlGeben()];
        int counter = 1;

        reihenfolge[0] = G.knotenlisteGeben()[zielIndex];
        v = G.knotenlisteGeben()[zielIndex].vorgängerGeben();

        while (true) {
            reihenfolge[counter] = v.vorgängerGeben();
            v = v.vorgängerGeben();
            counter++; 
            if (v == null) {
                break;
            }
        }

        return reihenfolge;
    }

    /* Knoten[] routeStartUp
     * @params: Graph G, int startIndex, int zielIndex
     * return: Knoten[] route
     * Ausführung des Dijkstra-Algorithmus
     */
    public Knoten [] routeStartUp(Graph G, int startIndex, int zielIndex) {
        Knoten [] temp = new Knoten[G.anzahlGeben()];
        int j = 0;

        dijkstra_algorithmus(G, startIndex);
        temp = wegFinden(G, startIndex, zielIndex);
        for (int i = 0; i < G.anzahlGeben(); i++) {
            if (temp[i] == null) {
                break;
            }
            j++;
        }

        int a = 0;
        Knoten[] route = new Knoten[j];
        for (int k = j - 1; k <= 0; k--) {
            route[a] = temp[k];
            a++;
        }

        return route;
    }

}